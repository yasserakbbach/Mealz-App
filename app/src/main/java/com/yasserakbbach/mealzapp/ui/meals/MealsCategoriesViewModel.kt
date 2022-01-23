package com.yasserakbbach.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.yasserakbbach.mealzapp.model.MealsRepository
import com.yasserakbbach.mealzapp.model.response.MealsList

class MealsCategoriesViewModel(
    private val mealsRepository: MealsRepository = MealsRepository()
) : ViewModel() {

    fun getMeals(successResponse: (response: MealsList?) -> Unit) {
        mealsRepository.getMeals {
            successResponse(it)
        }
    }
}