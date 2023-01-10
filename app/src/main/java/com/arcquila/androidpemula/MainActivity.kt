package com.arcquila.androidpemula

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.arcquila.androidpemula.belajarFragment.ShowActivity
import com.arcquila.androidpemula.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var _binding: ActivityMainBinding
    val binding get() = _binding

    val REQUEST_IMAGE_CAPTURE = 1
    val REQUEST_CODE_IMAGE_PICKER = 100
    val getContent =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == MainActivity2.RESULT_CODE && result.data != null) {
                val selectedValue = result.data?.getStringExtra(MainActivity2.EXTRA_DATA1)
                binding.btnKirim.text = selectedValue

            }
        }

    val getData = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it != null) {
            binding.ivView.setImageURI(it)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()


    }

    private fun getImage() {
        getData.launch("image/*")

    }


    private fun initUI() {
        binding.apply {
            btnKirim.setOnClickListener(this@MainActivity)
            btnImplicit.setOnClickListener(this@MainActivity)
            btnImagePicker.setOnClickListener(this@MainActivity)
            btntoFragment.setOnClickListener(this@MainActivity)
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnKirim -> sendData()
//            R.id.btnImplicit -> goToGallery()
            R.id.btnImagePicker -> getImage()
            R.id.btntoFragment -> toShowActivity()
        }
    }

    private fun toShowActivity() {
        val intent = Intent(this@MainActivity, ShowActivity::class.java)
        startActivity(intent)
    }

    private fun goToPickUp() {
        val moveForResult = Intent(this@MainActivity, MainActivity2::class.java)


        getContent.launch(moveForResult)


    }


    private fun sendData() {
        val data1 = binding.etData1.text.toString()
        val data2 = binding.etData2.text.toString()
        val dataParcelable = Name(
            data1,
            data2
        )

        print(dataParcelable)

        val intent = Intent(this@MainActivity, MainActivity2::class.java)
/*        intent.putExtra(MainActivity2.EXTRA_DATA1, data1)
        intent.putExtra(MainActivity2.EXTRA_DATA2,data2)*/
        intent.putExtra(MainActivity2.EXTRA_NAME, dataParcelable)
        startActivity(intent)


    }


}