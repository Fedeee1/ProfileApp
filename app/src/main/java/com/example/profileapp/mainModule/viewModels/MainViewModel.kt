package com.example.profileapp.mainModule.viewModels

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
class MainViewModel: AppCompatActivity() {
    fun putImage(imageView: ImageView, imageUri: String) {
        imageView.setImageURI(imageUri.toUri())
    }
}