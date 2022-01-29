package com.yasserakbbach.mealzapp.ui.mealdetails

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.yasserakbbach.mealzapp.ui.meals.MealsCategoriesViewModel

// TODO for more animations check: https://developer.android.com/jetpack/compose/animation#animationspec
@Composable
fun MealsDetailsScreen(
    mealId: String,
    mealsViewModel: MealsCategoriesViewModel
) {

    val meal = mealsViewModel.findMealById(mealId)
    val scrollState = rememberScrollState()
    var shouldAnimateImg by remember { mutableStateOf(false) }
    val imageDpAnimated by animateDpAsState(
        targetValue = if(shouldAnimateImg) 200.dp else 100.dp,
        animationSpec = tween(
            durationMillis = 300,
            delayMillis = 70,
            easing = LinearOutSlowInEasing
        )
    )
    val offset = (1 - (scrollState.value / 600f)).coerceAtMost(1f)
    val animatedSizeImg by animateDpAsState(targetValue = (imageDpAnimated * offset).coerceAtMost(200.dp))

    LaunchedEffect(key1 = "") {
        shouldAnimateImg = true
    }

    Surface {
        Column(
            modifier = Modifier.fillMaxSize(),
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
                modifier = Modifier.size(animatedSizeImg)
            )
            Text(
                text = meal?.name.orEmpty(),
                style = MaterialTheme.typography.h4,
            )
            Surface(
                modifier = Modifier.verticalScroll(scrollState)
            ) {
                Column {
                    Text(
                        text = meal?.description.orEmpty(),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .padding(24.dp)
                    )

                    Text(
                        text = meal?.description.orEmpty(),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .padding(24.dp)
                    )

                    Text(
                        text = meal?.description.orEmpty(),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .padding(24.dp)
                    )

                    Text(
                        text = meal?.description.orEmpty(),
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 12.dp)
                    )
                    Divider(
                        color = Color.Gray,
                        modifier = Modifier
                            .height(1.dp)
                            .fillMaxWidth()
                            .padding(24.dp)
                    )
                }
            }
        }
    }
}