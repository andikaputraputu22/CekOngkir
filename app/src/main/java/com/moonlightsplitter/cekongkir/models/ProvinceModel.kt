package com.moonlightsplitter.cekongkir.models

data class ProvinceModel(
    val rajaongkir: RajaOngkirProvince
)

data class RajaOngkirProvince(
    val query: ArrayList<Any>,
    val status: StatusProvince,
    val results: ArrayList<ResultsProvince>
)

data class StatusProvince(
    val code: Int,
    val description: String
)

data class ResultsProvince(
    val province_id: String,
    val province: String
)