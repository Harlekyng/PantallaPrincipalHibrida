package com.example.pantallaprincipalhibrida

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.pantallaprincipalhibrida.clases.EmpleadoRegular

class ERegularPorContrato : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_eregular_por_contrato)

        val btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener{
            val intent = Intent (this, MainActivity::class.java)
            startActivity( intent )
        }

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val editSueldoBruto = findViewById<EditText>(R.id.editSueldoBruto)
        val textResultado = findViewById<TextView>(R.id.textResultado)

        btnCalcular.setOnClickListener {
            val sueldoBruto = editSueldoBruto.text.toString().toDoubleOrNull() ?: 0.0
            val empleadoRegular = EmpleadoRegular(sueldoBruto)
            val sueldoLiquido = empleadoRegular.calcularLiquido()
            textResultado.text = "$sueldoLiquido"
        }

    }
}