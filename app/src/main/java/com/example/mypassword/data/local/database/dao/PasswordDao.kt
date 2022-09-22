package com.example.mypassword.data.local.database.dao

import androidx.room.*
import com.example.mypassword.data.local.database.entity.PasswordEntity

@Dao
interface PasswordDao {
    @Query("select * from passwords")
    suspend fun getAllPasswords() : List<PasswordEntity>

    @Query("select * from passwords where id == :id limit 1")
    suspend fun getPasswordById(id : Int) : PasswordEntity

    @Insert
    suspend fun insertPassword(password : PasswordEntity) : Long

    @Delete
    suspend fun deletePassword(password : PasswordEntity) : Int

    @Update
    suspend fun updatePassword(password : PasswordEntity) : Int
}