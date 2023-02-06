package com.lixinxin.benben.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lixinxin.benben.db.data.CategoryData
import com.lixinxin.benben.model.ScreenRoute
import com.lixinxin.benben.ui.theme.CustomTheme
import com.lixinxin.benben.ui.viewmodel.CategoryViewModel
import kotlinx.coroutines.launch

@Composable
fun HomeScreen(navController: NavHostController, categoryVM: CategoryViewModel) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
    ) {

        val scope = rememberCoroutineScope()
        val lazyState = rememberLazyListState()
        var mList by remember {
            mutableStateOf<List<CategoryData>>(listOf())
        }

        Column(modifier = Modifier.fillMaxWidth()) {

            Button(
                onClick = { navController.navigate("canvas") },
                modifier = Modifier.clip(
                    MaterialTheme.shapes.medium
                )
            ) {
                Text(text = "图表", color = CustomTheme.colors.content)
            }

            Button(onClick = { navController.navigate(ScreenRoute.GesturesRoute.route) }) {
                Text(text = "手势", fontSize = 20.sp)
            }

            Button(onClick = { navController.navigate("add_record") }) {
                Text(text = "添加消费记录")
            }


            Button(onClick = {
                categoryVM.insert("吃饭")
            }) {
                Text(text = "添加分类")
            }

            Button(onClick = {
                scope.launch {
                    categoryVM.getAll().collect {
                        mList = it
                    }
                }
            }) {
                Text(text = "查看全部分类")
            }


            Button(onClick = { navController.navigate(ScreenRoute.DraggableRoute.route+"/user1234/33") }) {
                Text(text = "拖动", fontSize = 20.sp)
            }



            Text(
                text = "测试".repeat(50),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(
                    fontSize = 30.sp, color = Color.Green,
                    shadow = Shadow(color = Color.Blue, offset = Offset.Zero, blurRadius = 3f)
                )
            )

            var text by remember {
                mutableStateOf("")
            }

            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("name") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )


            LazyColumn(
                state = lazyState,
                modifier = Modifier.fillMaxSize()
            ) {
                items(mList) {
                    ItemView(category = it, categoryVM)
                }
            }

        }
    }
}

@Composable
fun ItemView(category: CategoryData, categoryVM: CategoryViewModel) {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(
            text = category.categoryName,
            color = Color.Blue,
            modifier = Modifier
                .height(48.dp),
            textAlign = TextAlign.Center,
            style = TextStyle(
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
        )

        Button(onClick = {
            categoryVM.delete(category)
        }) {
            Text(text = "删除")
        }
    }


}