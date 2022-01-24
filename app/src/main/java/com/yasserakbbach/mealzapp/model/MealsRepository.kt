package com.yasserakbbach.mealzapp.model

import com.yasserakbbach.mealzapp.model.api.MealsService

class MealsRepository(
    private val mealsService: MealsService = MealsService()
) {

    suspend fun getMeals() = mealsService.getMeals()
}