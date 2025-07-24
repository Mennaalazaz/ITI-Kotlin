package com.example.mvvmproductapp.ui.home.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmproductapp.data.model.Product
import com.example.mvvmproductapp.data.repo.ProductReposatory
import kotlinx.coroutines.launch

// the view model communicate with the product repository not with retrofit Helper

class ProductViewModel (val repository : ProductReposatory): ViewModel() {
    private val _products = MutableLiveData<List<Product>>()
    val products: LiveData<List<Product>> = _products

    fun loadProducts() {
        viewModelScope.launch {
              val response = repository.getAllProducts()
            if (response.isSuccessful) {
                _products.value = response.body()
            }
    }
}
}

