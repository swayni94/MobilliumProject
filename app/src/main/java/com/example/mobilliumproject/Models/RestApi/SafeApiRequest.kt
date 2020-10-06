package com.example.mobilliumproject.Models.RestApi

import android.util.Log
import com.example.mobilliumproject.until.ApiException
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response


abstract class SafeApiRequest {

    suspend fun <T:Any> apiRequest(call: suspend () -> Response<T>):T{

        val response = call.invoke()
        val message = StringBuilder()

        if (response.isSuccessful){
            Log.d("successful", "response is successful")
            return response.body()!!
        }else{
            val error=response.errorBody()?.string()
            error?.let {
                try {
                    message.append(JSONObject(it).getString("message"))
                }catch (e : JSONException){
                    message.append("\n")
                }
            }
        }
        message.append("\nError code ${response.code()}")
        Log.d("hellohello","safeapireqfail 00000+${response.code()} ")
        throw ApiException(message.toString())
    }
}