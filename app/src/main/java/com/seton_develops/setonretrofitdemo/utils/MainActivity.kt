package com.seton_develops.setonretrofitdemo.utils

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.seton_develops.setonretrofitdemo.R
import com.seton_develops.setonretrofitdemo.repository.Repository
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var tvBody: TextView
    private lateinit var tvTitle: TextView
    private lateinit var tvUserID: TextView
    private lateinit var tvPostID: TextView
    private lateinit var svSearchPost: SearchView
    private lateinit var btnRefresh: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Initialize the android components

        //textviews
        tvBody = findViewById(R.id.tvBody)
        tvTitle = findViewById(R.id.tvTitle)
        tvUserID = findViewById(R.id.tvUserID)
        tvPostID = findViewById(R.id.tvPostID)

        //searchview
        svSearchPost = findViewById(R.id.svSearchPost)

        //Button
        btnRefresh = findViewById(R.id.btnRefresh)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)



        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()

        viewModel.responseData.observe(this, Observer { returnedResponse ->
            if (returnedResponse.isSuccessful) {
                tvTitle.text = returnedResponse.body()?.title!!
                tvBody.text = returnedResponse.body()?.body!!
                tvUserID.text = returnedResponse.body()?.userId!!.toString()
                tvPostID.text = returnedResponse.body()?.id!!.toString()

                Toast.makeText(this,"Success", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this,"ERROR", Toast.LENGTH_LONG).show()
            }
        })

        btnRefresh.setOnClickListener() {


            try {
                var inputValue = svSearchPost.query.toString().toLong()
                require(inputValue in 1..100) { "Input should be (1-99), was $inputValue" }

                Toast.makeText(this,
                    "Screen has been updated with post #$inputValue",
                    Toast.LENGTH_LONG).show()

                viewModel.getSpecificPost(inputValue)
            }
            catch (e: IllegalArgumentException ) {
                Toast.makeText(this,
                    "Invalid input. Not within (1-100) Try again",
                    Toast.LENGTH_LONG).show()
            }
            catch (e2: NumberFormatException) {
                Toast.makeText(this,
                    "Invalid input. Not a number. Try again",
                    Toast.LENGTH_LONG).show()
            }


        }



    }
}