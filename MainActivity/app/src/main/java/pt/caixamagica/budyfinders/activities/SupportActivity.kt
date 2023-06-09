package pt.caixamagica.budyfinders.activities

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import pt.caixamagica.budyfinders.R
import pt.caixamagica.budyfinders.databinding.DialogProgressBinding

open class SupportActivity : AppCompatActivity() {
private lateinit var mProgressDialog : Dialog
private var dialogBinding : DialogProgressBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_support)
    }

    fun showProgressDialog(text:String){
    mProgressDialog = Dialog(this)
    dialogBinding = DialogProgressBinding.inflate(layoutInflater)
    mProgressDialog.setContentView(dialogBinding?.root!!)
    dialogBinding?.tvProgress?.text = text
    mProgressDialog.show()

    }

    fun hideProgressDialog(){
        mProgressDialog.dismiss()
    }
}