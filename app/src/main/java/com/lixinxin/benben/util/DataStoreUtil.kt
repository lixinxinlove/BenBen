package com.lixinxin.benben.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.lixinxin.benben.dataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking


// At the top level of your kotlin file:
//private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
object DataStoreUtil {

    suspend fun putString(context: Context, key: String, value: String) {
        // edit 函数需要在挂起环境中执行
        context.dataStore.edit { settings -> settings[stringPreferencesKey(key)] = value }
    }

    suspend fun putInt(context: Context, key: String, value: Int) {
        // edit 函数需要在挂起环境中执行
        context.dataStore.edit { settings -> settings[intPreferencesKey(key)] = value }
    }

    suspend fun putFloat(context: Context, key: String, value: Float) {
        // edit 函数需要在挂起环境中执行
        context.dataStore.edit { settings -> settings[floatPreferencesKey(key)] = value }
    }

    suspend fun putDouble(context: Context, key: String, value: Double) {
        // edit 函数需要在挂起环境中执行
        context.dataStore.edit { settings -> settings[doublePreferencesKey(key)] = value }
    }


    fun getStringSync(context: Context, key: String, dft: String = ""): String {
        var value = dft
        runBlocking {
            context.dataStore.data.first {
                value = it[stringPreferencesKey(key)] ?: dft
                true          // 这里返回true 表示取到Flow 中的第一个数据后停止收集Flow 中的数据
            }
        }
        return value
    }

}