package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.myapplication.Movie.Companion.MOVIE_KEY
import kotlinx.android.synthetic.main.activity_list.*

class MainActivity : AppCompatActivity() {

    companion object {


        const val MOVIE_REQUEST_CODE = 123
    }

    val movieList = mutableListOf<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        add_movie_button.setOnClickListener {
            val intent = Intent(this, EditActivity::class.java)
            startActivityForResult(intent, MOVIE_REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == MOVIE_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

            val movie = data?.getSerializableExtra(MOVIE_KEY) as com.example.myapplication.Movie
            movieList.add(movie)
            displayMovies()
        }
    }

    fun createTextView(movie: Movie): TextView {

        val textview = TextView(this)
        textview.textSize = 16f
        textview.text = movie.movieTitle
        if (movie.isWatched) textview.setTextColor(resources.getColor((R.color.colorPrimary)))
        else textview.setTextColor((resources.getColor((R.color.colorAccent))))
        return textview
    }

    fun displayMovies() {

        movie_list_layout.removeAllViews()
        /*for (movie in movieList) {
            val textview = createTextView(movie)
            movie_list_layout.addView(textview)
        }*/
        movieList.forEach{

            val textview = createTextView(it)
            movie_list_layout.addView(textview)
        }
    }
}
