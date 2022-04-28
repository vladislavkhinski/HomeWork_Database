package com.gmail.vladkhinski.database_hw

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gmail.vladkhinski.database_hw.fragment.TabFragment


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, TabFragment())
            .addToBackStack(null)
            .commit()
    }
}

