package com.content.boockreaderapp.util

import android.content.Context
import androidx.core.content.edit
import javax.inject.Inject

class SharedPreferenceManager @Inject constructor(context: Context){

//    companion  object SharedPreferenceHelper {
//        @Volatile
//        private var INSTANCE : SharedPreferenceManager? = null
//
//        fun getInstance(context : Context) : SharedPreferenceManager{
//            return INSTANCE ?: synchronized(this){
//                INSTANCE ?: SharedPreferenceManager(context).also {
//                    INSTANCE = it
//                }
//            }
//        }
//    }

    private val pref = context.applicationContext.getSharedPreferences("app_prefs",Context.MODE_PRIVATE)

    fun setIsDataAdded(isAdded : Boolean){
        pref.edit { putBoolean("is_data_added", isAdded) }
    }

    fun getIsDataAdded() : Boolean {
        return pref.getBoolean("is_data_added",false)
    }
}