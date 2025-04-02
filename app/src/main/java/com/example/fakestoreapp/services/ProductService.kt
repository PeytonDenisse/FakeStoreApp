package com.example.fakestoreapp.services

import com.example.fakestoreapp.models.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {
    @GET("products")
    suspend fun getAllProductos(): List<Product>


    @GET("products/{id}")
    suspend fun getProductById(@Path("id")id:Int) : Product
}