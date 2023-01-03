package com.example.projectnr2try.presentation.Recipes

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectnr2try.presentation.Recipes.AppScreens.Screens
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.Recipes

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
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ){
                    Recipes(recipeContent = {recipes ->
                        LazyColumn(modifier= Modifier
                           // .fillMaxSize()
                            .padding(10.dp)
                            .border(5.dp, color = Color.Black)
                        )

                        {
                            items(items=recipes)
                            {
                                    recipe->
                                if(Userviewmodel.currentUser?.uid ==recipe.userId) {
                                    Card(
                                        shape = MaterialTheme.shapes.small,
                                        modifier = Modifier
                                            .padding(
                                                bottom = 8.dp
                                            )
                                            .border(3.dp, color = Color.Yellow)
                                            .fillMaxWidth(),
                                        elevation = 3.dp,
                                    ) {
                                        Row(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(3.dp)
                                                .background(Color.Black),
                                            verticalAlignment = Alignment.CenterVertically,
                                        ) {
                                            Column(modifier = Modifier
                                                .padding(20.dp)
                                            ) {
                                                Text(
                                                    text = recipe.name ?: "",
                                                    color = Color.White,
                                                    fontSize = 20.sp
                                                )
                                                IconButton(onClick = {navController.navigate(Screens.EditScreen.route + "/${recipe.id}")  }) {
                                                    Icon(imageVector = Icons.Filled.Edit,
                                                        contentDescription = "Edit",
                                                        modifier=Modifier.size(30.dp),
                                                        tint =Color.Yellow
                                                        )
                                                }
                                            }
                                            Spacer(
                                                modifier = Modifier.weight(1f)
                                            )

                                        }
                                    }
                                }
                            }
                        }
                    }
                    )
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
        }
    )


}