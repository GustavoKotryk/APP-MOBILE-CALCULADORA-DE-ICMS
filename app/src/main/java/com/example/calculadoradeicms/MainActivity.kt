package com.example.calculadoradeicms

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val edtEstado = findViewById<EditText>(R.id.edtEstado)
        val edtValor = findViewById<EditText>(R.id.edtValor)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)

        btnCalcular.setOnClickListener {

            val estado = edtEstado.text.toString().uppercase()
            val valorTexto = edtValor.text.toString()

            if (estado.isEmpty() || valorTexto.isEmpty()) {

                txtResultado.text = getString(R.string.msg_fill_all_fields)

                return@setOnClickListener
            }

            val valor = valorTexto.toDouble()

            val percentualICMS = when (estado) {

                "SC", "ES", "MS", "RS" -> 0.17

                "GO" -> 0.175

                "SP", "PR" -> 0.18

                else -> {

                    txtResultado.text = getString(R.string.msg_invalid_state)

                    return@setOnClickListener
                }
            }


            val valorTotal = valor + (valor * percentualICMS)


            txtResultado.text = getString(R.string.result_format, estado, percentualICMS * 100, valorTotal)
        }
    }
}