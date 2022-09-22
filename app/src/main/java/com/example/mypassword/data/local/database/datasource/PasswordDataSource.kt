package com.example.mypassword.data.local.database.datasource

import com.example.mypassword.data.local.database.dao.PasswordDao
import com.example.mypassword.data.local.database.entity.PasswordEntity

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
interface PasswordDataSource {
    suspend fun getAllPasswords(): List<PasswordEntity>

    suspend fun getPasswordById(id: Int): PasswordEntity?

    suspend fun insertPassword(password: PasswordEntity): Long

    suspend fun deletePassword(password: PasswordEntity): Int

    suspend fun updatePassword(password: PasswordEntity): Int
}

class PasswordDataSourceImpl(private val passwordDao: PasswordDao) : PasswordDataSource {
    override suspend fun getAllPasswords(): List<PasswordEntity> {
        return passwordDao.getAllPasswords()
    }

    override suspend fun getPasswordById(id: Int): PasswordEntity? {
        return passwordDao.getPasswordById(id)
    }

    override suspend fun insertPassword(password: PasswordEntity): Long {
        return passwordDao.insertPassword(password)
    }

    override suspend fun deletePassword(password: PasswordEntity): Int {
        return passwordDao.deletePassword(password)
    }

    override suspend fun updatePassword(password: PasswordEntity): Int {
        return passwordDao.updatePassword(password)
    }
}
