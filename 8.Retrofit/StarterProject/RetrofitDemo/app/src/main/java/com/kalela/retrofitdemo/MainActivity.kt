package com.kalela.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.kalela.retrofitdemo.model.AlbumItem
import com.kalela.retrofitdemo.model.Albums
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    private lateinit var retService: AlbumService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        getRequestWithPathParameters()
        getRequestWithQueryParameters()

    }

    private fun getRequestWithQueryParameters() {
        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getUsersAlbums(3)
            emit(response)
        }

        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()
            if (albumsList != null) {
                while (albumsList.hasNext()) {
                    val albumItem = albumsList.next()
                    val result = " " + "Album Title: ${albumItem.title}" + "\n" +
                            " " + "Album id: ${albumItem.id}" + "\n" +
                            " " + "User id: ${albumItem.userId}" + "\n\n\n"

                    text_view.append(result)
                }
            }
        })
    }

    private fun getRequestWithPathParameters() {
        // path parameters example
        val pathResponse: LiveData<Response<AlbumItem>> = liveData {
            val response = retService.getAlbum(3)
            emit(response)
        }

        pathResponse.observe(this, Observer {
            val title = it.body()?.title
            Toast.makeText(applicationContext, title, Toast.LENGTH_LONG).show()
        })
    }
}