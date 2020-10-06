package com.example.mobilliumproject.Models.RestApi

import com.example.mobilliumproject.Models.RepoResult
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface IService {
    @GET("api/v2/discover")
    suspend fun getRepositories() : Response<List<RepoResult>>

    companion object{
        operator fun invoke(networkConnectionInterceptor:NetworkConnectionInterceptor):IService {
            val okHttpClient = OkHttpClient.Builder().addInterceptor(networkConnectionInterceptor).build()

            return Retrofit.Builder().client(okHttpClient).baseUrl("https://www.vitrinova.com/").
                addConverterFactory(GsonConverterFactory.create()).build().create(IService::class.java)
        }
    }
}