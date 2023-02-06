package com.lixinxin.benben

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.lixinxin.benben.ui.screen.AppNavHost
import com.lixinxin.benben.ui.screen.BenBenNavHost
import com.lixinxin.benben.ui.theme.BenBenTheme
import com.lixinxin.benben.ui.theme.CustomTheme
import com.lixinxin.benben.ui.viewmodel.CategoryViewModel
import com.lixinxin.benben.ui.viewmodel.RecordViewModel
import com.lixinxin.benben.work.LeeWork


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

class MainActivity : ComponentActivity() {


    val categoryVM by viewModels<CategoryViewModel>()
    val recordVM by viewModels<RecordViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                  //  BenBenNavHost(categoryVM, recordVM)
                    AppNavHost(categoryVM, recordVM)
                }
            }
        }
        val myConstraints = Constraints.Builder().build()
        val myRequest = OneTimeWorkRequest.Builder(LeeWork::class.java)
            .setConstraints(myConstraints)
            .build()

        WorkManager.getInstance(this).enqueue(myRequest)

    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BenBenTheme {
        Greeting("Android")
    }
}