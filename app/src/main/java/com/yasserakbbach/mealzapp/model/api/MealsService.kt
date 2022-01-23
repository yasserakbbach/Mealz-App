package com.yasserakbbach.mealzapp.model.api

import com.yasserakbbach.mealzapp.model.response.MealsList
import com.yasserakbbach.mealzapp.utils.Constants
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient

class MealsService {

    private var mealsApi: MealsApi

    init {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient =  OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        mealsApi = retrofit.create(MealsApi::class.java)
    }

    fun getMeals(): Call<MealsList> = mealsApi.getMeals()

    interface MealsApi {
        @GET("categories.php")
        fun getMeals(): Call<MealsList>
    }
}