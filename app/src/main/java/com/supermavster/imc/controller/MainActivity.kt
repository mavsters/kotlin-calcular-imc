package com.supermavster.imc.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.supermavster.imc.R
import com.supermavster.imc.model.Person

class MainActivity : AppCompatActivity() {

    // Variables - Globales
    lateinit var txtHeight : EditText
    lateinit var txtWidth : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Init Process
        initProcess()
    }

    private fun initProcess(){
        // Init Variables
        setVariables()
        // Init Actions on the Activity
        setActionsBtn()
    }

    private fun setVariables(){
        // A la variable txtHeight le digo: Busque me un Edit Text que tenga el id txt_height de mi Activity local
        txtHeight = findViewById<EditText>(R.id.txt_height)
        // A la variable txtWidth le digo: Busque me un Edit Text que tenga el id txt_width de mi Activity local
        txtWidth = findViewById<EditText>(R.id.txt_width)
    }


    private fun setActionsBtn(){
        // Al aplicativo le digo: Busqueme un Botón con el identificador btn_submit y Cuando alguien lo presione haga lo que tenga por dentro de el
        findViewById<Button>(R.id.btn_submit).setOnClickListener {
            makeCalc()
        }
    }

    private fun makeCalc(){
        // Get Data from EditTexts
        var width : Double = txtWidth.text.toString().toDouble()
        var height : Double = txtHeight.text.toString().toDouble()

        // Make Object - (New Object)
        var person = Person()

        // Set Values to object Person
        person.heightPerson = height
        person.widthPerson = width

        // Make Calc
        person.makeProcess()

        // Show Process - Definiendo lo en el EditText que tiene por id TXT_RESULT
        findViewById<EditText>(R.id.txt_result).setText(person.toString())
    }
}
