package com.example.myapplication.core.ui
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.core.ui.theme.MyApplicationTheme




@Composable
fun LoginScreen(
    onClickAction: () -> Unit
){
var username by remember { mutableStateOf("") }
var password by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .background(Color(color = 0xFF9FD4F1))
            .fillMaxSize()
            .fillMaxWidth(),
        contentAlignment = Alignment.Center,

    ) {
        Image(
            painter = painterResource(id = R.drawable.rectangle1),
            contentDescription = "Asset",
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(),
            alignment = Alignment.BottomCenter
        )
        Row(
            modifier = Modifier
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Image(
                painter = painterResource(id = R.drawable.set1),
                contentDescription = "Asset",
                modifier = Modifier
                    .fillMaxSize()
                    .width(150.dp),
                alignment = Alignment.TopCenter,
            )
        }
        Column(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Image(
                painter = painterResource(id = R.drawable.image1),
                contentDescription = "Asset",
                modifier = Modifier
                    .size(200.dp)
            )

            Text(
                text = "Welcome Back!",
                modifier = Modifier,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.headlineLarge


            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.weight(1f)
            ) {

                Spacer(modifier = Modifier.height(120.dp)
                )
                TextField(
                    value = username,
                    onValueChange = { username = it },
                    textStyle = TextStyle(textDecoration = TextDecoration.Underline),
                    label = { Text("Username") },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.mail),
                            contentDescription = "user",
                            modifier = Modifier.size(24.dp)
                        )


                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Gray,
                        unfocusedIndicatorColor = Color(color = 0xFF00A5FF)
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .width(250.dp)
                        .size(30.dp),
                )
                Spacer(modifier = Modifier.height(24.dp))

                TextField(
                    value = password,
                    onValueChange = { password = it },
                    textStyle = TextStyle(textDecoration = TextDecoration.Underline),
                    label = { Text("password") },
                    leadingIcon = {
                        Image(
                            painter = painterResource(id = R.drawable.lock),
                            contentDescription = "Icon",
                            modifier = Modifier.size(24.dp)
                        )

                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Gray,
                        unfocusedIndicatorColor = Color(color = 0xFF00A5FF)
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .width(250.dp)
                        .size(30.dp),
                )
                Spacer(modifier = Modifier.height(30.dp))

                Button(
                    onClick = {},
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(color = 0xFF00A5FF),
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    )
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sign_in),
                        contentDescription = "Button Icon",
                        modifier = Modifier
                            .size(70.dp)
                            .height(50.dp),
                        )
                }
                    Spacer(modifier = Modifier.height(15.dp))
                Row(modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Don't have account?",
                        modifier = Modifier,
                        color = Color(color = 0xFF727272)
                    )
                    Spacer(modifier = Modifier.width(1.dp))
                    Text(
                        text = "Sign Up",
                        modifier = Modifier
                            .clickable(onClick = onClickAction),
                        color = Color(0xFF00A5FF)
                    )
                }
                Row {
                    Button(
                        onClick = {},
                        modifier = Modifier,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(color = 0xFFD9D9D9),
                            contentColor = MaterialTheme.colorScheme.primary)
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.ig),
                            contentDescription = "Button Icon",
                            modifier = Modifier
                                .clickable(onClick = onClickAction)
                                .size(20.dp),
                        )

                    }
                    Spacer(modifier = Modifier.width(10.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(color = 0xFFD9D9D9),
                            contentColor = MaterialTheme.colorScheme.primary
                        )
                    )
                    {
                        Image(
                            painter = painterResource(id = R.drawable.fb),
                            contentDescription = "Button Icon",
                            modifier = Modifier
                                .clickable(onClick = onClickAction)
                                .size(20.dp),
                            )
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview (){
    MyApplicationTheme {
        LoginScreen(
            onClickAction = { /* TODO */ }
        )
    }
}