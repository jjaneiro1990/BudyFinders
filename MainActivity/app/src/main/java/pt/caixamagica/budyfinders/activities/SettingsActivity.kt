package pt.caixamagica.budyfinders.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.databinding.ActivitySettingsBinding

class SettingsActivity : AppCompatActivity() {
    private var binding : ActivitySettingsBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }
}