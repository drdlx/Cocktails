package com.example.cocktails.core.app

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class App @Inject constructor(): Application() {

    companion object {
        private const val TAG = "App"
    }

}