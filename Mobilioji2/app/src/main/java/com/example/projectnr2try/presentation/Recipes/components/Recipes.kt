package com.example.projectnr2try.presentation.Recipes.components


import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.projectnr2try.domain.model.Responce
import com.example.projectnr2try.domain.repository.Recipes
import com.example.projectnr2try.presentation.Recipes.RecipesViewModel

@Composable
fun Recipes (
    viewmodel:RecipesViewModel= hiltViewModel(),
    recipeContent: @Composable (recipes: Recipes)->Unit
)
{
    when (val recResponce=viewmodel.RecipesResponse)
    {
        is Responce.Success->  recipeContent(recResponce.data)
        is Responce.Failure->print(recResponce.e)

    }

}