package com.example.projectnr2try.presentation.Recipes


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectnr2try.domain.model.Responce
import com.example.projectnr2try.domain.repository.AddRecipesResponce
import com.example.projectnr2try.domain.repository.ChangeRecipeResponce
import com.example.projectnr2try.domain.repository.DeleteRecipeResponce
import com.example.projectnr2try.domain.repository.RecipesResponce
import com.example.projectnr2try.domain.use_case.RecipeUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipesViewModel @Inject constructor(
private val recipesUseCase: RecipeUseCases
): ViewModel(){
    var RecipesResponse by mutableStateOf<RecipesResponce>(Responce.Loading)
        private set
    var AddRecipeResponse by mutableStateOf<AddRecipesResponce>(Responce.Success(false))
        private set
    var deleteRecipeResponse by mutableStateOf<DeleteRecipeResponce>(Responce.Success(false))
        private set
    var UpdateRecipeResponse by mutableStateOf<ChangeRecipeResponce>(Responce.Success(false))
        private set

    init {
           GetRecipesUseCase()
    }

    private fun GetRecipesUseCase(){
        viewModelScope.launch {
            recipesUseCase.GetRecipesUseCase().collect{response-> RecipesResponse= response} }
    }
     fun DeleteRecipesUseCase(id:Int) {
         viewModelScope.launch {
             deleteRecipeResponse = recipesUseCase.DeleteRecipesUseCase(id)
         }
     }
    fun AddRecipesUseCase(name:String, catagory:String, steps:String, ingredients:String) {
        viewModelScope.launch {
            AddRecipeResponse = recipesUseCase.AddRecipeUseCase(name,catagory,steps,ingredients)
        }
    }
    fun EditRecipesUseCase(id:Int,name:String, catagory:String, steps:String, ingredients:String) {
        viewModelScope.launch {
            UpdateRecipeResponse = recipesUseCase.EditRecipesUseCase(id,name,catagory,steps,ingredients)
        }
    }


}