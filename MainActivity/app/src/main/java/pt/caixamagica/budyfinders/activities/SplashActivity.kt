package pt.caixamagica.budyfinders.activities

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.activities.firebase.FirestoreClass
import pt.caixamagica.budyfinders.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {
    private var binding : ActivitySplashBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val typeface : Typeface = Typeface.createFromAsset(assets,"carbonbl.otf")
        binding?.tvAppName?.typeface = typeface

        Handler().postDelayed({
            var currentUserID = FirestoreClass().getCurrentUserID()
            if(currentUserID.isNotEmpty()){
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, IntroActivity::class.java))
            }

            finish()
        },2500)
    }
}