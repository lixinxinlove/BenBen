package com.lixinxin.benben.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

//TextField Ues
@Composable
fun TextFieldDemo01() {
    Surface(modifier = Modifier.fillMaxSize()) {

        var userName by remember {
            mutableStateOf("")
        }

        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "用户名：")
                TextField(
                    value = userName,
                    modifier = Modifier
                        .weight(1f)
                        .clip(RoundedCornerShape(10.dp)),
                    onValueChange = {
                        userName = it
                    },
                    label = {
                        Text(text = "")
                    }
                )

                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}


@Preview
@Composable
fun TextFieldDemoPreview() {
    TextFieldDemo01()
}