package com.lixinxin.benben.ui.screen

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.navigation
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.lixinxin.benben.model.ScreenRoute
import com.lixinxin.benben.ui.viewmodel.CategoryViewModel
import com.lixinxin.benben.ui.viewmodel.RecordViewModel

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun BenBenNavHost(
    categoryVM: CategoryViewModel,
    recordVM: RecordViewModel
) {

    val navController = rememberAnimatedNavController()
    //支持动画的导航
    AnimatedNavHost(
        navController = navController,
        startDestination = ScreenRoute.WelcomeRoute.route,
    ) {
        composable(
            route = ScreenRoute.WelcomeRoute.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            popEnterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Up,
                    animationSpec =tween(700)
                )
            },
            popExitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            }

        ) {
            WelcomeScreen(navController)
        }

        composable(
            route = ScreenRoute.HomeRoute.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            }
        ) {
            HomeScreen(navController, categoryVM)
        }

        composable(
            route = ScreenRoute.AddRecordRoute.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            }
        ) {
            AddRecordScreen(navController, recordVM)
        }

        composable(
            route = ScreenRoute.CanvasRoute.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            }
        ) {
            CanvasScreen()
        }

        composable(
            route = ScreenRoute.GesturesRoute.route,
            enterTransition = {
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            },
            exitTransition = {
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )
            }
        ) {
            GesturesScreen()
        }

    }

}