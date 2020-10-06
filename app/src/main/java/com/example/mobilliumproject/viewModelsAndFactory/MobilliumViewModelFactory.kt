package com.example.mobilliumproject.viewModelsAndFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mobilliumproject.Models.RestApi.Repository

@Suppress("UNCHECKED_CAST")
class MobilliumViewModelFactory (private val repository: Repository) :
    ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MobilliumViewModel(repository) as T
    }
}