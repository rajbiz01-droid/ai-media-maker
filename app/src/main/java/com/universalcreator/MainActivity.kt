package com.universalcreator
import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.view.Gravity
class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tv = TextView(this)
        tv.text = "Universal Creator\nWorking! 🎉\nVersion 10"
        tv.textSize = 28f
        tv.gravity = Gravity.CENTER
        tv.setPadding(40,400,40,40)
        setContentView(tv)
    }
}
