package com.example.myapplication

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.myapplication.models.User
import com.example.myapplication.repository.MainRepository

class MainViewModel : ViewModel() {

    private var _userId: MutableLiveData<String> = MutableLiveData()

     var user: LiveData<User> = Transformations
        .switchMap(_userId) {
            MainRepository.getUser(it)
        }

    fun setUserId(userId: String) {

        if (_userId.value == userId) {
            return
        }

        _userId.value = userId
    }


    fun cancellJob() {
        MainRepository.cancellJob()
    }
}