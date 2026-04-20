package com.content.boockreaderapp.baseApplication

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application() {
    companion object {
        lateinit var mContext : Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        mContext = this
    }
}