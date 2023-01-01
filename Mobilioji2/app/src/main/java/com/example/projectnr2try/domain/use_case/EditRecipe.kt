package com.example.projectnr2try.domain.use_case

import com.example.projectnr2try.domain.repository.ChangeRecipeResponce
import com.example.projectnr2try.domain.repository.RecipeRepository

class EditRecipe(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(id: Int,name:String,catagory:String, steps:String, ingredients:String): ChangeRecipeResponce {
        return repository.ChangeRecipeInFirestore(id,name, catagory,steps,ingredients )
    }
}