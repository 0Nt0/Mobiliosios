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
import com.example.projectnr2try.util.RecipeApplication
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





