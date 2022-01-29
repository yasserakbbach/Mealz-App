package com.yasserakbbach.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.yasserakbbach.mealzapp.ui.mealdetails.MealsDetailsScreen
import com.yasserakbbach.mealzapp.ui.meals.MealsCategoriesScreen
import com.yasserakbbach.mealzapp.ui.meals.MealsCategoriesViewModel
import com.yasserakbbach.mealzapp.ui.theme.MealzAppTheme
import com.yasserakbbach.mealzapp.utils.Routes

class MainActivity : ComponentActivity() {

    private val mealsViewModel: MealsCategoriesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealzApp(mealsViewModel)
            }
        }
    }
}

@Composable
fun MealzApp(
    mealsViewModel: MealsCategoriesViewModel
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MEALS_LIST_ROUTE) {
        composable(
            route = Routes.MEALS_LIST_ROUTE
        ) { MealsCategoriesScreen(navController) }
        composable(
            route = Routes.MEAL_DETAILS,
            arguments = listOf(
                navArgument(Routes.MEAL_ID) { type = NavType.StringType}
            )
        ) { backStackEntry ->
            val mealId = backStackEntry.arguments?.getString(Routes.MEAL_ID)
            MealsDetailsScreen(
                mealId = mealId.orEmpty(),
                mealsViewModel = mealsViewModel
            )
        }
    }
}