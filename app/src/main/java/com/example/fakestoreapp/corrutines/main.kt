package com.example.fakestoreapp.corrutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    print("Corrutinas")

    //Hacer consultas a una base de datos
    print("Cargar interfaz grafica")
    //launch
    //Scope
    //Solo usamos el globalScope para practicar

    //runBlocking

fun cLaunch(){
    runBlocking {
        launch {
            println("Consuta a base de datos ")
            delay(3000)
            println("Termina Consuta a base de datos ")

            }
            println("Continua cargando interfaz grafica")
            println("Interfaz cargada")
        }

    }
}

fun cAsync(){
    // solo para pruebas
    runBlocking {
        println("Cargando interfaz grafica")
        val result = async {
            println("haciendo GET de API de FAKESTORE")
            delay(2000)

        }
        val resultString = result
        println("El resultado es $resultString")
    }
}

suspend fun consultaDB(){
    println("Consulta a base de datos")
    delay(3000)
    println("Terminar consulta de base de datos")
}