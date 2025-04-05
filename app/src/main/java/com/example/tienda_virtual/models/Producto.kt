package com.example.tienda_virtual.models

data class Producto(
    val nombre: String,
    val precio: Double,
    var cantidad: Int = 1
)
