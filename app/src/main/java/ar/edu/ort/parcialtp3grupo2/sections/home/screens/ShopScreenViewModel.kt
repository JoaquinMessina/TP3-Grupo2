package ar.edu.ort.parcialtp3grupo2.sections.home.screens


// how to implement a view model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product
import ar.edu.ort.parcialtp3grupo2.sections.home.data.ProductRepository

class ShopScreenViewModel : ViewModel() {

    private val productRepository = ProductRepository()

    var products by mutableStateOf(productRepository.getAllData())
        private set

    fun addProduct(product: Product) {
        products = products + product
    }

    fun removeProduct(product: Product) {
        products = products - product
    }
}

