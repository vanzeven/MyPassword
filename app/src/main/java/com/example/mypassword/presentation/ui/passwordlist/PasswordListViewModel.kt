package com.example.mypassword.presentation.ui.passwordlist

import androidx.lifecycle.ViewModel
import com.example.mypassword.data.repository.LocalRepository

class PasswordListViewModel(private val repository: LocalRepository) : ViewModel() {

    fun checkIfAppKeyExist(): Boolean {
        return repository.checkIfAppKeyExist()
    }
}