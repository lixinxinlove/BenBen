package com.lixinxin.benben.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lixinxin.benben.model.ScreenRoute
import com.lixinxin.benben.ui.viewmodel.CategoryViewModel
import com.lixinxin.benben.ui.viewmodel.RecordViewModel

//Composable 导航 和 添加参数


@Composable
fun AppNavHost(
    categoryVM: CategoryViewModel,
    recordVM: RecordViewModel
) {

    val navController = rememberNavController()
    //支持动画的导航
    NavHost(
        navController = navController,
        startDestination = ScreenRoute.WelcomeRoute.route,
    ) {
        composable(
            route = ScreenRoute.WelcomeRoute.route
        ) {
            WelcomeScreen(navController)
        }
        composable(
            route = ScreenRoute.HomeRoute.route
        ) {
            HomeScreen(navController, categoryVM)
        }
        composable(
            route = ScreenRoute.AddRecordRoute.route
        ) {
            AddRecordScreen(navController, recordVM)
        }
        composable(
            route = ScreenRoute.CanvasRoute.route
        ) {
            CanvasScreen()
        }

        composable(
            route = ScreenRoute.GesturesRoute.route,
        ) {
            GesturesScreen()
        }

        composable(
            route = ScreenRoute.DraggableRoute.route + "/{userId}/{age}",
            arguments = listOf(
                navArgument("age") { type = NavType.IntType }
            )
        ) {
            val argument = requireNotNull(it.arguments)
            val userId = argument.getString("userId", "null_id")
            val age = argument.getInt("age",100)
            DraggableScreen(navController, userId,age)
        }

    }

}