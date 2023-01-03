package com.example.projectnr2try.presentation.Recipes.components

import com.example.projectnr2try.R

enum class CatagoryList(val ch:String) {
    Cold("Cold"),
    Soups("Soups"),
    Desert("Desert"),
    Drinks("Drinks"),
    Pizzas("Pizzas"),
    Chicken("Chicken"),
    Pork("Pork"),

    Šalti("Cold"),
    Sriubos("Soups"),
    Desertai("Desert"),
    Gėrimai("Drinks"),
    Picos("Pizzas"),
    Vištiena("Chicken"),
    Kiauliena("Pork")

}

fun AllFoods():List<CatagoryList>{
    return listOf(CatagoryList.Cold, CatagoryList.Soups, CatagoryList.Desert, CatagoryList.Drinks, CatagoryList.Pizzas,CatagoryList.Chicken,CatagoryList.Pork,CatagoryList.Šalti, CatagoryList.Sriubos, CatagoryList.Desertai, CatagoryList.Gėrimai, CatagoryList.Picos,CatagoryList.Vištiena,CatagoryList.Kiauliena)
}