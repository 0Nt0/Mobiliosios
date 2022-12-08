package com.example.project.domain.repository


import com.example.project.domain.model.Recipe
import com.example.project.domain.model.Responce
import kotlinx.coroutines.flow.Flow

typealias Recipes= List<Recipe>
typealias RecipesResponce = Responce<Recipes>
typealias AddRecipesResponce = Responce<Boolean>
typealias DeleteRecipeResponce = Responce<Boolean>
typealias ChangeRecipeResponce = Responce<Boolean>

interface RecipeRepository {
    fun GetRecipesFromFirestore(): Flow<RecipesResponce>
    suspend fun AddRecipeToFirestore(name: String, catagory: String, steps:String, ingredients:String): AddRecipesResponce
    suspend fun DeleteRecipeFromFirestore(id: Int): DeleteRecipeResponce
    suspend fun ChangeRecipeInFirestore(id:Int, name:String, catagory:String, steps:String, ingredients:String): ChangeRecipeResponce


}