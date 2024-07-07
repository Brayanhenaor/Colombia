package com.brayan.colombia.data.api

import com.brayan.colombia.domain.model.CountryDataResponse
import com.brayan.colombia.domain.model.TouristicResponse
import retrofit2.http.GET

interface TouristicApiService {
    @GET("TouristicAttraction")
    suspend fun getTouristic(): TouristicResponse
}