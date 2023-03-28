package pt.caixamagica.budyfinders.activities

import android.os.Bundle
import android.text.TextUtils
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.activities.firebase.FirestoreClass
import pt.caixamagica.budyfinders.databinding.ActivitySignUpBinding
import pt.caixamagica.budyfinders.models.User

class SignUpActivity : SupportActivity() {
    private var binding : ActivitySignUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setupActionBar()
    }

    private fun setupActionBar(){
        setSupportActionBar(binding?.toolbarSignUpActivity)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_vector_back)
        }
        binding?.toolbarSignUpActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.btnSignUp?.setOnClickListener {
            registerUser()
        }
    }

    private fun registerUser() {
        val name : String = binding?.etName?.text.toString().trim {
            it <= ' '
        }
        val email : String = binding?.etEmail?.text.toString().trim {
            it <= ' '
        }
        val password : String = binding?.etPassword?.text.toString().trim {
            it <= ' '
        }
        if(validateInput(name,email,password)){
            showProgressDialog("Please Wait")
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val firebaseUser: FirebaseUser = task.result!!.user!!
                        val registeredEmail = firebaseUser.email!!
                        val user = User(firebaseUser.uid, name, registeredEmail)
                        FirestoreClass().registerUser(this, user)
                    }else{
                        Toast.makeText(this, task.exception!!.message,Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

    private fun validateInput(name : String, email : String, password : String): Boolean {
        return when {
            TextUtils.isEmpty(name) -> {
                Toast.makeText(this,"Please enter a name",Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this,"Please enter an email",Toast.LENGTH_SHORT).show()
                false
            }
            TextUtils.isEmpty(password) -> {
                Toast.makeText(this,"Please enter a password", Toast.LENGTH_SHORT).show()
                false
            }else -> {
                true
            }
        }
    }

    fun userRegisteredSuccess() {
        Toast.makeText(this, "Success with registration",Toast.LENGTH_SHORT).show()
        hideProgressDialog()
        FirebaseAuth.getInstance().signOut()
        finish()
    }
}