package com.example.multilanguageapp

import android.annotation.TargetApi
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import java.util.*


object LocaleManager {

    fun setLocale(mContext: Context): Context {
        return if (Constant(mContext).getLanguagePref()!=null) {
            updateResources(mContext,Constant(mContext).getLanguagePref()!!)
        } else {
            mContext
        }
    }


    @Suppress("DEPRECATION")
    private fun updateResources(context: Context, language: String): Context {
        val locale = Locale(language)
        var context = context
        val res = context.resources
        val config = Configuration(res.configuration)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP &&
            Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            config.setLocale(locale)
            context = context.createConfigurationContext(config)
            res.updateConfiguration(config, res.displayMetrics)
        } else {
            var localContext = context
            val locale = Locale(language)
            Locale.setDefault(locale)
            val res = context.resources
            val config = Configuration(res.configuration)
            config.setLocale(locale)
            localContext = context.createConfigurationContext(config)
            return localContext
        }
        return context
    }

    fun setNewLocale(mContext: Context, language: String): Context {
        Constant(mContext).setLanguagePref(language)
        return updateResources(mContext, language)!!
    }
}