package com.yotsufe.androidhttpconnectionresearch.coroutine

import retrofit2.http.GET

interface ApiInterface {
    @GET("items")
    suspend fun getItems(): Array<Item>
}
