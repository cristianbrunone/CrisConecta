package com.example.ejemplos.model

sealed  class Routes(val route: String) {
    object Pantalla: Routes("screen")
    object Pantalla2: Routes("screen2")
    object Pantalla3: Routes("screen3")
    object Pantalla4: Routes("screen4/{age}"){
        fun createRoute(age: Int) = "screen4/$age"
    }
    object Pantalla5: Routes("screen5?name={name}"){
        fun createRoute(name: String) = "screen5?name={name}"
    }
}