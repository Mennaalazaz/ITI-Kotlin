package com.example.mvvmproductapp.data.network

import com.example.mvvmproductapp.data.model.Product
import retrofit2.Response
import retrofit2.http.GET

interface ApiService { // this interface define the API endpoints
        @GET("products")
        suspend fun getProducts(): Response<List<Product>>
}


