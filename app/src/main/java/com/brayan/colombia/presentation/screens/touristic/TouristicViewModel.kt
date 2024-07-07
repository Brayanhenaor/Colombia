package com.brayan.colombia.presentation.screens.touristic

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.brayan.colombia.domain.model.repository.TouristicRepository
import com.brayan.colombia.domain.model.TouristicResponse
import com.brayan.colombia.presentation.common.base.BaseViewModel
import com.brayan.colombia.presentation.common.util.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TouristicViewModel @Inject constructor(
    private val touristicRepository: TouristicRepository

) : BaseViewModel() {
    var touristicPlaces by mutableStateOf<TouristicResponse?>(null)

    fun loadData() = viewModelScope.launch {
        screenState = ScreenState.Loading
        val result = touristicRepository.getTouristic()

        touristicPlaces = result
        screenState=ScreenState.Loaded
    }
}