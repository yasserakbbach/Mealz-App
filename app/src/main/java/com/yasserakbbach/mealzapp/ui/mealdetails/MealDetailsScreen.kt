package com.yasserakbbach.mealzapp.ui.mealdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.yasserakbbach.mealzapp.ui.meals.MealsCategoriesViewModel

@Composable
fun MealsDetailsScreen(
    mealId: String,
    mealsViewModel: MealsCategoriesViewModel
) {

    val meal = mealsViewModel.findMealById(mealId)
    val scroll = rememberScrollState()

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(scroll),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = rememberImagePainter(
                data = meal?.imageUrl,
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = "meal image",
            modifier = Modifier.size(200.dp)
        )
        Text(
            text = meal?.name.orEmpty(),
            style = MaterialTheme.typography.h4
        )
        Text(
            text = meal?.description.orEmpty(),
            style = MaterialTheme.typography.body2,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
    }
}