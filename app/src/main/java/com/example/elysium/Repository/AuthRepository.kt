package com.example.elysium.Repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.elysium.models.User
import com.example.elysium.network.MyApi
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {

    fun loginuser(email: String, password: String, type:String): LiveData<String> {
        var user = User(email = email, password = password, type = type)
        val loginResponse = MutableLiveData<String>()
        MyApi().login(user)
            .enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("abc", t.message.toString())
                    loginResponse.value = t.message
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        loginResponse.value = "Login success!"//response.body().toString()
                        Log.d("abc", "success")
                    }

                }

            })
        return loginResponse
    }

    fun registerUser(user: User): LiveData<String> {
        val registerResponse = MutableLiveData<String>()
        MyApi().register(user)
            .enqueue(object : retrofit2.Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.d("abc", t.message.toString())
                    registerResponse.value = t.message
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    if (response.isSuccessful) {
                        registerResponse.value = "Login success!"//response.body().toString()
                        Log.d("abc", "success")
                    }
                }

            })

        return registerResponse
    }
}