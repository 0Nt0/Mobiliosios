package com.example.projectnr2try.data.remote

data class RecipeAPIInfo(
    val number: Int,
    val offset: Int,
    val results: List<Result>,
    val totalResults: Int
)