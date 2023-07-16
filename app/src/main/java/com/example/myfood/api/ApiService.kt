package com.example.myfood.api

import com.example.myfood.model.ResponseGetFood
import com.example.myfood.model.auth.ResponseAuth
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("getMakanan")
    fun  getFood() : Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("insertMakanan")
    fun insertMakanan(
        @Field("name") menuNama: String,
        @Field("price") menuHarga: String,
        @Field("gambar") menuGambar: String,
    ): Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("updateMakanan")
    fun updateMakanan(
        @Field("id") id: String,
        @Field("name") menuNama: String,
        @Field("price") menuHarga: String,
        @Field("gambar") menuGambar: String,
    ): Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("deleteMakanan")
    fun deleteFood(@Field("id") id : String): Call<ResponseGetFood>

    @FormUrlEncoded
    @POST("login")
    fun loginUserModel(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Call<ResponseAuth>


}