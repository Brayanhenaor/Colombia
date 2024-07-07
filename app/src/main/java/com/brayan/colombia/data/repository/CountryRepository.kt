package com.brayan.colombia.domain.model.repository

import com.brayan.colombia.data.api.CountryApiService
import com.brayan.colombia.domain.model.CountryDataResponse
import javax.inject.Inject

class CountryRepository @Inject constructor(
    private val countryApiService: CountryApiService
) {
    suspend fun getCountryData(): CountryDataResponse{
        return countryApiService.getCountryData()
    }
}