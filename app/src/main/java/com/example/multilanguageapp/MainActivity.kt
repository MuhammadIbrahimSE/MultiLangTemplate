package com.example.multilanguageapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        clickListenres()
    }

    private fun clickListenres() {
        btn_change_lang.setOnClickListener(this)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleManager.setLocale(newBase!!))
    }

    fun changeLanguage(lang: String) {
        LocaleManager.setNewLocale(this, lang)
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onClick(v: View?) {
        when (v!!.id) {
            R.id.btn_change_lang -> {
                if (Constant(applicationContext).getLanguagePref() == "ar") {
                    changeLanguage("en")
                } else {
                    changeLanguage("ar")
                }
            }
        }
    }
}