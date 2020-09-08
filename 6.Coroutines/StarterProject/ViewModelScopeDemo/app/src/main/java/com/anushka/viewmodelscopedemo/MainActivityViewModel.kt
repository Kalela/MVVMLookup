package com.anushka.viewmodelscopedemo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anushka.viewmodelscopedemo.model.User
import com.anushka.viewmodelscopedemo.model.UserRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO


class MainActivityViewModel : ViewModel() {

    //private val myJob = Job()
//private val myScope = CoroutineScope(Dispatchers.IO + myJob) // this is the viewModelScope if ktx extention is not used
    private var userRepository = UserRepository()
    var users: MutableLiveData<List<User>> = MutableLiveData()
    fun getUserData() {

        viewModelScope.launch {
            var result: List<User>? = null
            withContext(IO) {
                result = userRepository.getUsers()
            }

            users.value = result

        }

    }

    //This is called automatically called if using ktx viewModelScope
//    override fun onCleared() {
//        super.onCleared()
//        myJob.cancel()
//
//
//    }


}