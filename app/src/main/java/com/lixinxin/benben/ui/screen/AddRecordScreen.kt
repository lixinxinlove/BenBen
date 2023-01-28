package com.lixinxin.benben.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.lixinxin.benben.db.data.RecordData
import com.lixinxin.benben.ui.viewmodel.RecordViewModel

/**
 * 添加记录
 */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddRecordScreen(navController: NavHostController, recordVM: RecordViewModel) {


    Scaffold(topBar = { Text(text = "添加消费记录") },
    ) {

        Surface(
            modifier = Modifier
                .background(brush = Brush.verticalGradient(listOf(Color.Gray, Color.White)))
                .fillMaxHeight()
        ) {

            Column(modifier = Modifier.fillMaxWidth()) {


                val recordName = remember {
                    mutableStateOf("")
                }

                val price = remember {
                    mutableStateOf(0.0f)
                }

                var mList by remember {
                    mutableStateOf<List<RecordData>>(listOf())
                }

                val lazyState = rememberLazyListState()

                LaunchedEffect(key1 = "key1") {
                    recordVM.getAll().collect {
                        mList = it
                    }
                }


                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(text = "名称：")
                    BasicTextField(
                        value = recordName.value,
                        modifier = Modifier.fillMaxWidth(0.6f),
                        onValueChange = {
                            recordName.value = it
                        }
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {

                    Text(text = "价格：")
                    BasicTextField(
                        value = price.value.toString(),
                        modifier = Modifier.fillMaxWidth(0.6f),
                        onValueChange = {
                            price.value = it.toFloat()
                        }
                    )
                }

                Button(onClick = {
                    recordVM.insert(0, "c1", recordName.value, price.value)
                }) {
                    Text(text = "添加消费记录")
                }


                LazyColumn(state = lazyState, modifier = Modifier.fillMaxWidth()) {
                    items(mList) { item ->
                        ItemRecordView(item = item)
                    }
                }
            }
        }
    }
}


@Composable
fun ItemRecordView(item: RecordData) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
    ) {

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(12.dp))
                    .background(Color.Gray)

            ) {
                Text(text = item.recordName, style = TextStyle(color = Color.Red, fontSize = 30.sp))
                Text(text = "价格：${item.price}")
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }

}



