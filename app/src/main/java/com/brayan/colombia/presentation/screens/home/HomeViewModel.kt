package com.brayan.colombia.presentation.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brayan.colombia.domain.model.repository.CountryRepository
import com.brayan.colombia.domain.model.CountryDataResponse
import com.brayan.colombia.presentation.common.base.BaseViewModel
import com.brayan.colombia.presentation.common.util.ScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val countryRepository: CountryRepository
) : BaseViewModel() {
    var countryData by mutableStateOf<CountryDataResponse?>(null)

    fun loadData() = viewModelScope.launch {
        screenState = ScreenState.Loading
        val result = countryRepository.getCountryData()

        countryData = result
        screenState = ScreenState.Loaded
    }
}