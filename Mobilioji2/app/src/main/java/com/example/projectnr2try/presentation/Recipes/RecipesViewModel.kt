package com.example.projectnr2try.presentation.Recipes


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
//import com.example.projectnr2try.data.repository.RecipeApiRepoImpl
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

     fun GetRecipesUseCase()= viewModelScope.launch{
         recipesUseCase.GetRecipesUseCase().collect(){
             response-> RecipesResponse=response
         }

    }
     fun DeleteRecipesUseCase(id: String?) {
         viewModelScope.launch {
             deleteRecipeResponse= Responce.Loading
             deleteRecipeResponse = recipesUseCase.DeleteRecipesUseCase(id)
         }
     }
    fun AddRecipesUseCase(UserId:String, name:String, catagory:String, steps:String, ingredients:String) {
        viewModelScope.launch {
            AddRecipeResponse=Responce.Loading
            AddRecipeResponse = recipesUseCase.AddRecipeUseCase(UserId,name,catagory,steps,ingredients)
        }
    }
    fun EditRecipesUseCase(id: String,userId:String, name:String, catagory:String, steps:String, ingredients:String) {
        viewModelScope.launch {
            UpdateRecipeResponse = recipesUseCase.EditRecipesUseCase(id,userId,name,catagory,steps,ingredients)
        }
    }


}