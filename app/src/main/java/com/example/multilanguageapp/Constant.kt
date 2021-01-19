package com.example.multilanguageapp

import android.content.Context

class Constant(var context: Context) {


    fun setLanguagePref(key: String) {
        AppSetting(context).putString("language", key)

    }

    fun getLanguagePref(): String? {
        return AppSetting(context).getString("language")
    }
}