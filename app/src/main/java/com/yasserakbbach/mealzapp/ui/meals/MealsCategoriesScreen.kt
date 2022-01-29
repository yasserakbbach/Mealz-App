package com.yasserakbbach.mealzapp.ui.meals

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.yasserakbbach.mealzapp.model.response.Meal
import com.yasserakbbach.mealzapp.ui.theme.MealzAppTheme
import com.yasserakbbach.mealzapp.utils.Routes

@Composable
fun MealsCategoriesScreen(
    navController: NavController
) {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val meals = viewModel.meals.value
    val scrollState = rememberLazyListState()
    val offset = (scrollState.firstVisibleItemScrollOffset / 600f + scrollState.firstVisibleItemIndex)

    Column {
        CompositionLocalProvider(
            LocalContentAlpha provides (offset - 1).coerceAtLeast(0f).coerceAtMost(1f)
        ) {
            Text(
                text = "List Meals",
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
        if(viewModel.isLoading.value) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(12.dp),
            state = scrollState
        ) {
            items(meals) {
                Meal(it) {
                    navController.navigate(
                        Routes.MEAL_DETAILS_FORMATTED_ROUTE.format(it.id)
                    )
                }
            }
        }
    }
}

@Composable
fun Meal(
    meal: Meal,
    onClick: () -> Unit
) {
    var isDescriptionVisible by remember { mutableStateOf(false)}
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

        Column(
            modifier = Modifier.animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .height(IntrinsicSize.Min)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = rememberImagePainter(meal.imageUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .size(128.dp)
                        .clickable { onClick() }
                )
                Text(
                    text = meal.name,
                    style = MaterialTheme.typography.h6,
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Start
                )
                Icon(
                    imageVector = if(isDescriptionVisible) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "toggle description",
                    modifier = Modifier
                        .size(30.dp)
                        .clickable { isDescriptionVisible = !isDescriptionVisible }
                        .align(
                            if (isDescriptionVisible) Alignment.Bottom else Alignment.CenterVertically
                        )
                )
            }
            if(isDescriptionVisible) {
                Text(
                    text = meal.description,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 3
                )
            }
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