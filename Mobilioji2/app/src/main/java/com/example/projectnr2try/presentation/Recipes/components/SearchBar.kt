package com.example.projectnr2try.presentation.Recipes.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun SearchAppBar() {
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
                .background(Color.Transparent,CircleShape),
            value = "",
            onValueChange = {

            },
            textStyle=TextStyle(color=Color.White),
            leadingIcon = {
                IconButton(
                    onClick = {}
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
