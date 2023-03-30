package pt.caixamagica.budyfinders.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.databinding.ActivityMyProfileBinding

class MyProfileActivity : AppCompatActivity() {
    private var binding : ActivityMyProfileBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMyProfileBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setupActionBar()
    }

    private fun setupActionBar() {
        TODO("Not yet implemented")
    }
}