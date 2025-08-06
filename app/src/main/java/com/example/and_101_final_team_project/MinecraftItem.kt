package com.example.and_101_final_team_project

import com.google.gson.annotations.SerializedName

data class MinecraftItem(
    @SerializedName("name")
    val name: String,

    @SerializedName("namespacedId")
    val namespacedId: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("stackSize")
    val stackSize: Int,

    @SerializedName("renewable")
    val renewable: Boolean,

    @SerializedName("category")
    val category: String // This is the field that was missing
)