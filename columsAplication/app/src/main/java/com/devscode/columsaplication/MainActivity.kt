@file:OptIn(ExperimentalMaterial3Api::class)

package com.devscode.columsaplication

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Bottom
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devscode.columsaplication.ui.theme.ColumsAplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewContainer()
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnusedMaterial3ScaffoldPaddingParameter")
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar()},
        content =  { Content()},
        floatingActionButton = { FAB()},
        floatingActionButtonPosition = FabPosition.End
    )
}


@Composable
fun FAB(){
    val context = LocalContext.current
    FloatingActionButton(
        onClick = {Toast.makeText(context, "Subir nueva foto", Toast.LENGTH_SHORT).show()
        }){
            Text(text = "+")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Toolbar() {
    TopAppBar(
        title = {
            Text(
                text = "Instagram for artist",
                color = Color.White
                ) },
        colors = TopAppBarDefaults.smallTopAppBarColors(colorResource(id = R.color.principal))
    
    )
}

@Composable

fun Content(){

    var counter by rememberSaveable { mutableStateOf( 0) }

    LazyColumn(
        modifier = Modifier
            .background(Color.White)
            .padding(top = 80.dp)
    ) {

        item {


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 5.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.nn),
                    contentDescription = "",
                    modifier = Modifier
                        .height(60.dp)
                        .padding(horizontal = 5.dp)

                )
                Column {
                    Text(
                        text = "Zeus_Cach",
                        fontSize = 17.sp,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )

                    Text(
                        text = "hace 4 minutos",
                        fontSize = 15.sp,
                        modifier = Modifier.padding(horizontal = 4.dp)
                    )

                }

            }

            Image(
                painter = painterResource(id = R.drawable.nn),
                contentDescription = "publication",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(20.dp)
            )
            Row (Modifier.padding(8.dp)){
                Image(
                    painter = painterResource(id = R.drawable.ic_favorite),
                    contentDescription = "like",
                    modifier = Modifier.clickable { counter++ }
                )
                Text(
                    text = counter.toString(),
                    modifier = Modifier.padding(start = 4.dp)
                )

                Image(painter = painterResource(
                    id = R.drawable.baseline_mode_comment_24), contentDescription = "",
                    modifier = Modifier.padding(horizontal = 5.dp)
                )

                Text(
                    text = counter.toString(),
                    modifier = Modifier.padding(start = 4.dp)
                )

                Image(painter = painterResource(
                    id = R.drawable.baseline_ios_share_24), contentDescription = "",
                    modifier = Modifier.padding(horizontal = 5.dp)
                )

                Text(
                    text = counter.toString(),
                    modifier = Modifier.padding(start = 4.dp)
                )
                

            }
            Text(
                text = "Mundo de cabeza",
                fontSize = 25.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            )
            Text(
                text = "Pintura abstracta sobre lienzo 1988",
                fontSize = 20.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)

            )




        }

    }
}