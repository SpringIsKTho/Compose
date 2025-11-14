package com.example.compose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

class CalcActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            app()
        }
    }

    @Preview(showBackground = true)
    @Composable

    fun app() {
        val PI = 3.14
        var ultimotexto by remember { mutableStateOf("") }
        var name1 by remember { mutableStateOf("") }

        LazyColumn(Modifier.fillMaxSize()) {
            item {
                Image(
                    painter = painterResource(R.drawable.esfera),
                    contentDescription = "logo",
                    modifier = Modifier.fillMaxWidth()
                )

                val n1 = OutlinedTextField(
                    value = name1,
                    onValueChange = { name1 = it },
                    label = { Text("Radio Esfera") },
                    singleLine = true
                )

                Text(ultimotexto, Modifier.padding(12.dp).fillMaxSize())

                val context = LocalContext.current
                Button(
                    onClick = {
                        if (name1 == ""){
                            name1 = "0"
                        }
                        ultimotexto = (name1.toDouble()*name1.toDouble()*4*PI).toString() + " m2"
                    }
                ) {
                    Text("Calcular Area")
                }

                Button(
                    onClick = {
                        if (name1 == ""){
                            name1 = "0"
                        }
                        ultimotexto = (2*PI*name1.toDouble()).toString() + " m"
                    }
                ) {
                    Text("Calcular Perimetro")
                }

                Button(
                    onClick = {
                        if (name1 == ""){
                            name1 = "0"
                        }
                        ultimotexto = ((4/3)*PI*name1.toDouble()*name1.toDouble()*name1.toDouble()).toString() + " m3"
                    }
                ) {
                    Text("Calcular Volumen")
                }
            }

        }
    }
}