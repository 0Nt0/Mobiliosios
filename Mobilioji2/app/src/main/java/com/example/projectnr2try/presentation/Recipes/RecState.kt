package com.example.projectnr2try.presentation.Recipes

import com.example.projectnr2try.data.remote.RecipeAPIInfo

class RecState {
    val characters: List<RecipeAPIInfo> = emptyList()
    val isLoading: Boolean = false
    val error: String? = null
}