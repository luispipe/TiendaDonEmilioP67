package com.example.tiendadonemiliop67.network

import com.example.tiendadonemiliop67.model.Products
import com.google.firebase.firestore.FirebaseFirestore
//Se le volvio a dar en cargar dependencias, en caso de que no sirva deben seguir las siguentes instrucciones
//para deshabilitar el trabajo offline https://stackoverflow.com/questions/28712025/how-to-disable-gradle-offline-mode-in-android-studio


const val PRODUCT_COLLECTION_NAME="products"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()

    fun getProducts(callback: Callback<List<Products>>){
        firebaseFirestore.collection(PRODUCT_COLLECTION_NAME)
            .get()
                //Error estaba en el result --> es con un solo ->
            .addOnSuccessListener { result ->
                    for (doc in result){
                        val list = result.toObjects(Products::class.java)
                        callback.onSuccess(list)
                        break
                    }

            }

    }

}