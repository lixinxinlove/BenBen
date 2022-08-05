package com.lixinxin.benben.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.lixinxin.benben.Greeting
import com.lixinxin.benben.ui.theme.BenBenTheme
import kotlinx.coroutines.delay

@Composable
fun WelcomeScreen (navController: NavHostController){



    Surface(Modifier.fillMaxSize()) {

        LaunchedEffect(key1 ="key1" ){
            delay(3000)
            navController.navigate("home")
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)) {

        }
    }


}


@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    BenBenTheme {
        Greeting("Android")
    }
}