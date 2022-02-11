package com.moonlightsplitter.cekongkir.repository

import com.moonlightsplitter.cekongkir.api.Api
import com.moonlightsplitter.cekongkir.models.CityModel
import com.moonlightsplitter.cekongkir.models.PreferencesModel
import com.moonlightsplitter.cekongkir.tools.*
import retrofit2.Response

class RajaOngkirRepository(
    private val api: Api,
    private val pref: SharedPreferencesManager
) {
//    suspend fun fetchCity(): Response<CityModel> {
//        return api.getCity()
//    }

    suspend fun fetchCity() = api.getCity()
    suspend fun fetchSubdistrict(id: String) = api.getSubdistrict(id)

    fun savePreferences(type: String, id: String, name: String) {
        when(type) {
            "origin" -> {
                pref.put(prefOriginId, id)
                pref.put(prefOriginName, name)
            }
            "destination" -> {
                pref.put(prefDestinationId, id)
                pref.put(prefDestinationName, name)
            }
        }
    }

    fun getPreferences(): List<PreferencesModel> {
        return listOf(
            PreferencesModel(type = "origin", id = pref.getString(prefOriginId), name = pref.getString(
                prefOriginName)),
            PreferencesModel(type = "destination", id = pref.getString(prefDestinationId), name = pref.getString(
                prefDestinationName))
        )
    }
}