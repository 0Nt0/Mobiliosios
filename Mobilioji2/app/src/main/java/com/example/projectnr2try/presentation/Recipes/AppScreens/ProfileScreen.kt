package com.example.projectnr2try.presentation.Recipes

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectnr2try.domain.model.auth.Resource
import com.example.projectnr2try.presentation.Recipes.AppScreens.Screens
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfileScreen(
    Userviewmodel: LoginRegisterViewModel = hiltViewModel(),
    navController: NavController,

) {

    Scaffold(
        bottomBar = { BottomBar(navController) },
        backgroundColor = Color.Black,
        topBar = { TopAppBar(
            backgroundColor = Color.Red,
            modifier = Modifier.height(80.dp)
        ) {
            Text(
                text = " Your profile",
                color= Color.White,
                textAlign = TextAlign.Center,
                fontSize = 30.sp
            )
        }},
        content = {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                Userviewmodel.currentUser?.displayName?.let { it1 ->
                    Text(
                        text = it1,
                        textAlign = TextAlign.Center,
                        color = Color.Yellow,
                        fontSize = 25.sp
                    )
                }
                Button(
                    onClick = {
                        Userviewmodel.LogOut()
                        navController.navigate("LogInScreen"){
                            popUpTo("LogInScreen") { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .width(150.dp)
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