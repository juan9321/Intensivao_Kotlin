package com.example.interface_grafica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.interface_grafica.ui.theme.Interface_GraficaTheme
import com.example.interface_grafica.ui.theme.Interface_GraficaTheme
import com.example.interface_grafica.ui.theme.Purple200

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

val colorStops = arrayOf(
    0.0f to Color.Yellow,
    0.2f to Color.Red,
    1f to Color.Blue
)

@Composable
fun MainScreen(){
    Interface_GraficaTheme() {
        Column(
            Modifier
                .fillMaxSize()
                .background(Color(255, 255, 240))) {
            Greeting("Android")
            MinhaSaudacao(name = "Oi,",
                adjetivo = "Bom dia",
                modifier = Modifier
                    .border(
                        border = BorderStroke(
                            width = 2.dp,
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color.Red, Color.Blue)
                            )
                        ),
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(16.dp))

        }

    }
}



@Composable
fun MinhaSaudacao(name: String, adjetivo: String, modifier: Modifier){
    Text(text = "Hello World $name $adjetivo", modifier)
}


@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!",
        modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}