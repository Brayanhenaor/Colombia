package com.brayan.colombia.domain.model.repository

import com.brayan.colombia.data.api.CountryApiService
import com.brayan.colombia.data.api.TouristicApiService
import com.brayan.colombia.domain.model.TouristicResponse
import javax.inject.Inject

class TouristicRepository@Inject constructor(
    private val touristicApiService: TouristicApiService
) {
    suspend fun getTouristic(): TouristicResponse{
        return touristicApiService.getTouristic()
    }
}