package com.example.controedad

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        button.setOnClickListener { onClick() }
    }

    private fun onClick() {
        var textoResultado: String? = null;

        val campoTexto: EditText = findViewById(R.id.nombre)
        val textoNombre = campoTexto.text.toString()
        val campoTexto1: EditText = findViewById(R.id.direccion)
        val textoDireccion = campoTexto1.text.toString()
        val campoTexto2: EditText = findViewById(R.id.telefono)
        val textoTelefono = campoTexto2.text.toString()
        val campoTexto3: EditText = findViewById(R.id.email)
        val textoEmail = campoTexto3.text.toString()
        val campoTexto4: EditText = findViewById(R.id.documento)
        val textoDocumento = campoTexto4.text.toString()
        val campoTexto5: EditText = findViewById(R.id.edad)
        val textoEdad = campoTexto5.text.toString()

        //dicopnario
        val diccionario = mapOf(
            "nombre" to textoNombre,
            "direccion" to textoDireccion,
            "telefono" to textoTelefono,
            "email" to textoEmail,
            "documento" to textoDocumento,
            "edad" to textoEdad
        )

        if (textoNombre.isEmpty() || textoDireccion.isEmpty() || textoTelefono.isEmpty() || textoEmail.isEmpty() || textoDocumento.isEmpty() || textoEdad.isEmpty()) {
            textoResultado = "Debe completar todos los campos"
            val resultado: TextView = findViewById(R.id.resultado)
            resultado.text = textoResultado
        } else {
            validaEdadImprime(diccionario)
        }
    }

    private fun validaEdadImprime(diccionario: Map<String, String>) {

        val edad = diccionario["edad"]!!.toInt()
        var mensaje: String? = null
        if (edad >0 && edad < 15) {
            mensaje = "Usted es todavia un infante"
        } else if (edad >= 15 && edad < 18) {
            mensaje = "Usted es todavia un adolescente"
        } else if (edad >= 18 && edad < 25) {
            mensaje = "Usted es todavia un joven"
        } else if (edad >= 25 && edad < 65) {
            mensaje = "Usted es todavia un adulto"
        } else if (edad >= 65) {
            mensaje = "Usted es todavia un adulto mayor"
        }

        print(mensaje)

        val dicionario = mapOf(
            "nombre" to diccionario["nombre"],
            "direccion" to diccionario["direccion"],
            "telefono" to diccionario["telefono"],
            "email" to diccionario["email"],
            "documento" to diccionario["documento"],
            "edad" to diccionario["edad"],
            "mensaje" to mensaje
        )

        towView(dicionario)

    }

    private fun towView(diccionario: Map<String, String?>) {
        var nombre = diccionario["nombre"]
        var direccion = diccionario["direccion"]
        var telefono = diccionario["telefono"]
        var email = diccionario["email"]
        var documento = diccionario["documento"]
        var edad = diccionario["edad"]
        var mensaje = diccionario["mensaje"]

        val view = Intent(this, MainActivity2::class.java)
        var blunde = Bundle()
        blunde.putString("nombre", nombre)
        blunde.putString("direccion", direccion)
        blunde.putString("telefono", telefono)
        blunde.putString("email", email)
        blunde.putString("documento", documento)
        blunde.putString("edad", edad)
        blunde.putString("mensaje", mensaje)
        view.putExtras(blunde)

        startActivity(view)

    }
}