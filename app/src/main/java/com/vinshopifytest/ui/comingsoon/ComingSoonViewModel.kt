package com.vinshopifytest.ui.comingsoon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ComingSoonViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Remaining Functionality"
    }
    val text: LiveData<String> = _text
}