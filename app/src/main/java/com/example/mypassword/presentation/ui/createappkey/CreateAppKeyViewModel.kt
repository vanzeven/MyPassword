package com.example.mypassword.presentation.ui.createappkey

import androidx.lifecycle.ViewModel
import com.example.mypassword.data.repository.LocalRepository

class CreateAppKeyViewModel(private val repository: LocalRepository) : ViewModel() {
    fun setAppKey(newAppKey: String) {
        repository.setAppKey(newAppKey)
    }
}