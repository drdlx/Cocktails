package com.example.cocktails.app

import android.app.Application

class App: Application() {

    companion object {
        private const val TAG = "App"
    }

    override fun onCreate() {
        super.onCreate()
    }
}