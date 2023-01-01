package com.example.projectnr2try.presentation.Recipes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.projectnr2try.presentation.Recipes.AppScreens.Screens

@Composable
fun SearchAppBar(navController: NavController) {
    var search by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .width(230.dp)
            .height(56.dp)
            .background(Color.Red, CircleShape)
            .border(3.dp,Color.Yellow, CircleShape),
            color= Color.Red
    ) {
        TextField(
            modifier = Modifier
                .width(100.dp)
                .height(56.dp)
                .background(Color.Transparent,CircleShape)
                .border(3.dp,Color.Transparent, CircleShape),
            value = search,
            onValueChange = {
                search = it
            },

            textStyle=TextStyle(color=Color.White),
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.None,
                autoCorrect = false,
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Done
            ),
            leadingIcon = {
                IconButton(
                    onClick = { navController.navigate(Screens.RecipeCatagoryScreen.route+"/${search}")}
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search Icon",
                        modifier=Modifier.size(30.dp),
                        tint =(Color.Yellow)
                    )
                }
            },
        )
    }
}
