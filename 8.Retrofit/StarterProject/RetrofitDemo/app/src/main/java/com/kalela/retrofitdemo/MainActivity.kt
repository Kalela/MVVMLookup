package com.kalela.retrofitdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import com.kalela.retrofitdemo.model.Albums
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val retService = RetrofitInstance
            .getRetrofitInstance()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Albums>> = liveData {
            val response = retService.getAlbums()
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
}