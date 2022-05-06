package com.example.postmanager

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.postmanager.R
import com.example.postmanager.data.PostRepository

// deleting post with deletePost method

class DeletePostActivity : AppCompatActivity() {
    //init
    private lateinit var viewModel: MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.delete_post)
        // activity on intent
        incomingIntent
    }
    private val incomingIntent: Unit
        private get() {
            if (intent.hasExtra("post_id")) {

                // collecting data from longClicked post
                val postId = intent.getStringExtra("post_id")

                // init warning message
                val warning: TextView = findViewById<View>(R.id.successText) as TextView
                val warningText = "Post with id : $postId has been deleted"

                // sending post delete warning
                warning.setText(warningText)

                // forward
                if (postId != null) {
                    delete(postId)
                }
            }
        }



    private fun delete(postId: String) {
        // forward with deletePost
        val repository = PostRepository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.deletePost(postId)
    }
}