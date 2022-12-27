package com.example.projectnr2try.presentation.Recipes.AppScreens

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
import androidx.compose.runtime.*
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
import com.example.projectnr2try.presentation.Recipes.LoginRegisterViewModel
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RegisterScreen(
    viewmodel: LoginRegisterViewModel = hiltViewModel(),
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }

    val registerFlow = viewmodel.registerFlow_.collectAsState()

    Scaffold(
        backgroundColor = Color.Black,
        content = {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                TextField(
                    modifier = Modifier
                        .width(300.dp)
                        .height(70.dp)
                        .background(Color.Red, CircleShape)
                        .border(3.dp, Color.Yellow, CircleShape),
                    value = username,
                    onValueChange = {
                        username = it
                    },
                    label = {
                        Text(
                            text = "USERNAME",
                            textAlign = TextAlign.Center,
                            color = Color.Yellow
                        )
                    },
                    textStyle = TextStyle(color = Color.White),
                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Done
                    )
                )

                TextField(
                    modifier = Modifier
                        .width(300.dp)
                        .height(70.dp)
                        .background(Color.Red, CircleShape)
                        .border(3.dp, Color.Yellow, CircleShape),
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    label = {
                        Text(text = "EMAIL",
                            textAlign = TextAlign.Center,
                            color = Color.Yellow)

                    },
                    textStyle = TextStyle(color = Color.White),

                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )
                TextField(
                    modifier = Modifier
                        .width(300.dp)
                        .height(70.dp)
                        .background(Color.Red, CircleShape)
                        .border(3.dp, Color.Yellow, CircleShape),
                    value = password,
                    onValueChange = {
                        password = it
                    },
                    label = {
                        Text(text = "PASSWORD",
                            textAlign = TextAlign.Center,
                            color = Color.Yellow)

                    },
                    textStyle = TextStyle(color = Color.White),

                    keyboardOptions = KeyboardOptions(
                        capitalization = KeyboardCapitalization.None,
                        autoCorrect = false,
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    )
                )
                Button(
                    onClick = {
                        viewmodel.Register(email,password,username)
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .height(70.dp)
                        .border(3.dp, Color.Yellow, CircleShape),
                    shape= RoundedCornerShape(35.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue)
                ) {
                    Text(text = "REGISTER",
                        textAlign = TextAlign.Center,
                        color = Color.Yellow)
                }
                Text(modifier = Modifier.clickable { navController.navigate("LogInScreen") },
                    text = "Have an account? Log in!",
                    textAlign = TextAlign.Center,
                    color = Color.Yellow)
                registerFlow.value.let {
                    when(it)
                    {
                        is Resource.Failure->{
                            Toast.makeText(LocalContext.current, it.expectation.message, Toast.LENGTH_SHORT).show()
                        }
                        Resource.Loading-> {
                            CircularProgressIndicator()
                        }
                        is Resource.Success->
                        {
                            LaunchedEffect(Unit) {
                                navController.navigate("MainScreen") {
                                    popUpTo("MainScreen") { inclusive = true }
                                }
                            }
                        }
                    }
                }
            }
        }
    )
}