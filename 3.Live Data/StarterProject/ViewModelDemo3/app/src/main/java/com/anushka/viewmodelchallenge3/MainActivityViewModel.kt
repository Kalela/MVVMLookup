package com.anushka.viewmodelchallenge3

import android.util.Log
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel(), Observable {
    private val TAG = "MainActivityViewModel"
    private var total = MutableLiveData<Int>()
    val totalData : LiveData<Int>
    get() = total

    @Bindable
    val inputText = MutableLiveData<String>()

    init {
        total.value = startingTotal
    }

    fun setTotal(){
        Log.d(TAG, "setTotal: input text ${inputText.value}")
        val intInput : Int = inputText.value!!.toInt()
        total.value = (total.value)?.plus(intInput)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }
}