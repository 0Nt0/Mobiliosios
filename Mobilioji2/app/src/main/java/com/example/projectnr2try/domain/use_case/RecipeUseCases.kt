package com.example.projectnr2try.domain.use_case

data class RecipeUseCases (
     val GetRecipesUseCase: GetRecipes,
     val DeleteRecipesUseCase: DeleteRecipes,
     val EditRecipesUseCase: EditRecipe,
     val AddRecipeUseCase: AddRecipe
)