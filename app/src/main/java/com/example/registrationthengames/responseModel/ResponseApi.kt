package com.example.registrationthengames.responseModel

import com.google.gson.annotations.SerializedName

data class ResponseApi(
    @SerializedName("seo_title")
    val title: String,
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: String?,
    @SerializedName("results")
    val results: List<GamesResultResponse>,
)