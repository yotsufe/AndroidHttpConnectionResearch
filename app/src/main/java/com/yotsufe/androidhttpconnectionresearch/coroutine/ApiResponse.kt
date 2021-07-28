package com.yotsufe.androidhttpconnectionresearch.coroutine

import java.io.Serializable

data class Item(
    val id: String,
    val title: String,
    val url: String,
): Serializable
