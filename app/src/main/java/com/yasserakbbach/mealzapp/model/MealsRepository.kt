package com.yasserakbbach.mealzapp.model

import com.yasserakbbach.mealzapp.model.api.MealsService
import com.yasserakbbach.mealzapp.model.response.MealsList

class MealsRepository(
    private val mealsService: MealsService = MealsService()
) {

    fun getMeals(): MealsList? {
        return mealsService.getMeals().execute().body()
    }
}