package com.brayan.colombia.data.api

import com.brayan.colombia.domain.model.CountryDataResponse
import retrofit2.http.GET

interface CountryApiService {
    @GET("Country/Colombia")
    suspend fun getCountryData(): CountryDataResponse
}