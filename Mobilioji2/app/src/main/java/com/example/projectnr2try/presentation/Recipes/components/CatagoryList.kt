package com.example.projectnr2try.presentation.Recipes.components

enum class CatagoryList(val ch:String) {
    Cold("Cold"),
    Soups("Soup"),
    Desert("Desert"),
    Drinks("Drinks"),
    Pizzas("Pizzas"),
    Chicken("Chicken"),
    Pork("Pork")
}

fun AllFoods():List<CatagoryList>{
    return listOf(CatagoryList.Cold, CatagoryList.Soups, CatagoryList.Desert, CatagoryList.Drinks, CatagoryList.Pizzas,CatagoryList.Chicken,CatagoryList.Pork)
}