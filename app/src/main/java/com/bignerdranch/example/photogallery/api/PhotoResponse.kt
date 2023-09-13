package com.bignerdranch.example.photogallery.api

import com.bignerdranch.example.photogallery.GalleryItem
import com.google.gson.annotations.SerializedName

class PhotoResponse {       //存储图片集
    @SerializedName("photo")
    lateinit var galleryItems: List<GalleryItem>
}