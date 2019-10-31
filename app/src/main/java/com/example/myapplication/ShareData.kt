package com.example.myapplication

import android.app.Application
import android.content.Context
import android.os.Bundle

import android.widget.Button

class ShareData : Application() {

    public var ColorCode   : Int = -1
    public var ButtonEnable: Boolean = true

    fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate()
    }

}