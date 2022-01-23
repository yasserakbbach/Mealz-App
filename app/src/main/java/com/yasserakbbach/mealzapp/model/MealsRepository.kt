package com.yasserakbbach.mealzapp.model

import android.util.Log
import com.yasserakbbach.mealzapp.model.api.MealsService
import com.yasserakbbach.mealzapp.model.response.MealsList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MealsRepository(
    private val mealsService: MealsService = MealsService()
) {

    fun getMeals(successResponse: (response: MealsList?) -> Unit) {
        mealsService.getMeals().enqueue(object: Callback<MealsList> {
            override fun onResponse(call: Call<MealsList>, response: Response<MealsList>) {

                if(response.isSuccessful) successResponse(response.body())
                else Log.d("ERROR", "onResponse#Error:")

            }

            override fun onFailure(call: Call<MealsList>, t: Throwable) {
                // TODO handle failure
                Log.d("ERROR", "onFailure: $t")
            }
        })
    }
}