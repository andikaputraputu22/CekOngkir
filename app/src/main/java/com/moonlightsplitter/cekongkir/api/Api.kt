package com.moonlightsplitter.cekongkir.api

import com.moonlightsplitter.cekongkir.models.CityModel
import com.moonlightsplitter.cekongkir.models.ProvinceModel
import com.moonlightsplitter.cekongkir.models.SubdistrictModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("province")
    suspend fun getProvince(): Response<ProvinceModel>

    @GET("city")
    suspend fun getCity(): Response<CityModel>

    @GET("subdistrict")
    suspend fun getSubdistrict(@Query("city") city: String): Response<SubdistrictModel>
}