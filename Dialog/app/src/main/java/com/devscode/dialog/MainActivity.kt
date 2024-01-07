package com.devscode.dialog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devscode.dialog.ui.theme.DialogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            app()
        }
    }
}

@Preview
@Composable
fun app(){
    DialogTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {

            var show by rememberSaveable {mutableStateOf(false)}

            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Button(onClick = { show = true }) {
                    Text(text = "Dialogo")

                }
            }
            MyDialog(show, {show = false},{ Log.i("zeus", "Click")})

        }
    }
}

@Composable
fun MyDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
){
    if(show){
        AlertDialog(
            onDismissRequest = { onDismiss()},
            confirmButton = { TextButton(onClick = { onConfirm() }) {
                Text(text = "ConfirmButton")
            }},
            dismissButton = { TextButton(onClick = { onDismiss()}) {
                Text(text = "DismissButton")
            }},
            title = { Text(text = "Estas seguro que quieres salir?")},
            text = { Text(text = "Hola mundo")}
        )
    }

}

