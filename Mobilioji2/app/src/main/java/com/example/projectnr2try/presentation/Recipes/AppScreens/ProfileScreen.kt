package com.example.projectnr2try.presentation.Recipes

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectnr2try.domain.model.auth.Resource
import com.example.projectnr2try.presentation.Recipes.AppScreens.Screens
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    viewmodel: LoginRegisterViewModel = hiltViewModel(),
    navController: NavController
) {
    Scaffold(
        backgroundColor = Color.Black,
        content = {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Button(
                    onClick = {
                        viewmodel.LogOut()
                        navController.navigate("LogInScreen"){
                            popUpTo("LogInScreen") { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(70.dp)
                        .border(3.dp, Color.Yellow, CircleShape),
                    shape= RoundedCornerShape(35.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                ) {
                    Text(text = "LOG OUT",
                        textAlign = TextAlign.Center,
                        color = Color.Yellow)
                }

            }
        }
    )


}