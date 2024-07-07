package com.brayan.colombia.domain.model


typealias TouristicResponse = Array<Touristic>

data class Touristic (
    val id: Long,
    val name: String,
    val description: String,
    val images: List<String>,
    val latitude: String,
    val longitude: String,
)
