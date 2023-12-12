package com.sc941737.cmmdemo.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import com.sc941737.cmmdemo.shared.android.main.MainView
import com.sc941737.cmmdemo.shared.util.initKoin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initKoin(applicationContext)

        setContent {
            MainView()
        }
    }
}