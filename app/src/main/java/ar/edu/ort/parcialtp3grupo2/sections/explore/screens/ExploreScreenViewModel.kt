package ar.edu.ort.parcialtp3grupo2.sections.explore.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import ar.edu.ort.parcialtp3grupo2.sections.explore.data.Category
import ar.edu.ort.parcialtp3grupo2.sections.explore.data.CategoryRepository
import ar.edu.ort.parcialtp3grupo2.sections.home.data.Product

class ExploreScreenViewModel : ViewModel() {
    private val categoriesRepository = CategoryRepository()

    var categories by mutableStateOf(categoriesRepository.getAllData())
        private set

    fun getAllCategories(): List<Category> {
        return categories
    }


}