package com.darwin.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.darwin.lab2.ui.theme.Lab2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           MaterialTheme {
               MainApp()
           }
        }
    }
}

@Composable
fun MainApp() {
    var nombre by remember { mutableStateOf("") }
    var lista by remember { mutableStateOf(listOf<String>()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(19.dp)
            .fillMaxSize()
            .background(Color.White)
            .padding(19.dp)
    ) {


        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )



        Button(
            onClick = {
                if (nombre.isNotEmpty()) {
                    lista = lista + nombre
                    nombre = ""
                }
            },
            modifier = Modifier
                .padding(top = 8.dp)
                .align(Alignment.CenterHorizontally),
            shape = RoundedCornerShape
                (50)
        ) {
            Text("Guardar")
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(text = "Listado de nombres")

            Button(
                onClick = {
                    lista = emptyList()
                }
            ) {
                Text("Limpiar")
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(top = 16.dp)
                .border(2.dp, Color.Gray)
        ) {

            LazyColumn(
                modifier = Modifier.padding(8.dp)
            ) {
                itemsIndexed(lista) { index, item ->

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(4.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = item)
                        Text(text = "${index + 1}")
                    }

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    Lab2Theme {
        MainApp()
    }
}










