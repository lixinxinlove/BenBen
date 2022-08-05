package com.lixinxin.benben.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.lixinxin.benben.db.AppDatabase
import com.lixinxin.benben.db.data.CategoryData
import com.lixinxin.benben.db.data.RecordData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class RecordViewModel(application: Application) :
    AndroidViewModel(application) {


    fun insert(categoryId: Int, categoryName: String, recordName: String, price: Float) {
        viewModelScope.launch {
            val record = RecordData(
                0,
                categoryId,
                categoryName,
                recordName,
                price,
                System.currentTimeMillis(),
                System.currentTimeMillis()
            )
            AppDatabase.getRecordDao(getApplication()).insert(record)
            Log.d("RecordViewModel", "insert :$record")
        }
    }

    fun delete(record: RecordData) {
        viewModelScope.launch {
            AppDatabase.getRecordDao(getApplication()).delete(record)
            Log.d("RecordViewModel", "delete :$record")
        }
    }

    fun getAll(): Flow<List<RecordData>> {
        return AppDatabase.getRecordDao(getApplication())
            .getAll()
            .catch { e -> e.printStackTrace() }
            .flowOn(Dispatchers.IO)
    }

}