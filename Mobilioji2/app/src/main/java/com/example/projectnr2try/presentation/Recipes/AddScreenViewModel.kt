package com.example.projectnr2try.presentation.Recipes

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.projectnr2try.domain.use_case.RecipeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddScreenViewModel @Inject constructor(
    private val recipesUseCase: RecipeUseCases
): ViewModel()
{
    private val nameof = mutableStateOf("")
    val recipeName: State<String> = nameof

    private val catagoryof = mutableStateOf("")
    val recipecatagory: State<String> = catagoryof

    private val stepsof = mutableStateOf("")
    val recipesteps: State<String> = stepsof

    private val ingredientsof = mutableStateOf("")
    val recipeingredients: State<String> = ingredientsof

}