package com.example.profileapp.mainModule.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.profileapp.R
import com.example.profileapp.databinding.ActivityMainBinding
import com.example.profileapp.mainModule.viewModels.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var mainViewModel = MainViewModel()
    private var imageUri = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imgOpenGallery.setOnClickListener{
           chooseImage()
        }
    }
    private fun chooseImage(){
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        galleryLauncher.launch(intent)
    }

    private val galleryLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val image = result.data
            imageUri = image!!.data.toString()
            mainViewModel.putImage(binding.imgProfile, imageUri)
        }
    }

}