package com.example.cameratest

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var cameraBtn: Button
    private lateinit var myImage: ImageView
    private val cameraRequestId = 1222

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        cameraBtn = findViewById(R.id.camera)
        myImage = findViewById(R.id.imageView)

        cameraBtn.setOnClickListener{
            val cameraInt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraInt,cameraRequestId)
        }




    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        /// PUT CODE HERE

        if (requestCode == cameraRequestId){
            val images: Bitmap = data?.extras?.get("data") as Bitmap
            myImage.setImageBitmap(images)
        }
    }
}