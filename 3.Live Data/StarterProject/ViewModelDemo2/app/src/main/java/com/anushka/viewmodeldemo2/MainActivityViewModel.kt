package com.anushka.viewmodeldemo2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(startingTotal: Int) : ViewModel() {
    public var total = MutableLiveData<Int>()

    init {
        total.value = startingTotal
    }

    fun setTotal(input:Int){
        total.value = (total.value)?.plus(input)
    }
}