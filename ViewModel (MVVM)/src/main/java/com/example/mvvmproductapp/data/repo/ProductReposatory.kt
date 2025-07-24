package com.example.mvvmproductapp.data.repo

import com.example.mvvmproductapp.data.model.Product
import com.example.mvvmproductapp.data.network.RetrofitHelper
import retrofit2.Response

// this class get data from the api and return it to the view model
class ProductReposatory (val retrofetHelper :RetrofitHelper) {
    suspend fun getAllProducts() : Response<List<Product>> {
        return retrofetHelper.fetchProducts()
    }
}

