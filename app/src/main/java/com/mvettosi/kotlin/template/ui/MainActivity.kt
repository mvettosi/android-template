package com.mvettosi.kotlin.template.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mvettosi.kotlin.template.ui.factorial.FactorialFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val fragment = FactorialFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.main_content, fragment)
                .commit()
        }
    }
}
