package com.lixinxin.benben.db.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tb_category")
data class CategoryData(
   @PrimaryKey(autoGenerate = true) val id:Int,
   @ColumnInfo(name = "category_name") val categoryName: String,
   @ColumnInfo(name = "create_date") val createDate: Long,
   @ColumnInfo(name = "update_date") val updateDate: Long)
