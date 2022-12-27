package com.example.projectnr2try.domain.repository

import com.example.projectnr2try.domain.model.auth.Resource
import com.google.firebase.auth.FirebaseUser

interface AuthenticationRepo{
    val currentUser:FirebaseUser?
    suspend fun Login(email: String, password:String): Resource<FirebaseUser>
    suspend fun Register(email: String, password:String, username:String): Resource<FirebaseUser>
    fun LogOut()
}