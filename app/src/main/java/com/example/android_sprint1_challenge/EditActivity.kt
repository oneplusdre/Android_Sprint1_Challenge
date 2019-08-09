package com.example.android_sprint1_challenge

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.android.synthetic.main.activity_edit.add_movie_button
import kotlinx.android.synthetic.main.activity_main.*

open class EditActivity : AppCompatActivity() {


    public class TitleData(var title: String?, var watched: Boolean?) {


        // need to store movie watched status as well as the name
        // so two properties, one string and one for boolean

        fun getTitle() {

            var name: TextView = R.id.input_view().text
            var watched: Boolean? = null

            if (EditText.text.input_view) != null) {


            }


    }
    }

    var movieData: TitleData = TitleData(title = R.id.input_view .toString(), watched = true)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        add_movie_button.setOnClickListener {
            movieData = TitleData
            val intent = Intent()
            intent.putExtra("Title", true)
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
        var extra = intent.getSerializableExtra(movieData)
        if (extra != null) {

            //here is where I update the screen
            movie_List.text = title
            movieData = extra as TitleData
        }
    }
}

//update movieData's name and watched.status


