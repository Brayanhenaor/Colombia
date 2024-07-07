package com.brayan.colombia.presentation.common.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.brayan.colombia.presentation.common.util.ScreenState

@Composable
fun BaseScreen(
    viewModel: BaseViewModel,
    load: () -> Unit,
    content: @Composable ()-> Unit,
    loadingContent: @Composable ()-> Unit,
){
    LaunchedEffect(Unit) {
        load()
    }

    when(viewModel.screenState){
        ScreenState.Idle -> { }
        ScreenState.Loading -> loadingContent()
        ScreenState.Loaded -> content()
    }
}