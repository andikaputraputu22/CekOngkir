package com.moonlightsplitter.cekongkir.models

data class CityModel(
    val rajaongkir: RajaOngkirCity
)

data class RajaOngkirCity(
    val query: ArrayList<Any>,
    val status: StatusCity,
    val results: ArrayList<ResultsCity>
)

data class StatusCity(
    val code: Int,
    val description: String
)

data class ResultsCity(
    val city_id: String,
    val province_id: String,
    val province: String,
    val type: String,
    val city_name: String,
    val postal_code: String
)