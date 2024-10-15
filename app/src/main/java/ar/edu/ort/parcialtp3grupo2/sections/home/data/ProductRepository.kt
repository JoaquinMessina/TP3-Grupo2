package ar.edu.ort.parcialtp3grupo2.sections.home.data

import ar.edu.ort.parcialtp3grupo2.R

class ProductRepository {
    private val products = listOf(
        Product(
            id = "0",
            categoryId = 1,
            name = "Apple",
            price = 4.99,
            amount = "1kg",
            image = R.drawable.apple,
            detail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet."
        ),
        Product(
            id = "1",
            name = "Sprite",
            price = 1.99,
            amount = "330ml",
            image = R.drawable.sprite,
            detail = "Fresh and sweet, always a good choice (of course over seven up)",
            categoryId = 6
        ),
        Product(
            id = "2",
            name = "Coca Cola",
            price = 1.99,
            amount = "330ml",
            image = R.drawable.coca,
            detail = "The best soda in the world, always a good choice",
            categoryId = 6
        ),
        Product(
            id = "3",
            name = "Pepsi",
            price = 1.99,
            amount = "330ml",
            image = R.drawable.pepsi,
            detail = "The second best soda in the world, always a good choice",
            categoryId = 6
        ),
        Product(
            id ="4" ,
            name = "Fanta",
            price = 1.99,
            amount = "330ml",
            image = R.drawable.fanta,
            detail = "The third best soda in the world, always a good choice",
            categoryId = 6
        ),
        Product(
            id = "5",
            name = "7up",
            price = 1.99,
            amount = "330ml",
            image = R.drawable.sprite,
            detail = "The fourth best soda in the world, always a good choice",
            categoryId = 6
        ),
        Product(
            id = "6",
            name = "Ground Meat",
            price = 4.50,
            amount = "1kg",
            image = R.drawable.groundmeat,
            detail = "The best meat in the world, always a good choice",
            categoryId = 3
        )
    )

    fun getAllData(): List<Product> {
        return this.products
    }

    fun getByCategoryId(id: Int): List<Product>{
        return this.products.filter { it.categoryId == id }
    }
}