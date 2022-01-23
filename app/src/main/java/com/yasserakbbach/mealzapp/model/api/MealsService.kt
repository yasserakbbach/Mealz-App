package com.yasserakbbach.mealzapp.model.api

import com.yasserakbbach.mealzapp.model.response.MealsList
import com.yasserakbbach.mealzapp.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class MealsService {

    private var mealsApi: MealsApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        mealsApi = retrofit.create(MealsApi::class.java)
    }

    fun getMeals(): Call<MealsList> = mealsApi.getMeals()

    interface MealsApi {
        @GET("categories.php")
        fun getMeals(): Call<MealsList>
    }
}