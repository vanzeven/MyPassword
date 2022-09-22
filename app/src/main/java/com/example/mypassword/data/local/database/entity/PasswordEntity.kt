package com.example.mypassword.data.local.database.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "passwords")
data class PasswordEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "app_name")
    var appName: String?,
    @ColumnInfo
    var email: String?,
    @ColumnInfo
    var username: String?,
    @ColumnInfo
    var password: String?,
    @ColumnInfo
    var description: String?,
) : Parcelable