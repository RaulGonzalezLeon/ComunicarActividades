package com.example.comunicaractividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.comunicaractividades.databinding.ActivityMainBinding
import com.example.comunicaractividades.databinding.ActivityPantalla2Binding

class Pantalla2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_pantalla2)
        val binding = ActivityPantalla2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        /* Recogemos la informacion en una variable extras */
        val extras = intent.extras

        /* Almacenamos en la variable s el dato recibido */
        val s = extras?.getString("dato")?:"sin nombre"

        /* Mostramos en el textView la informacion */
        binding.bienvenida.text= "Bienvenido " + s + " ¿Acepta los terminos?"

        /* En caso de que pulsemos el boton aceptar, enviamos los datos
        * a la MainActivity */
        binding.botonAceptar.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("dato", "Ha aceptado los terminos")
            startActivity(intent)
        }

        binding.botonRechazar.setOnClickListener{
            var intent = Intent(this, MainActivity::class.java)
            intent.putExtra("dato", "Ha rechazado los terminos")
            startActivity(intent)
        }
    }
}