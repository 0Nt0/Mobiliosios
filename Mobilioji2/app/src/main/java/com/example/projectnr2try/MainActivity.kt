package com.example.projectnr2try

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.projectnr2try.presentation.Recipes.RecipeAddScreen
import com.example.projectnr2try.presentation.Recipes.RecipeScreen
import com.example.projectnr2try.presentation.Recipes.AppScreens.Screens
import com.example.projectnr2try.presentation.Recipes.DeleteScreen
import com.example.projectnr2try.presentation.Recipes.ProfileScreen
import com.example.projectnr2try.presentation.Recipes.AppScreens.LoginScreen
import com.example.projectnr2try.presentation.Recipes.AppScreens.RegisterScreen
import dagger.hilt.android.AndroidEntryPoint

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
        composable("RegisterScreen"){
            RegisterScreen(navController=navController)
        }
        composable("LogInScreen"){
            LoginScreen(navController = navController)
        }
        composable("MainScreen"){
            RecipeScreen(navController = navController)
        }
        composable("AddScreen"){
            RecipeAddScreen(navController = navController)
        }
        composable("DeleteScreen"){
            DeleteScreen(navController= navController)
        }
        composable("ProfileScreen"){
            ProfileScreen(navController= navController)
        }
        composable("RecipeInformationScreen"){
            //RecipeScreen()
        }

    }

}

