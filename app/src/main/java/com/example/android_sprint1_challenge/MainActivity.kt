package com.example.android_sprint1_challenge

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

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
        textview.text = com.example.android_sprint1_challenge.TitleData.name

        textview.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            intent.putExtra(TitleData.name, com.example.android_sprint1_challenge.TitleData)
            startActivityForResult(intent, ADD_MOVIE_CODE)
        }

        return textview
    }

    fun populateList(index: Int) {
        movie_list_layout.removeAllViews()
        for (TitleData in movieList) {
            movie_list_layout.addView(createTextView(com.example.android_sprint1_challenge.TitleData, index))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_MOVIE_CODE && resultCode == Activity.RESULT_OK) {
            val imageData = data?.getSerializableExtra(TitleData.name) as TitleData
            movieList.add(imageData)
            populateList(movieList.size - 1)
        }
    }
}

