package com.moonlightsplitter.cekongkir.api

import com.moonlightsplitter.cekongkir.models.CityModel
import com.moonlightsplitter.cekongkir.models.ProvinceModel
import retrofit2.Response
import retrofit2.http.GET

interface Api {
    @GET("province")
    suspend fun getProvince(): Response<ProvinceModel>

    @GET("city")
    suspend fun getCity(): Response<CityModel>
}