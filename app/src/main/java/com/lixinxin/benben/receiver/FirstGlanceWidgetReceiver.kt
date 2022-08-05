package com.lixinxin.benben.receiver

import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.GlanceAppWidgetReceiver
import com.lixinxin.benben.ui.widget.FirstGlanceWidget

class FirstGlanceWidgetReceiver : GlanceAppWidgetReceiver() {
    override val glanceAppWidget: GlanceAppWidget
        get() = FirstGlanceWidget()
}