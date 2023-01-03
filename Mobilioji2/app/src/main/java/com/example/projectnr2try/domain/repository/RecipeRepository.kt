package com.example.projectnr2try.domain.repository



import com.example.projectnr2try.domain.model.Recipe
import com.example.projectnr2try.domain.model.Responce
import kotlinx.coroutines.flow.Flow

typealias Recipes= List<Recipe>
typealias RecipesResponce = Responce<Recipes>
typealias AddRecipesResponce = Responce<Boolean>
typealias DeleteRecipeResponce = Responce<Boolean>
typealias ChangeRecipeResponce = Responce<Boolean>

interface RecipeRepository {
    fun GetRecipesFromFirestore(): Flow<RecipesResponce>
    suspend fun AddRecipeToFirestore(
        UserId:String,
        name: String, catagory: String, steps:String, ingredients:String): AddRecipesResponce
    suspend fun DeleteRecipeFromFirestore(id: String?): DeleteRecipeResponce
    suspend fun ChangeRecipeInFirestore(id: String,userId:String, name:String, catagory:String, steps:String, ingredients:String): ChangeRecipeResponce

}