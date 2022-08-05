package com.lixinxin.benben.work

import android.content.Context
import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.lixinxin.benben.App
import com.lixinxin.benben.db.AppDatabase
import com.lixinxin.benben.db.data.RecordData

/*******
 * 后台任务
 */
class LeeWork(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {


    override fun doWork(): Result {
        insert()
        return Result.success()
    }

    fun insert() {
        val record = RecordData(
            0,
            100,
            "100",
            "自动插入",
            11.11f,
            System.currentTimeMillis(),
            System.currentTimeMillis()
        )
        AppDatabase.getRecordDao(App.instance!!.applicationContext).insert2(record)
        Log.d("RecordViewModel", "insert :$record")

    }

}
