package com.mvp.sample.webservice

import com.mvp.sample.data.Photo
import com.mvp.sample.data.Place
import com.mvp.sample.data.Post
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface IApi {

    @POST("user/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST("user/register")
    fun register(@Body request: RegisterRequest): Call<RegisterResponse>

    @GET("places")
    fun getPlaces(): Call<List<Place>>

    @GET("posts")
    fun getPosts(): Call<List<Post>>

    @GET("photos")
    fun getPhotos(): Call<List<Photo>>

}