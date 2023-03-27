package pt.caixamagica.budyfinders.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {
    private var binding : ActivityIntroBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        binding?.btnSignIn?.setOnClickListener{
            startActivity(Intent(this, SignInActivity::class.java))
        }

        binding?.btnSignUp?.setOnClickListener{
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }
}