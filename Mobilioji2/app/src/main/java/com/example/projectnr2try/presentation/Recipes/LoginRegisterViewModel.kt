package com.example.projectnr2try.presentation.Recipes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectnr2try.domain.model.auth.Resource
import com.example.projectnr2try.domain.repository.AuthenticationRepo
import com.example.projectnr2try.domain.use_case.RecipeUseCases
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginRegisterViewModel @Inject constructor(
    private val repo: AuthenticationRepo
):ViewModel() {

    private val loginFlow= MutableStateFlow<Resource<FirebaseUser>?>(null)
    val loginFlow_:StateFlow<Resource<FirebaseUser>?> = loginFlow

    private val registerFlow= MutableStateFlow<Resource<FirebaseUser>?>(null)
    val registerFlow_:StateFlow<Resource<FirebaseUser>?> = registerFlow

    val currentUser:FirebaseUser?
        get()=repo.currentUser

    init {
        if(repo.currentUser !=null)
        {
            loginFlow.value =Resource.Success(repo.currentUser!!)
        }
    }

    fun Login(email:String, password:String)=viewModelScope.launch {
        loginFlow.value=Resource.Loading
        val res=repo.Login(email,password)
        loginFlow.value = res
    }
    fun Register(email:String, password:String, username:String)=viewModelScope.launch {
        registerFlow.value=Resource.Loading
        val res=repo.Register(email,password, username)
        registerFlow.value = res
    }
    fun LogOut()
    {
        repo.LogOut()
        loginFlow.value=null
        registerFlow.value=null
    }

}