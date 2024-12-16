package com.example.mouad

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.mouad.ui.theme.MouadTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MouadTheme {
                Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    lenght(10)
                }

            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun lenght(maxChar : Int){
    var text by remember { mutableStateOf("") }
    var Error by remember{ mutableStateOf(false)}
    val context = LocalContext.current
    OutlinedTextField(value = text,
        onValueChange = {
                        if(it.length <= maxChar){
                            text = it
                            Error = false
                        }else {
                            Error = true
                        }
        },
        label = { Text(text = "Type your name")},
        placeholder = { Text(text = "Type your name")},
        maxLines = 1,
        isError = Error)
    if (Error){
        Toast.makeText(context, "you reached the limit of characters", Toast.LENGTH_SHORT).show()
    }
}
