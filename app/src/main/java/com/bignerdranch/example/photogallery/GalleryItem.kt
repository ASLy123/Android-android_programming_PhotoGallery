package com.bignerdranch.example.photogallery

import com.google.gson.annotations.SerializedName

data class GalleryItem(
    var title: String = "",
    var id: String = "",
    @SerializedName("url_s") var url: String = ""
    //让Gson知道GalleryItem.url属性是和哪一个JSON字段相对应的
)