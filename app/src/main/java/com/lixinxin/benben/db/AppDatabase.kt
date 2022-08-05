package com.lixinxin.benben.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lixinxin.benben.db.dao.CategoryDao
import com.lixinxin.benben.db.dao.RecordDao
import com.lixinxin.benben.db.data.CategoryData
import com.lixinxin.benben.db.data.RecordData


@Database(entities = arrayOf(CategoryData::class,RecordData::class), version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun categoryDao(): CategoryDao
    abstract fun recordDao(): RecordDao

    companion object {

        private var instance: AppDatabase? = null

        private fun getInstance(context: Context): AppDatabase {
            return instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "db_benben.db")
                    .fallbackToDestructiveMigration()
                    .build().also { instance = it }
            }
        }

        fun getCategoryDao(context: Context): CategoryDao {
            return getInstance(context).categoryDao()
        }

        fun getRecordDao(context: Context): RecordDao {
            return getInstance(context).recordDao()
        }


    }
}