package com.lixinxin.benben.ui.widget

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.glance.Button
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.action.ActionParameters
import androidx.glance.action.actionParametersOf
import androidx.glance.action.actionStartActivity
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.action.actionRunCallback
import androidx.glance.appwidget.background
import androidx.glance.appwidget.cornerRadius
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.currentState
import androidx.glance.layout.*
import androidx.glance.state.GlanceStateDefinition
import androidx.glance.state.PreferencesGlanceStateDefinition
import androidx.glance.text.FontWeight
import androidx.glance.text.Text
import androidx.glance.text.TextStyle
import androidx.glance.unit.ColorProvider
import com.lixinxin.benben.MainActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private val countPreferenceKey = intPreferencesKey("widget-key")
private val countParamKey = ActionParameters.Key<Int>("widget-key")

class FirstGlanceWidget:GlanceAppWidget() {
    @SuppressLint("CoroutineCreationDuringComposition")
    @Composable
    override fun Content() {


        var time by remember {
            mutableStateOf(0)
        }

        val prefs = currentState<Preferences>()
        val count = prefs[countPreferenceKey] ?: 1



        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .background(day = Color.Gray, night = Color.Blue)
                .cornerRadius(10.dp)
                .padding(8.dp)
        ) {
            Text(
                text = time.toString(),
                modifier = GlanceModifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold,
                    fontSize = 20.sp, color = ColorProvider(Color.Black) ),

            )
            Text(
                text = count.toString(),
                modifier = GlanceModifier.fillMaxWidth(),
                style = TextStyle(fontWeight = FontWeight.Bold),
            )


            Row(
                modifier = GlanceModifier
                    .fillMaxWidth()
            ) {


                val countKey = ActionParameters.Key<Int>("count")


                Button(text = "更新UI",
                    onClick = actionRunCallback(ActionCallbacks::class.java,
                        actionParametersOf(countKey to 2*count)))

                Button(text = "启动", onClick = actionStartActivity(MainActivity::class.java))

            }
        }

    }
}

class ActionCallbacks: ActionCallback {
    override suspend fun onRun(context: Context, glanceId: GlanceId, parameters: ActionParameters) {
        // 执行需要的操作
        Log.e("FirstGlanceWidget", "onRun")
        val countKey = ActionParameters.Key<Int>("count")

        val count = requireNotNull(parameters[countKey])


        updateAppWidgetState(
            context = context,
            definition = PreferencesGlanceStateDefinition,
            glanceId = glanceId
        ) { preferences ->
            preferences.toMutablePreferences()
                .apply {
                    this[countPreferenceKey] = count
                }
        }

        FirstGlanceWidget().update(context, glanceId)

        Log.e("FirstGlanceWidget", "onRun$count")

    }

}

class ActionCallbacks2: ActionCallback {
    override suspend fun onRun(context: Context, glanceId: GlanceId, parameters: ActionParameters) {


//        updateAppWidgetState(
//            context = context,
//            definition = PreferencesGlanceStateDefinition,
//            glanceId = glanceId
//        ) { preferences ->
//            preferences.toMutablePreferences()
//                .apply {
//
//                }
//        }

        FirstGlanceWidget().update(context, glanceId)

      //  Log.e("FirstGlanceWidget", "onRun$count")

    }

}
