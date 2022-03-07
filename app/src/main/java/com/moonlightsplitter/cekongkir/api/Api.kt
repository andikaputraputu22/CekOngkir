package com.moonlightsplitter.cekongkir.api

import com.moonlightsplitter.cekongkir.models.CityModel
import com.moonlightsplitter.cekongkir.models.CostModel
import com.moonlightsplitter.cekongkir.models.ProvinceModel
import com.moonlightsplitter.cekongkir.models.SubdistrictModel
import retrofit2.Response
import retrofit2.http.*

interface Api {
    @GET("province")
    suspend fun getProvince(): Response<ProvinceModel>

    @GET("city")
    suspend fun getCity(): Response<CityModel>

    @GET("subdistrict")
    suspend fun getSubdistrict(@Query("city") city: String): Response<SubdistrictModel>

    @FormUrlEncoded
    @POST("cost")
    suspend fun getCost(@Field("origin") origin: String,
                        @Field("originType") originType: String,
                        @Field("destination") destination: String,
                        @Field("destinationType") destinationType: String,
                        @Field("weight") weight: String,
                        @Field("courier") courier: String): Response<CostModel>
}