package com.moonlightsplitter.cekongkir.models

data class CostModel(
    val rajaongkir: RajaOngkirCost
)

data class RajaOngkirCost(
    val query: QueryCost,
    val status: StatusCost,
    val origin_details: OriginDetailsCost,
    val destination_details: DestinationDetailsCost,
    val results: ArrayList<ResultsCost>
)

data class QueryCost(
    val origin: String,
    val originType: String,
    val destination: String,
    val destinationType: String,
    val weight: Int,
    val courier: String
)

data class StatusCost(
    val code: Int,
    val description: String
)

data class OriginDetailsCost(
    val city_id: String,
    val province_id: String,
    val province: String,
    val type: String,
    val city_name: String,
    val postal_code: String
)

data class DestinationDetailsCost(
    val subdistrict_id: String,
    val province_id: String,
    val province: String,
    val city_id: String,
    val city: String,
    val type: String,
    val subdistrict_name: String
)

data class ResultsCost(
    val code: String,
    val name: String,
    val costs: ArrayList<Cost>
)

data class Cost(
    val service: String,
    val description: String,
    val cost: ArrayList<SubCost>
)

data class SubCost(
    val value: Int,
    val etd: String,
    val note: String
)