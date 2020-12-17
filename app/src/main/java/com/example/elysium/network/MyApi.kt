package com.example.elysium.network

import com.example.elysium.App.Config
import com.example.elysium.models.User
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

interface MyApi {

    @POST("auth/login")
    fun login(@Body user: User): Call<ResponseBody>

    @POST("auth/register")
    fun register(@Body user: User): Call<ResponseBody>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .baseUrl(Config.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MyApi::class.java)
        }
    }
}
