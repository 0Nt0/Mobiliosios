package com.example.projectnr2try

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectnr2try.presentation.Recipes.AppScreens.*
import com.example.projectnr2try.presentation.Recipes.RecipeAddScreen
import com.example.projectnr2try.presentation.Recipes.DeleteScreen
import com.example.projectnr2try.presentation.Recipes.ProfileScreen
import com.example.projectnr2try.presentation.Recipes.RecipeScreen
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.Route

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecipeApplication()
        }
    }
}

@Composable
fun RecipeApplication()
{

    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = Screens.LoginScreen.route)
    {
        composable(Screens.LoginScreen.route){
            RegisterScreen(navController=navController)
        }
        composable("LogInScreen"){
            LoginScreen(navController = navController)
        }
        composable(Screens.RecipeScreen.route){
            RecipeScreen(navController = navController)
        }
        composable(Screens.RecipeAddScreen.route){
            RecipeAddScreen(navController = navController)
        }
        composable(Screens.DeleteScreen.route){
            DeleteScreen(navController= navController)
        }
        composable(Screens.ProfileScreen.route){
            ProfileScreen(navController= navController)
        }
        composable(Screens.RecipeCatagoryScreen.route+"/{name}"){
           navBackStack-> val id= navBackStack.arguments?.getString("name")
            RecipeCatagoryScreen(navController = navController, ItemId = id)
        }
        composable(Screens.RecipeInfoScreen.route+"/{name}"){
                navBackStack-> val id= navBackStack.arguments?.getString("name")
            RecipeInfoScreen(navController = navController, ItemId = id)
        }

    }

}

