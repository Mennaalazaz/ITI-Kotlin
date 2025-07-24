package com.example.mvvmproductapp.data.network

import com.example.mvvmproductapp.data.model.Product
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// this class make object of retrofit
class RetrofitHelper {
    private val api: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    suspend fun fetchProducts(): Response<List<Product>> = api.getProducts()
}

