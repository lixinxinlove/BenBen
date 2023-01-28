package com.lixinxin.benben.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.material.Surface
import androidx.compose.material.pullrefresh.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.glance.layout.Box

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyVerticalStaggeredGridScreen() {

    Surface(modifier = Modifier.fillMaxSize()) {
        var refreshing by remember {
            mutableStateOf(false)
        }

//        Box (modifier = Modifier.pullRefresh(refreshing)){
//
//            LazyVerticalStaggeredGrid(
//                columns = StaggeredGridCells.Fixed(2)
//            ) {
//               // itemsIndexed()
//            }
//        }
    }


}