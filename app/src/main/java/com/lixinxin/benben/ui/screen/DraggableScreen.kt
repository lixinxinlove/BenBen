package com.lixinxin.benben.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.lixinxin.benben.ui.draggable.DraggableView

@Composable
fun DraggableScreen(navController: NavHostController, userId: String, age: Int) {


    Surface {


        Column() {

            Button(onClick = { navController.popBackStack() }) {
                Text("返回")
            }

            Text("$userId---$age")
        }


        DraggableView()

    }

}