package com.example.tiendadonemiliop67.view.adapter

import com.example.tiendadonemiliop67.model.Products

interface ProductsListener {
    fun OnProductsClick(product:Products, position: Int)
}