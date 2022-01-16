package kg.geektech.homework1kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kg.geektech.homework1kotlin.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = intent

        val text: String? = intent.getStringExtra(key)
        binding.etInput.setText(text)

        binding.btnSend.setOnClickListener {
            if(binding.etInput.text.toString().isBlank()){
                Toast.makeText(this,toastText, Toast.LENGTH_LONG).show()
            }else {
                intent.putExtra(key2, binding.etInput.text.toString())
                setResult(1, intent)
                finish()
            }
        }
    }

    companion object{
        const val key = "key"
        const val key2 = "key2"
        const val toastText = "пустое поле"
    }
}
