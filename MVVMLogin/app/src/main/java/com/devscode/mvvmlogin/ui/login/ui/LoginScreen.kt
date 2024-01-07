package com.devscode.mvvmlogin.ui.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devscode.mvvmlogin.R
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(16.dp)


    ) {
        Login(modifier = Modifier.align(Alignment.Center), viewModel)
    }
}



@Composable
fun Login(modifier: Modifier, viewModel: LoginViewModel) {

    val email :String by viewModel.email.observeAsState(initial = "")
    val password :String by viewModel.password.observeAsState(initial = "")
    val loginEnable :Boolean by viewModel.loginEnable.observeAsState(initial = false)
    val isloading :Boolean by viewModel.isloading.observeAsState(initial = false)
    val coroutineScope = rememberCoroutineScope()

    if(isloading){
        Box(modifier = Modifier.fillMaxSize()){
            CircularProgressIndicator(Modifier.align(Alignment.Center))
        }
    } else {
        Column(modifier = modifier) {
            HeaderImage(Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.padding(16.dp))
            EmailField(email, {viewModel.onLoginChanged(it, password)})
            Spacer(modifier = Modifier.padding(4.dp))
            PasswordField(password, {viewModel.onLoginChanged(email, it)})
            Spacer(modifier = Modifier.padding(8.dp))
            ForgotPassword(Modifier.align(Alignment.End))
            Spacer(modifier = Modifier.padding(16.dp))
            LoginButton(loginEnable){
                coroutineScope.launch { viewModel.onLoginSelected() }
            }
        }
    }
    

}

@Composable
fun LoginButton(loginEnable: Boolean, onloginSelected: () -> Unit) {
    Button(
        onClick = {onloginSelected()},
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF5BF591),
            disabledContainerColor = Color( 0xFF67D38D),
            contentColor = Color.Black,
            disabledContentColor = Color.Black

        ), enabled = loginEnable
    ) {
        Text(text = "Iniciar sesion")
    }
}

@Composable
fun ForgotPassword(modifier: Modifier) {
    Text(
        text = "Olvidaste la contraseña?",
        modifier = modifier.clickable { },
        fontSize = 12.sp,
        fontWeight = FontWeight.Bold,
        color = Color(0xFF5BF591)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(password: String, onTexFieldChanged:(String) -> Unit) {

    TextField(
        value = password,
        onValueChange = {onTexFieldChanged(it)},
        placeholder = { Text(text = "Password") },
        modifier = Modifier.fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF464646),
            containerColor = Color(0xFFFFFFFF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent

        )

    )

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailField(email: String, onTexFieldChanged:(String) -> Unit) {

    TextField(
        value = email,
        onValueChange = {onTexFieldChanged(it)},
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color(0xFF464646),
            containerColor = Color(0xFFFFFFFF),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),

        )
}

@Composable
fun HeaderImage(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.kanlogo),
        contentDescription = "Logo",
        modifier = modifier
    )
}
