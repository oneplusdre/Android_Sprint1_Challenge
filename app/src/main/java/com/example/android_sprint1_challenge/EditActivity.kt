package com.example.android_sprint1_challenge

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*

open class EditActivity : AppCompatActivity() {

    companion object {
        const val MOVIE_REQUEST_CODE = 11
    }



     var movieData: String = (TitleData()).toString()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val extra = intent.getSerializableExtra(movieData)
        if (extra != null) {
            movieData = (extra as TitleData).toString()

        }



        add_movie_button.setOnClickListener {
            movieData = text_Box.text.toString()
            val intent = Intent()
            intent.putExtra(movieData, movieData)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == MOVIE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            val intent = Intent(this, MainActivity::class.java)
        }
    }
}
