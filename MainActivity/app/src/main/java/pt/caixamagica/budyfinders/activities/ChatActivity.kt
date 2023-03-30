package pt.caixamagica.budyfinders.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.databinding.ActivityChatBinding

class ChatActivity : AppCompatActivity() {
    private var binding : ActivityChatBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }
}