package com.brayan.colombia.presentation.common.base

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.brayan.colombia.presentation.common.util.ScreenState

open class BaseViewModel: ViewModel() {
    var screenState by mutableStateOf(ScreenState.Idle)
}