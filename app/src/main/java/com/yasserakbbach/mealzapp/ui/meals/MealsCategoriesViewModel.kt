package com.yasserakbbach.mealzapp.ui.meals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yasserakbbach.mealzapp.model.MealsRepository
import com.yasserakbbach.mealzapp.model.response.Meal

class MealsCategoriesViewModel(
    private val mealsRepository: MealsRepository = MealsRepository()
) : ViewModel() {

    val meals = MutableLiveData<List<Meal>>()

    fun getMeals() {
        mealsRepository.getMeals {
            meals.value = it?.categories.orEmpty()
        }
    }
}