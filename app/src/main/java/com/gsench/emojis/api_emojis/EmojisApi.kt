package com.gsench.emojis.api_emojis

import com.gsench.emojis.api_emojis.dto.AllEmojisList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

object EmojisApiValues {
    const val EMOJIS_API_URL = "https://emojihub.yurace.pro"
}
interface EmojisApi {
    @GET("api/all")
    suspend fun getAllEmojisRemote(): AllEmojisList
    companion object {
        fun instantiateEmojisApi(): EmojisApi = Retrofit
            .Builder()
            .baseUrl(EmojisApiValues.EMOJIS_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(EmojisApi::class.java)
    }
}