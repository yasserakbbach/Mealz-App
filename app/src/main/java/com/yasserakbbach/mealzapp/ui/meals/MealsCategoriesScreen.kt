package com.yasserakbbach.mealzapp.ui.meals

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberImagePainter
import com.yasserakbbach.mealzapp.model.response.Meal
import com.yasserakbbach.mealzapp.ui.theme.MealzAppTheme

@Composable
fun MealsCategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.meals.value

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(12.dp)
    ) {
        items(meals) {
            Meal(it)
        }
    }

}

@Composable
fun Meal(
    meal: Meal
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp,
        border = BorderStroke(
            width = 1.dp,
            color = Color.LightGray
        ),
        modifier = Modifier
            .padding(
                top = 12.dp
            )
            .fillMaxWidth()
    ) {

        Row(
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Column {

                Image(
                    painter = rememberImagePainter(meal.imageUrl),
                    contentDescription = null,
                    modifier = Modifier.size(128.dp)
                )
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Divider(
                thickness = 1.dp,
                color = Color.LightGray,
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Text(
                text = meal.description,
                maxLines = 3,
                modifier = Modifier.padding(start = 8.dp)
            )
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        //MealsCategoriesScreen()
        //Meal()
    }
}