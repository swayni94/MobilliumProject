package com.example.mobilliumproject.viewModelsAndFactory

import android.util.Log
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilliumproject.Models.RepoResult
import com.example.mobilliumproject.Models.RestApi.Repository
import kotlinx.coroutines.launch

class MobilliumViewModel(private val repository: Repository) : ViewModel(){

    private var dataViewBinding: ViewDataBinding? = null

    private var fullData : List<RepoResult>? = null
    private val _fullDataM = MutableLiveData<List<RepoResult>>()

    val datas: LiveData<List<RepoResult>>?
        get() = _fullDataM

    init {
        Log.d("init", "init is successful")
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            try {
                fullData = repository.fechFullData()
                _fullDataM.value = fullData
                Log.d("getData", "getData is successful")
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}