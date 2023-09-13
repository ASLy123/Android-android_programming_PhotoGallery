package com.bignerdranch.example.photogallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class PhotoGalleryViewModel: ViewModel() {
    val galleryItemLiveData: LiveData<List<GalleryItem>> = FlickrFetchr().fetchPhotos()
    //发起了下载图片数据的网络请求


}