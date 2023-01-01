package com.example.projectnr2try.presentation.Recipes

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.FilterQuality
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
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
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.projectnr2try.presentation.Recipes.components.BottomBar
import com.example.projectnr2try.presentation.Recipes.components.TopBar

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun RecipeAddScreen(
    viewmodel: RecipesViewModel= hiltViewModel(),
    UserInfoviewmodel: LoginRegisterViewModel = hiltViewModel(),
    navController: NavController
) {
    var name by remember { mutableStateOf("") }
    var catagory by remember { mutableStateOf("") }
    var ingredients by remember { mutableStateOf("")}
    var steps by remember { mutableStateOf("") }
    var imageUri=remember {mutableStateOf<Uri?>(null)}
    val context =LocalContext.current
    val loginFlow = UserInfoviewmodel.currentUser?.uid
    val launcher= rememberLauncherForActivityResult(ActivityResultContracts.GetContent())
    {
        uri->imageUri.value=uri
    }
    val placeholderImage="https://www.shutterstock.com/image-vector/elegant-black-background-vector-illustration-vintage-1432953857"
    Scaffold(
        bottomBar = { BottomBar(navController) },
        backgroundColor = Color.Black,
        topBar = { TopBar(navController) }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.Black)
        )
        {
                LazyColumn(state = rememberLazyListState())
                {
                    item() {
                        Column(
                            modifier = Modifier
                                .height(200.dp)
                                .width(150.dp)
                                .padding(10.dp)
                                .border(3.dp, Color.White)
                        )
                        { Image(rememberAsyncImagePainter(model = ImageRequest.Builder(context)
                            .crossfade(false)
                            .data(imageUri.value?:placeholderImage)
                            .build(),
                        filterQuality = FilterQuality.High)
                            , contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .wrapContentWidth()
                                .size(200.dp)
                                .padding(4.dp)
                                .clip(RectangleShape)
                         )}
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(onClick = { launcher.launch("image/*") }) {
                            Text(text = "choose picture")
                            
                        }

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
                                    text = "Recipe name",
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
                                    text = "Recipe catagory",
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
                                    text = "Recipe ingredients",
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
                                    text = "Recipe steps",
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
                        Button(
                            onClick = {
                                viewmodel.AddRecipesUseCase (loginFlow.toString(),name,catagory,steps,ingredients)
                            },
                            modifier = Modifier
                                .width(200.dp)
                                .height(70.dp)
                                .border(3.dp, Color.Yellow, CircleShape),
                            shape = RoundedCornerShape(35.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red)
                        ) {
                            Text(
                                text = "PUBLISH",
                                textAlign = TextAlign.Center,
                                color = Color.Yellow
                            )
                        }

                        Spacer(modifier = Modifier.height(50.dp))

                    }

                }
            }
        }

    }
