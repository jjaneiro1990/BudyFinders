package pt.caixamagica.budyfinders.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.activities.firebase.FirestoreClass
import pt.caixamagica.budyfinders.databinding.ActivitySignInBinding
import pt.caixamagica.budyfinders.models.User

class SignInActivity : SupportActivity() {
    private lateinit var auth: FirebaseAuth
    private var binding : ActivitySignInBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        auth = FirebaseAuth.getInstance()
        
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setupActionBar()

        binding?.btnSignIn?.setOnClickListener {
            signInUser()
        }
    }

    private fun setupActionBar(){
        setSupportActionBar(binding?.toolbarSignInActivity)
        val actionBar = supportActionBar
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.setHomeAsUpIndicator(R.drawable.ic_vector_back)
        }
        binding?.toolbarSignInActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

    }

    private fun signInUser() {
        val email : String = binding?.etEmail?.text.toString()
        val password : String = binding?.etPassword?.text.toString()
        if(validateInput(email, password)){
            showProgressDialog("Please wait")
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this){
                task -> hideProgressDialog()
                if(task.isSuccessful){
                    FirestoreClass().loadUserData(this)
                }else{
                    Log.w("Sign in", "signInWithEmail:failure", task.exception)
                    val user = auth.currentUser
                    Toast.makeText(baseContext, "Auth Failed",Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun validateInput(email: String, password: String): Boolean {
        return when {
            TextUtils.isEmpty(email) -> {
                Toast.makeText(this,"Please enter an email", Toast.LENGTH_SHORT).show()
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

    fun signInSuccess(loggedInUser: User) {
        hideProgressDialog()
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }
}