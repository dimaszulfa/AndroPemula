package com.arcquila.androidpemula

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arcquila.androidpemula.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var _binding: ActivityMain2Binding
    val binding get() = _binding

    companion object {
        const val EXTRA_DATA1 = "EXTRA_DATA1"
        const val EXTRA_DATA2 = "EXTRA_DATA2"
        const val EXTRA_NAME = "EXTRA_NAME"
        const val RESULT_CODE = 110
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val data = binding.ngambilData.text.toString()
            val result = Intent()
            result.putExtra(EXTRA_DATA1, data)
            setResult(RESULT_CODE, result)
            finish()
        }

        val name = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_NAME, Name::class.java)
        } else {
            @Suppress("DEPRECATION") intent.getParcelableExtra(EXTRA_NAME)
        }

        if (name != null) {
            val text = StringBuilder(name.name + name.last)
            println(text)
            binding.tvResult.text = text
        }

/*        val data1 = intent.getStringExtra(EXTRA_DATA1)
        val data2 = intent.getStringExtra(EXTRA_DATA2)
        val result = StringBuilder(data1 + data2)
                    binding.tvResult.text = result
*/

    }
}