package com.example.jointseminarably.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AblyApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}