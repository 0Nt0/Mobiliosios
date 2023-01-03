package com.example.projectnr2try.presentation.Recipes.AppScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.projectnr2try.R
import com.example.projectnr2try.presentation.Recipes.LoginRegisterViewModel
import com.example.projectnr2try.presentation.Recipes.RecipesViewModel
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.Recipes
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun EditScreen(
    userViewModel:LoginRegisterViewModel= hiltViewModel(),
    viewmodel: RecipesViewModel = hiltViewModel(),
    ItemId: String?,
    navController: NavController
) {
//    var name by remember { mutableStateOf("") }
//    var catagory by remember { mutableStateOf("") }
//    var ingredients by remember { mutableStateOf("") }
    var LoginFlow= userViewModel.currentUser?.uid.toString()
    Scaffold(
        bottomBar = { BottomBar(navController) },
        backgroundColor = Color.Black,
        topBar = { TopBar(navController) },
        content = {
                padding->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ){
                Text(//text = "Recipe edit",
                    text = stringResource(id= R.string.Recipe_Edit),
                    color = Color.Yellow,
                    fontSize = 25.sp)
                    Recipes(recipeContent = {recipes ->
                        LazyColumn(
//                            modifier= Modifier
//                            .fillMaxSize()
//                            .padding(padding)
//                            .border(5.dp, color = Color.Black)
                        )

                        {
                            items(items=recipes)
                            { recipe ->
                                if (recipe.id == ItemId) {
                                    var name by remember { mutableStateOf(recipe.name.toString()) }
                                    var catagory by remember { mutableStateOf(recipe.catagory.toString()) }
                                    var ingredients by remember { mutableStateOf(recipe.ingredients.toString()) }
                                    var steps by remember { mutableStateOf(recipe.steps.toString()) }

                                    Spacer(modifier = Modifier.height(10.dp))
                                    TextField(
                                        modifier = Modifier
                                            .width(300.dp)
                                            .height(90.dp)
                                            .background(Color.Black, RoundedCornerShape(20.dp))
                                            .border(3.dp, Color.White, RoundedCornerShape(20.dp)),
                                        value = name,
                                        onValueChange = {
                                            name = it
                                        },
                                        label = {
                                            Text(
                                                text= stringResource(id = R.string.Recipe_name),
                                                color = Color.Yellow,
                                                fontSize = 20.sp
                                            )
                                        },
                                        textStyle = TextStyle(color = Color.White),
                                        keyboardOptions = KeyboardOptions(
                                            capitalization = KeyboardCapitalization.None,
                                            autoCorrect = false,
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Done
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    TextField(
                                        modifier = Modifier
                                            .width(300.dp)
                                            .height(90.dp)
                                            .background(Color.Black, RoundedCornerShape(20.dp))
                                            .border(3.dp, Color.White, RoundedCornerShape(20.dp)),
                                        value = catagory,
                                        onValueChange = {
                                            catagory = it
                                        },
                                        label = {
                                            Text(
                                                text= stringResource(id = R.string.Recipe_catagory),
                                                color = Color.Yellow,
                                                fontSize = 20.sp
                                            )
                                        },
                                        textStyle = TextStyle(color = Color.White),
                                        keyboardOptions = KeyboardOptions(
                                            capitalization = KeyboardCapitalization.None,
                                            autoCorrect = false,
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Done
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    TextField(
                                        modifier = Modifier
                                            .width(300.dp)
                                            .height(200.dp)
                                            .background(Color.Black, RoundedCornerShape(20.dp))
                                            .border(3.dp, Color.White, RoundedCornerShape(20.dp)),
                                        value = ingredients,
                                        onValueChange = {
                                            ingredients = it
                                        },
                                        label = {
                                            Text(
                                                text= stringResource(id = R.string.Recipe_ingredients),
                                                color = Color.Yellow,
                                                fontSize = 20.sp
                                            )
                                        },
                                        textStyle = TextStyle(color = Color.White),
                                        keyboardOptions = KeyboardOptions(
                                            capitalization = KeyboardCapitalization.None,
                                            autoCorrect = false,
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Done
                                        )
                                    )
                                    Spacer(modifier = Modifier.height(10.dp))
                                    TextField(
                                        modifier = Modifier
                                            .width(300.dp)
                                            .height(400.dp)
                                            .background(Color.Black, RoundedCornerShape(20.dp))
                                            .border(3.dp, Color.White, RoundedCornerShape(20.dp)),
                                        value = steps,
                                        onValueChange = {
                                            steps = it
                                        },
                                        label = {
                                            Text(
                                                text= stringResource(id = R.string.Recipe_steps),
                                                color = Color.Yellow,
                                                fontSize = 20.sp
                                            )
                                        },
                                        textStyle = TextStyle(color = Color.White),
                                        keyboardOptions = KeyboardOptions(
                                            capitalization = KeyboardCapitalization.None,
                                            autoCorrect = false,
                                            keyboardType = KeyboardType.Text,
                                            imeAction = ImeAction.Done
                                        ),

                                    )
                                    Spacer(modifier = Modifier.height(50.dp))
                                    Button(
                                        onClick = {
                                                viewmodel.EditRecipesUseCase( recipe.id.toString(),LoginFlow,name,catagory,steps,ingredients)
                                        },
                                        modifier = Modifier
                                            .width(200.dp)
                                            .height(70.dp)
                                            .border(3.dp, Color.Yellow, CircleShape),
                                        shape = RoundedCornerShape(35.dp),
                                        colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                                    ) {
                                        Text(
                                            text= stringResource(id = R.string.Change),
                                            textAlign = TextAlign.Center,
                                            color = Color.Yellow
                                        )
                                    }
                                    Spacer(modifier = Modifier.height(50.dp))

                                }
                            }
                        }
                    }
                    )

            }

        }
    )

}