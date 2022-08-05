package com.lixinxin.benben.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import kotlin.math.roundToInt


import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.ui.unit.IntOffset


@SuppressLint("RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class, ExperimentalUnitApi::class)
@Composable
fun GesturesScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        val count = remember { mutableStateOf(0) }
        val textString = remember { mutableStateOf("") }
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {


//                Text(
//                    text = count.value.toString(),
//                    textAlign = TextAlign.Center,
//                    maxLines = 1,
//                    fontSize = TextUnit(30f, TextUnitType.Sp),
//                    modifier = Modifier.clickable { count.value += 1 }.padding(20.dp)
//                )


            Text(
                text = textString.value,
                textAlign = TextAlign.Center,
                maxLines = 1,
                fontSize = TextUnit(30f, TextUnitType.Sp),
                modifier = Modifier
                    .padding(20.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onPress = {
                                /* Called when the gesture starts */
                                textString.value = "Called when the gesture starts"
                            },
                            onDoubleTap = { /* Called on Double Tap */
                                textString.value = "Called on Double Tap"
                            },
                            onLongPress = { /* Called on Long Press */
                                textString.value = "Called on Long Press "
                            },
                            onTap = {
                                /* Called on Tap */
                                textString.value = "Called on Tap"
                            }
                        )
                    })


            // ScrollBoxesSmooth()

            // ScrollableSample()
            //ScrollableSample2()
            // DragDemo()
            // SwipeableSample()

            // TransformableSample()

            TextFieldDemo()
        }
    }
}


@Composable
private fun ScrollBoxesSmooth() {

    // Smoothly scroll 100px on first composition
    val state = rememberScrollState()
    LaunchedEffect(Unit) { state.animateScrollTo(100) }

    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .size(100.dp)
            .padding(horizontal = 8.dp)
            .verticalScroll(state)
    ) {
        repeat(10) {
            Text("Item $it", modifier = Modifier.padding(2.dp))
        }
    }
}

@Composable
fun ScrollableSample() {
    // actual composable state
    var offset by remember { mutableStateOf(0f) }
    Box(
        Modifier
            .size(150.dp)
            .scrollable(
                orientation = Orientation.Vertical,
                // Scrollable state: describes how to consume
                // scrolling delta and update offset
                state = rememberScrollableState { delta ->
                    offset += delta
                    delta
                }
            )
            .background(Color.LightGray),
        contentAlignment = Alignment.Center
    ) {
        Text(offset.toString())
    }
}


@Composable
fun ScrollableSample2() {
    val gradient = Brush.verticalGradient(0f to Color.Gray, 1000f to Color.White)
    Box(
        modifier = Modifier
            .background(Color.LightGray)
            .verticalScroll(rememberScrollState())
            .padding(32.dp)
    ) {
        Column {
            repeat(8) {
                Box(
                    modifier = Modifier
                        .height(128.dp)
                        .verticalScroll(rememberScrollState())
                ) {
                    Text(
                        "Scroll here",
                        modifier = Modifier
                            .border(12.dp, Color.DarkGray)
                            .background(brush = gradient)
                            .padding(24.dp)
                            .height(150.dp)
                    )
                }
            }
        }
    }
}


@Composable
fun DragDemo() {
    Box(modifier = Modifier.fillMaxSize()) {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }

        Box(
            Modifier
                .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
                .background(Color.Blue)
                .size(50.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        change.consumeAllChanges()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        )
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SwipeableSample() {
    val width = 300.dp
    val squareSize = 50.dp

    val swipeableState = rememberSwipeableState(0)
    val sizePx = with(LocalDensity.current) { (width - squareSize).toPx() }
    val anchors = mapOf(0f to 0, sizePx to 1) // Maps anchor points (in px) to states

    Box(
        modifier = Modifier
            .width(width)
            .swipeable(
                state = swipeableState,
                anchors = anchors,
                thresholds = { _, _ -> FractionalThreshold(0.5f) },
                orientation = Orientation.Horizontal
            )
            .background(Color.LightGray)
    ) {
        Box(
            Modifier
                .offset { IntOffset(swipeableState.offset.value.roundToInt(), 0) }
                .size(squareSize)
                .background(Color.DarkGray)
        )
    }
}


@Composable
fun TransformableSample() {
    // set up all transformation states
    var scale by remember { mutableStateOf(1f) }
    var rotation by remember { mutableStateOf(0f) }
    var offset by remember { mutableStateOf(Offset.Zero) }
    val state = rememberTransformableState { zoomChange, offsetChange, rotationChange ->
        scale *= zoomChange
        rotation += rotationChange
        offset += offsetChange
    }
    Box(
        Modifier
            // apply other transformations like rotation and zoom
            // on the pizza slice emoji
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
                rotationZ = rotation,
                translationX = offset.x,
                translationY = offset.y
            )
            // add transformable to listen to multitouch transformation events
            // after offset
            .transformable(state = state)
            .background(Color.Blue)
            .fillMaxSize()
    )
}

@Composable
fun TextFieldDemo() {
    //接收用户输入的值
    var name by remember { mutableStateOf("") }
    TextField(
        value = name, onValueChange = { name = it },

        label = {
            Text(text = "name")
        },
        placeholder = {
            Text(text = "lee lee")
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.AccountBox, contentDescription = null)
        },
        keyboardActions = KeyboardActions(onDone = {

        }),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        singleLine = true,
    )

}


@Composable
@Preview
private fun GesturesScreenPreview() {
    GesturesScreen()
}