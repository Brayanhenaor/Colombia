package com.brayan.colombia.di

import com.brayan.colombia.data.api.CountryApiService
import com.brayan.colombia.data.api.TouristicApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api-colombia.com/api/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesCountryApiService(retrofit: Retrofit): CountryApiService{
        return retrofit.create(CountryApiService::class.java)
    }

    @Provides
    fun providesTouristicApiService(retrofit: Retrofit): TouristicApiService{
        return retrofit.create(TouristicApiService::class.java)
    }
}