package com.moonlightsplitter.cekongkir.models

data class SubdistrictModel(
    val rajaongkir: RajaOngkirDistrict
)

data class RajaOngkirDistrict(
    val query: QueryDistrict,
    val status: StatusDistrict,
    val results: ArrayList<ResultsSubdistrict>
)

data class QueryDistrict(
    val city: String
)

data class StatusDistrict(
    val code: Int,
    val description: String
)

data class ResultsSubdistrict(
    val subdistrict_id: String,
    val province_id: String,
    val province: String,
    val city_id: String,
    val city: String,
    val type: String,
    val subdistrict_name: String
)