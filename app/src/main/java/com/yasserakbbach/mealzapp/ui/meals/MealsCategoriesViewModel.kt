package com.yasserakbbach.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.yasserakbbach.mealzapp.model.MealsRepository

class MealsCategoriesViewModel(
    private val mealsRepository: MealsRepository = MealsRepository()
) : ViewModel() {
}