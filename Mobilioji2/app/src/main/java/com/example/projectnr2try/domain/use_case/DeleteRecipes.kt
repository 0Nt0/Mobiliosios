package com.example.projectnr2try.domain.use_case

import com.example.projectnr2try.domain.repository.DeleteRecipeResponce
import com.example.projectnr2try.domain.repository.RecipeRepository

class DeleteRecipes(
    private  val repository: RecipeRepository
) {
    suspend operator fun invoke(id: Int): DeleteRecipeResponce {
        return repository.DeleteRecipeFromFirestore(id)
    }
}