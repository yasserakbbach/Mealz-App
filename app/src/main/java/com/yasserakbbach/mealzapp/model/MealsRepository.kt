package com.yasserakbbach.mealzapp.model

import com.yasserakbbach.mealzapp.model.response.MealsList

class MealsRepository {

    fun getMeals(): MealsList = MealsList(listOf())
}