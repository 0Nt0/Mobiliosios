package com.example.projectnr2try.presentation.Recipes.AppScreens

sealed class Screens(var route:String){
    object LoginScreen:Screens("LogInScreen")
    object RecipeCatagoryScreen:Screens("RecipeCatagoryScreen")
    object RegisterScreen:Screens("RegisterScreen")
    object RecipeScreen : Screens("MainScreen")
    object RecipeAddScreen : Screens("AddScreen")
    object DeleteScreen : Screens("DeleteScreen")
    object ProfileScreen : Screens("ProfileScreen")
    object RecipeInfoScreen:Screens("RecipeInfoScreen")
}