package com.example.pantallaprincipalhibrida

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pantallaprincipalhibrida.clases.EmpleadoHonorarios
import com.example.pantallaprincipalhibrida.ui.theme.PantallaPrincipalHibridaTheme

class EmpleadoAHonorarioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PantallaInicio() {

    val contexto = LocalContext.current
    var sueldoBruto by remember { mutableStateOf(0.0) }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
        ){
            Button(onClick = {
                val intent = Intent (contexto, MainActivity::class.java)
                contexto.startActivity( intent )
            }) {
                Text(text = "<- Volver")
            }

        Spacer(modifier = Modifier.height(16.dp))
        
        Text(text= "Ingrese Sueldo Bruto: " , color = Color.White )
        BasicTextField(
            value = sueldoBruto.toString(),
            onValueChange = { newValue ->
                sueldoBruto=newValue.toDoubleOrNull() ?: 0.0
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            textStyle = TextStyle(color = Color.White)
        )
        Spacer(modifier = Modifier.height(16.dp))

        val empleadoAHonorario = EmpleadoHonorarios(sueldoBruto)
        Text(
            text = "Su sueldo Liquido Total es: ${empleadoAHonorario.calcularLiquido()}",
            color = Color.White
        )

        }
    }