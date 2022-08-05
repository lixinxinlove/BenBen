package com.lixinxin.benben.ui.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.lixinxin.benben.db.AppDatabase
import com.lixinxin.benben.db.data.CategoryData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch

class CategoryViewModel(application: Application) :
    AndroidViewModel(application) {


    fun insert(categoryName: String) {
        viewModelScope.launch {
            val category =
                CategoryData(0,
                    categoryName,
                    System.currentTimeMillis(),
                    System.currentTimeMillis())
            AppDatabase.getCategoryDao(getApplication()).insert(category)
            Log.d("CategoryViewModel", "insert :$category")
        }
    }

    fun delete(category: CategoryData) {
        viewModelScope.launch {
            AppDatabase.getCategoryDao(getApplication()).delete(category)
            Log.d("CategoryViewModel", "delete :$category")
        }
    }

    fun getAll(): Flow<List<CategoryData>> {
        return AppDatabase.getCategoryDao(getApplication())
            .getAll()
            .catch { e -> e.printStackTrace() }
            .flowOn(Dispatchers.IO)
    }

}