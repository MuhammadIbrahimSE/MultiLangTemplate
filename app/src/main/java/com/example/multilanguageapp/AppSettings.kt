package com.example.multilanguageapp

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class AppSetting(context: Context) {
    private val sharedPreference: SharedPreferences
    private val editor: SharedPreferences.Editor

    companion object {
        private const val APP_PREF = "TEST"
    }

    init {
        sharedPreference = context.getSharedPreferences(APP_PREF, Activity.MODE_PRIVATE)
        editor = sharedPreference.edit()
    }

    fun putString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }


    fun getString(key:String) : String{
        return sharedPreference.getString(key,"en")!!
    }
}