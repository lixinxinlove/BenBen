package com.lixinxin.benben.db.dao

import androidx.room.*
import com.lixinxin.benben.db.data.CategoryData
import com.lixinxin.benben.db.data.RecordData
import kotlinx.coroutines.flow.Flow

@Dao
interface RecordDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(record: RecordData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert2(record: RecordData)

    @Delete
    suspend fun delete(record: RecordData)

    @Query("SELECT * FROM tb_record")
    fun getAll(): Flow<List<RecordData>>

    @Query("SELECT * FROM tb_record WHERE category_id = :categoryId")
    fun getAllByCategoryId(categoryId: Int): Flow<List<RecordData>>

}