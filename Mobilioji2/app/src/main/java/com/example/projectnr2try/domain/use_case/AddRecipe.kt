package com.example.projectnr2try.domain.use_case

import android.net.Uri
import androidx.compose.runtime.MutableState
import com.example.projectnr2try.domain.repository.AddRecipesResponce
import com.example.projectnr2try.domain.repository.RecipeRepository

class AddRecipe(
    private val repository: RecipeRepository
) {
    suspend operator fun invoke(userId:String, name: String, catagory:String, steps: String, ingredients:String): AddRecipesResponce {
        return repository.AddRecipeToFirestore(userId,name,catagory,steps,ingredients)
    }
}