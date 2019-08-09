package com.example.android_sprint1_challenge

import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*


open class  TitleData : AppCompatActivity() {

    fun getName(): String {
       var name = text_Box.text.toString()
        return name

    }

}