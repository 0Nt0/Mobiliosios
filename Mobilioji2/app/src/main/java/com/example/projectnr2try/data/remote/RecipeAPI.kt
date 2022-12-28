package com.example.projectnr2try.data.remote

import retrofit2.http.GET
import retrofit2.http.Query


interface RecipeAPI {

    @GET("https://api.spoonacular.com/recipes/complexSearch?&apiKey=1a8ef031a9ce4bccb9b623774aa76194")
    suspend fun GetAllRecipes(
    @Query("limit") limit:Int,
    @Query("offset") offset:Int
    ):RecipeAPIInfo
}