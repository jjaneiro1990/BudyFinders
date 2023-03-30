package pt.caixamagica.budyfinders.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pt.caixamagica.budyfinders.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding : ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.ivSettings?.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }

        binding?.ivChat?.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }

        binding?.ivPin?.setOnClickListener {
            startActivity(Intent(this, ChatActivity::class.java))
        }

        binding?.ivHome?.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}