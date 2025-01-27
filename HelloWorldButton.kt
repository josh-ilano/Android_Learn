package com.example.helloworld

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.helloworld.ui.theme.HelloWorldTheme
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            HelloWorldTheme {
                var displayText by remember { mutableStateOf("") }
                // variable that changes on user pressing a button

                Scaffold(modifier = Modifier.fillMaxSize())
                { innerPadding ->
                    /**
                     * A Column is implemented here in order to vertically stack
                     * the UI. On top would be the text, and below would be the button
                     */

                    Column(modifier = Modifier.padding(innerPadding),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally) {

                        Text(displayText)
                        FilledButtonExample(onClick = {displayText = "Hello World"},
                            modifier = Modifier.padding(innerPadding))

                    }

                }

            }
        }
    }
}


//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

@Composable
fun FilledButtonExample(onClick: () -> Unit, modifier: Modifier = Modifier) {
    Button(onClick = {onClick()}, modifier = modifier) {
        Text(text = "Press me!")
    }
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    HelloWorldTheme {
//        Greeting("Josh")
//    }
//}