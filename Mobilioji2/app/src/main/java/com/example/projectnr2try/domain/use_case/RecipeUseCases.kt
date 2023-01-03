package com.example.projectnr2try.domain.use_case
import com.example.projectnr2try.domain.use_case.APIUse_case.API_Get_Use_Case

data class RecipeUseCases (
     val GetRecipesUseCase: GetRecipes,
     val DeleteRecipesUseCase: DeleteRecipes,
     val EditRecipesUseCase: EditRecipe,
     val AddRecipeUseCase: AddRecipe,
   //  val GetApiRecipesUseCase: API_Get_Use_Case,
)