package com.yasserakbbach.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.yasserakbbach.mealzapp.model.MealsRepository
import com.yasserakbbach.mealzapp.model.response.Meal

class MealsCategoriesViewModel(
    private val mealsRepository: MealsRepository = MealsRepository()
) : ViewModel() {

    fun getMeals(): List<Meal> =
        mealsRepository.getMeals()?.categories.orEmpty()
}