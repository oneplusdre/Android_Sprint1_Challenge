package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Movie.Companion.MOVIE_KEY
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        save_button.setOnClickListener {
        val movie = Movie()
            movie.movieTitle = movie_title_text.text.toString()
            movie.isWatched = watched_switch.isChecked

            val intent = Intent()
            intent.putExtra(MOVIE_KEY, movie)
            setResult(Activity.RESULT_OK, intent)
            finish()

        }

    }
}
