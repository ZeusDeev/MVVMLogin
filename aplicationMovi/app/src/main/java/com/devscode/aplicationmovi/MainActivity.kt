package com.devscode.aplicationmovi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.devscode.aplicationmovi.ui.theme.AplicationMoviTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicationMoviTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun helloApp(){

}*/

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting() {
    Column {
        TopAppBar(
            title = { Text(text = "Mi primer app")},
            navigationIcon = {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier.padding(4.dp)

                ) {


                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AplicationMoviTheme {
        Greeting()
    }
}