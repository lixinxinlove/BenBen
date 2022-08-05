package com.lixinxin.benben.ui.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * flow 使用
 */
class HomeViewModel : ViewModel() {


    private val _searchFlow = MutableStateFlow("")
    val searchFlow: StateFlow<String> = _searchFlow

    fun changeSearch(keyword: String) {
        _searchFlow.value = keyword
    }








}