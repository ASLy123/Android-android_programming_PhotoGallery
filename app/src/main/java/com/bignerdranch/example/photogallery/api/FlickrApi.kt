package com.bignerdranch.example.photogallery.api

import retrofit2.Call
import retrofit2.http.GET

interface FlickrApi{
//    @GET("/")           //把fetchContents()函数返回的Call配置成一个GET请求
//    fun fetchContents(): Call<String>

    @GET("services/rest/?method=flickr.interestingness.getList" +
                "&api_key=f2bb958a33513270eef1310dad03440a"+
                "&format=json" +
                "&nojsoncallback=1" +       //为1就是告诉Flickr，返回的数据不应包括封闭方法名和括号
                "&extras=url_s"             //url_s的extras参数是告诉Flickr，如有小尺寸的图片，也一并提供它们的URL
    )
    fun fetchPhotos(): Call<FlickrResponse> //定义获取图片的网络请求
}