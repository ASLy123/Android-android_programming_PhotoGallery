package com.bignerdranch.example.photogallery

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bignerdranch.example.photogallery.api.FlickrApi
import com.bignerdranch.example.photogallery.api.FlickrResponse
import com.bignerdranch.example.photogallery.api.PhotoResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "FlickrFetchr"
class FlickrFetchr {
    private val flickrApi: FlickrApi
    init {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://api.flickr.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        flickrApi = retrofit.create(FlickrApi::class.java)
    }

    fun fetchPhotos(): LiveData<List<GalleryItem>> {     //把网络请求放入任务队列，然后把结果封装在LiveData里
//        val responseLiveData: MutableLiveData<String> = MutableLiveData()
        val responseLiveData: MutableLiveData<List<GalleryItem>> = MutableLiveData()
        val flickrRequest: Call<FlickrResponse> = flickrApi.fetchPhotos()         //把抓取Flickr主页的网络请求加入任务队列
        flickrRequest.enqueue(object :Callback<FlickrResponse>{
            override fun onFailure(call: Call<FlickrResponse>, t: Throwable) {
                Log.e(TAG, "Failed to fetch photos", t)
            }
            override fun onResponse(
                call: Call<FlickrResponse>,
                response: Response<FlickrResponse>
            ) {
                Log.d(TAG, "Response received")
//                responseLiveData.value = response.body()
                val flickrResponse: FlickrResponse? = response.body()
                val photoResponse: PhotoResponse? = flickrResponse?.photos
                var galleryItems: List<GalleryItem> = photoResponse?.galleryItems ?: mutableListOf()

                //过滤空url_s值的图片
                galleryItems = galleryItems.filterNot {
                    it.url.isBlank()
                }
                responseLiveData.value = galleryItems
            }
        })

        return responseLiveData
    }
}