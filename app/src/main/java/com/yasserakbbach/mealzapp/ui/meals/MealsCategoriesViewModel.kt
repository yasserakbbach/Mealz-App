package com.yasserakbbach.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasserakbbach.mealzapp.model.MealsRepository
import com.yasserakbbach.mealzapp.model.response.Meal
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val mealsRepository: MealsRepository = MealsRepository()
) : ViewModel() {

    val meals: MutableState<List<Meal>> = mutableStateOf(emptyList())

    init {
        viewModelScope.launch(Dispatchers.IO) {
            meals.value = getMeals()
        }
    }

    suspend fun getMeals(): List<Meal> = mealsRepository.getMeals().categories

    fun findMealById(mealId: String): Meal? =
        meals.value.find { it.id == mealId }
}