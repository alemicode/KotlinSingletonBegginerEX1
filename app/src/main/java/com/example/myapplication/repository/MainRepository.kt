package com.example.myapplication.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.api.RetrofitBuilder
import com.example.myapplication.models.User
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import java.util.concurrent.CancellationException

object MainRepository {

    var job: CompletableJob? = null
    fun getUser(userId: String): LiveData<User> {

        job = Job()
        return object : LiveData<User>() {

            override fun onActive() {
                super.onActive()
                job?.let {
                    CoroutineScope(IO + it).launch {
                        var user = RetrofitBuilder.apiService.getUserById(userId)
                        withContext(Main) {

                            value = user
                            it.complete()
                        }
                    }
                }




            }
        }
    }


    fun cancellJob() {
        job?.cancel(CancellationException("job was cancelled"))
    }
}

