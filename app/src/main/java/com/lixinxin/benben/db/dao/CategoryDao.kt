package com.lixinxin.benben.db.dao

import androidx.room.*
import com.lixinxin.benben.db.data.CategoryData
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(category: CategoryData)

    @Delete
    suspend fun delete(category: CategoryData)

    @Query("SELECT * FROM tb_category")
    fun getAll(): Flow<List<CategoryData>>

}