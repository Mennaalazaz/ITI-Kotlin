package com.example.mvvmproductapp.data

import retrofit2.http.GET

interface ApiService {
        @GET("products")
        suspend fun getProducts(): List<Product>
}


