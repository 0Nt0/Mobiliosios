package com.example.projectnr2try.presentation.Recipes

sealed class Screens(var route:String){
    object RecipeScreen : Screens("MainScreen")
    object AddScreen : Screens("AddScreen")
    object DeleteScreen : Screens("DeleteScreen")
    object ProfileScreen : Screens("ProfileScreen")

}