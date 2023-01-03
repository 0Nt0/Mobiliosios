package com.example.projectnr2try.presentation.Recipes

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectnr2try.domain.model.Responce
import com.example.projectnr2try.domain.use_case.APIUse_case.API_Get_Use_Case
import com.example.projectnr2try.util.Resource
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class APIViewModel @Inject constructor(
    private val getRecipeApi: API_Get_Use_Case
):ViewModel() {

    var states by mutableStateOf(RecState())
        private set

    init {
        GetApiRecipes()
    }
     fun GetApiRecipes(){
         getRecipeApi().onEach { result ->
//             states = when(result){
//                 is Resource.Success<*> -> {
//                     states.copy(characters = result.data ?: emptyList())
//                 }
//                 is Resource.Error<*>-> {
//                     states.copy(error = result.message ?: "An unexpected error occurred!")
//                 }
//
//             }

        }.launchIn(viewModelScope)
    }
}