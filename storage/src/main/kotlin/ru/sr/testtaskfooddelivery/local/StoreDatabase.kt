package ru.sr.testtaskfooddelivery.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [
        CartItemEntity::class
    ], version = 1
)
abstract class StoreDatabase : RoomDatabase() {

    abstract fun createCartDao(): CartDao

    companion object {
        private const val DATABASE_NAME = "storeDatabase"
        fun getInstance(context: Context): StoreDatabase {
            return Room.databaseBuilder(context, StoreDatabase::class.java, DATABASE_NAME).build()
        }
    }
}