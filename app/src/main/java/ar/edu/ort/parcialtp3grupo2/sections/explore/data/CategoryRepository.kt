package ar.edu.ort.parcialtp3grupo2.sections.explore.data

import androidx.compose.ui.graphics.Color
import ar.edu.ort.parcialtp3grupo2.R

class CategoryRepository {

    fun getAllData(): List<Category> {
        return listOf(
            Category(
                id = 1,
                name = "Frash Fruits & Vegetable",
                image = R.drawable.fruitsvegetables,
                color = Color(0xFF53B175)
            ),
            Category(
                id = 2,
                name = "Cooking Oil & Ghee",
                image = R.drawable.oilnghee,
                color = Color(0xFFF8A44C)
            ),
            Category(
                id = 3,
                name = "Meat & Fish",
                image = R.drawable.meatnfish,
                color = Color(0xFFF7A593)
            ),
            Category(
                id = 4,
                name = "Bakery & Snacks",
                image = R.drawable.bakerynsnacks,
                color = Color(0xFFD3B0E0)
            ),
            Category(
                id = 5,
                name = "Dairy & Eggs",
                image = R.drawable.dairyneggs,
                color = Color(0xFFFDE598)
            ),
            Category(
                id = 6,
                name = "Beverages",
                image = R.drawable.beverages,
                color = Color(0xFFB7DFF5)
            ),
            Category(
                id = 7,
                name = "Personal Care",
                image = R.drawable.beverages,
                color = Color(0xFFD20B35)
            ),
            Category(
                id = 8,
                name = "Home Care",
                image = R.drawable.dairyneggs,
                color = Color(0xFF00B9B9)
            ),
        )
    }

}