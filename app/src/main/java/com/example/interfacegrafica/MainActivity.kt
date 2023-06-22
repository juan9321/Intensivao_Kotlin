package com.example.interfacegrafica

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModelProvider


class MainActivity : ComponentActivity() {

    private lateinit var myViewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        myViewModel = ViewModelProvider(this)[ViewModel::class.java]

        setContent {
            MainScreen(myViewModel)
        }
    }
}

@Composable
fun MainScreen(exmpViewModel: ViewModel){

    var contadorView by remember {
        mutableStateOf(0)
    }

    val contadorProvModelView by exmpViewModel.contadorView.collectAsState()

    Column {
        Button(onClick = {
            contadorView += 1 //isso é considerado algo amador
            exmpViewModel.incrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(52, 97, 0, 255)
            )
        ){
            Text(text = "AUMENTAR CONTADOR")
        }

        Button(onClick = {
            contadorView -= 1 //isso é considerado algo amador
            exmpViewModel.decrementContador()
        }, modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(75, 0, 0, 180)
            )
        ){
            Text(text = "DIMINUIR CONTADOR")
        }
        Text(text = "Valor do Contador  = $contadorView")

        Text(text = "Valor do Contador  = $contadorProvModelView")


   




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

}
