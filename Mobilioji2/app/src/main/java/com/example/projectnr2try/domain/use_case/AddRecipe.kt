package com.example.projectnr2try.domain.use_case

import com.example.projectnr2try.domain.repository.AddRecipesResponce
import com.example.projectnr2try.domain.repository.RecipeRepository

class AddRecipe(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(name: String, catagory:String, steps: String, ingredients:String): AddRecipesResponce {
        return repository.AddRecipeToFirestore(name,catagory,steps,ingredients)
    }
}