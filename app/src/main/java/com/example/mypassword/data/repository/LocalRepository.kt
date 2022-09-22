package com.example.mypassword.data.repository

import com.example.mypassword.data.local.preference.UserPreferenceDataSource
import com.example.mypassword.wrapper.Resource
import com.example.mypassword.data.local.database.datasource.PasswordDataSource
import com.example.mypassword.data.local.database.entity.PasswordEntity

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface LocalRepository {
    fun checkIfAppKeyExist(): Boolean
    fun checkIsAppKeyCorrect(appKey: String): Boolean
    fun setAppKey(newAppKey: String)
    suspend fun getPasswordList(): Resource<List<PasswordEntity>>
    suspend fun getPasswordById(id: Int): Resource<PasswordEntity?>
    suspend fun insertPassword(password: PasswordEntity): Resource<Number>
    suspend fun deletePassword(password: PasswordEntity): Resource<Number>
    suspend fun updatePassword(password: PasswordEntity): Resource<Number>
}

class LocalRepositoryImpl(
    private val userPreferenceDataSource: UserPreferenceDataSource,
    private val passwordDataSource: PasswordDataSource
) : LocalRepository {

    override fun checkIfAppKeyExist(): Boolean {
        return userPreferenceDataSource.getUserAppKey().isNullOrEmpty().not()
    }

    override fun checkIsAppKeyCorrect(appKey: String): Boolean {
        return userPreferenceDataSource.getUserAppKey().equals(appKey, ignoreCase = true)
    }

    override fun setAppKey(newAppKey: String) {
        userPreferenceDataSource.setUserAppKey(newAppKey)
    }

    override suspend fun getPasswordList(): Resource<List<PasswordEntity>> {
        return proceed {
            passwordDataSource.getAllPasswords()
        }
    }

    override suspend fun getPasswordById(id: Int): Resource<PasswordEntity?> {
        return proceed {
            passwordDataSource.getPasswordById(id)
        }
    }

    override suspend fun insertPassword(password: PasswordEntity): Resource<Number> {
        return proceed {
            passwordDataSource.insertPassword(password)
        }
    }

    override suspend fun deletePassword(password: PasswordEntity): Resource<Number> {
        return proceed {
            passwordDataSource.deletePassword(password)
        }
    }

    override suspend fun updatePassword(password: PasswordEntity): Resource<Number> {
        return proceed {
            passwordDataSource.updatePassword(password)
        }
    }

    private suspend fun <T> proceed(coroutine: suspend () -> T): Resource<T> {
        return try {
            Resource.Success(coroutine.invoke())
        } catch (exception: Exception) {
            Resource.Error(exception)
        }
    }

}
