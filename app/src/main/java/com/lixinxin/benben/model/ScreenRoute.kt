package com.lixinxin.benben.model

sealed class ScreenRoute(val route:String){
    object WelcomeRoute:ScreenRoute("welcome")
    object HomeRoute:ScreenRoute("home")
    object AddRecordRoute:ScreenRoute("add_record")
    object CanvasRoute:ScreenRoute("canvas")
    object GesturesRoute:ScreenRoute("gestures")
    object DraggableRoute:ScreenRoute("draggable")
}
