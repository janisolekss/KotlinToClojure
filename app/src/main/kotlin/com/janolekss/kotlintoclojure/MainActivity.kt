package com.janolekss.kotlintoclojure

import android.os.*
import android.support.v7.app.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clojure {
            require("sample.core")
            text_field.text = f("sample.core/do_something", 5, 8).toString()
        }
    }
}

