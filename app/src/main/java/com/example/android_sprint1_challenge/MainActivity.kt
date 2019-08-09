package com.example.android_sprint1_challenge

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.add_movie_button
import kotlinx.android.synthetic.main.activity_main.movie_list_layout

class MainActivity : AppCompatActivity() {

    companion object {
        const val ADD_MOVIE_CODE = 10
    }

    private val movieList = mutableListOf<TitleData>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        add_movie_button.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, ADD_MOVIE_CODE)
        }
    }

    fun createTextView(TitleData: TitleData, index: Int): TextView {
        val textview = TextView(this)
        textview.textSize = 20f
        textview.text = text_Box.text

        textview.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, ADD_MOVIE_CODE)
        }

        return textview
    }

    fun populateList(index: Int) {
        movie_list_layout.removeAllViews()
        for (TitleData in movieList) {
            movie_list_layout.addView(createTextView(TitleData, index))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_MOVIE_CODE && resultCode == Activity.RESULT_OK) {
            val movieData = data?.toString() as TitleData
            movieList.add(movieData)
            populateList(movieList.size - 1)
        }
    }
}

