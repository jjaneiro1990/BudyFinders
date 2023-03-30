package pt.caixamagica.budyfinders.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.databinding.ActivityPinBinding

class PinActivity : AppCompatActivity() {
    private var binding : ActivityPinBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPinBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}