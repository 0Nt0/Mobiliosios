package com.example.projectnr2try.domain.use_case

import com.example.projectnr2try.domain.repository.RecipeRepository
import com.example.projectnr2try.domain.repository.RecipesResponce
import kotlinx.coroutines.flow.Flow

class GetRecipes(
    private val repository: RecipeRepository
) {
    operator fun invoke()= repository.GetRecipesFromFirestore()
}