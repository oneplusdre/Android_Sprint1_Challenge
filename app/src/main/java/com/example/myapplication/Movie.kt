package com.example.myapplication

import java.io.Serializable

class Movie (


    var movieTitle: String = "", var isWatched: Boolean = false): Serializable {

    companion object  { const val MOVIE_KEY = "movie"
    }
}
