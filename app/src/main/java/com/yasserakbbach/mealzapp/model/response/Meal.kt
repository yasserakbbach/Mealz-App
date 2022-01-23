package com.yasserakbbach.mealzapp.model.response

import com.google.gson.annotations.SerializedName

data class Meal(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryThumb") val imageUrl: String,
    @SerializedName("strCategoryDescription") val description: String,
)