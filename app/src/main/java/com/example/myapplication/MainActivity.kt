package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {


    private lateinit var viewmodel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewmodel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewmodel.user.observe(this, Observer {

            println("Debug : ${it.email}")
        })


        viewmodel.setUserId("1")

    }

    override fun onDestroy() {
        super.onDestroy()
        viewmodel.cancellJob()
    }


}
