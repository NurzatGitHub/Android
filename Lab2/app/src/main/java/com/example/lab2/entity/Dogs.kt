package com.example.lab2.entity

import com.google.gson.annotations.SerializedName

data class Dogs(
    @SerializedName("name") val name: String,
    @SerializedName("image_link") val image_link: String,
    @SerializedName("playfulness") val playfulness: Int,
    @SerializedName("protectiveness") val protectiveness: Int,
    @SerializedName("trainability") val trainability: Int,
)

