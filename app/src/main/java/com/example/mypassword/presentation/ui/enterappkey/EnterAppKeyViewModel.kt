package com.example.mypassword.presentation.ui.enterappkey

import androidx.lifecycle.ViewModel
import com.example.mypassword.data.repository.LocalRepository

class EnterAppKeyViewModel(private val repository: LocalRepository) : ViewModel() {
    fun checkIsAppKeyCorrect(appKey: String): Boolean {
        return repository.checkIsAppKeyCorrect(appKey)
    }
}