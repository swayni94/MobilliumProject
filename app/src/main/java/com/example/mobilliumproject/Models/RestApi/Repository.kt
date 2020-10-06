package com.example.mobilliumproject.Models.RestApi

import com.example.mobilliumproject.Models.RepoResult

class Repository(private val service : IService) : SafeApiRequest() {
    suspend fun fechFullData():List<RepoResult>{
        val response = apiRequest{ service.getRepositories() }

        return response
    }
}