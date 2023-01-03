package com.example.projectnr2try.data.remote

import retrofit2.http.GET
import retrofit2.http.Query


interface RecipeAPI {

    @GET("/recipes/complexSearch?&apiKey=1a8ef031a9ce4bccb9b623774aa76194")
    suspend fun GetAllRecipes(
    ):RecipeAPIInfo

    companion object {
        const val BASE_URL = "https://api.spoonacular.com/"
    }
}