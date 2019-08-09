package com.example.android_sprint1_challenge

import kotlinx.android.synthetic.main.activity_edit.*


open class  TitleData : EditActivity() {

    fun getName(): String {
       var name = text_Box.text.toString()
        return name

    }

}