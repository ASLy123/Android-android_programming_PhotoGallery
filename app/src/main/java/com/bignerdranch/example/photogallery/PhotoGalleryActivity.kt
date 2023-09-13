package com.bignerdranch.example.photogallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class PhotoGalleryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo_gallery)

        val isFragmentContainerEmpty = savedInstanceState == null   //检查fragment容器里是否已有被托管的fragment
        if (isFragmentContainerEmpty){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer
                ,PhotoGalleryFragment.newInstance())
                .commit()
        }
    }
}