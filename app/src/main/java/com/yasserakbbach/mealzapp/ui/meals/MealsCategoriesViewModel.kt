package com.yasserakbbach.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yasserakbbach.mealzapp.model.MealsRepository
import com.yasserakbbach.mealzapp.model.response.Meal
import com.yasserakbbach.mealzapp.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(
    private val mealsRepository: MealsRepository = MealsRepository()
) : ViewModel() {

    val meals: MutableState<List<Meal>> = mutableStateOf(emptyList())
    val isLoading = mutableStateOf(true)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            delay(Constants.DELAY_LOADING)
            meals.value = getMeals()
            isLoading.value = false
        }
    }

    suspend fun getMeals(): List<Meal> = mealsRepository.getMeals().categories

    fun findMealById(mealId: String): Meal? =
        meals.value.find { it.id == mealId }
}