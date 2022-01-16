package kg.geektech.homework1kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kg.geektech.homework1kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    private val resultContract = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode==1){
            var text2 = it.data?.getStringExtra(key2)
            binding.etInput.setText(text2)
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSend.setOnClickListener {
            if(binding.etInput.text.toString().isBlank()){
                Toast.makeText(this,toastText,Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra(key,binding.etInput.text.toString())
                resultContract.launch(intent)
            }
        }
    }

    companion object{
        const val key = "key"
        const val key2 = "key2"
        const val toastText = "пустое поле"
    }
}