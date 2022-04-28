package com.gmail.vladkhinski.database_hw.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gmail.vladkhinski.database_hw.model.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}