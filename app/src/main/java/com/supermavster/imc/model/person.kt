package com.supermavster.imc.model

import java.text.DecimalFormat

class Person {

    /** Inicialización y Definición de Variables */

    // Name Person
    var imcPerson: Double = 0.0
    var status: String = ""


    // Width
    var widthPerson: Double = 0.0
    var heightPerson: Double = 0.0

    // Set Static Status
    val list = mutableListOf("Peso inferior al normal", "Normal", "Peso superior al normal", "Obesidad","ERROR")
    /* Composición corporal	Índice de masa corporal (IMC)
        Peso inferior al normal	Menos de 18.5
        Normal	18.5 – 24.9
        Peso superior al normal	25.0 – 29.9
        Obesidad	Más de 30.0
    */

    /** Proceso de Calculo y Resultados **/
    fun makeProcess() {
        imcPerson = widthPerson / (heightPerson * heightPerson)

        // Definición / Filtro de rango
        var count = when(true){
            (imcPerson <= 18.4)-> 0
            (imcPerson in 18.5..25.4)->1
            (imcPerson in 25.5..29.9)->2
            (imcPerson >= 30)->3
            else -> list.size
        }

        // Cantidad de decimales en un número
        val formatNumber = DecimalFormat("#.00")
        // Conversión de decimales y conversión a número Double
        imcPerson = formatNumber.format(imcPerson).toDouble()

        // Asignación de Resultados (Estado)
        status = list[count]

    }

    override fun toString(): String {
        return "Su peso corporal es: $imcPerson\nY es: $status"
    }


}