package ar.edu.ort.parcialtp3grupo2.sections.home.data

import ar.edu.ort.parcialtp3grupo2.R

class ProductRepository {

    fun getAllData(): List<Product> {
        return listOf(
            Product(
                id = "0",
                name = "Apple",
                price = 3000.0,
                amount = "1kg",
                image = R.drawable.apple,
                detail = "Apples are nutritious. Apples may be good for weight loss. apples may be good for your heart. As part of a healtful and varied diet."
            ),
            Product(
                id = "1",
                name = "Sprite",
                price = 3000.0,
                amount = "330ml",
                image = R.drawable.sprite,
                detail = "Fresh and sweet, always a good choice (of course over seven up)"
            ),
            Product(
                id = "2",
                name = "Coca Cola",
                price = 3000.0,
                amount = "330ml",
                image = R.drawable.coca,
                detail = "The best soda in the world, always a good choice"
            ),
            Product(
                id = "3",
                name = "Pepsi",
                price = 3000.0,
                amount = "330ml",
                image = R.drawable.pepsi,
                detail = "The second best soda in the world, always a good choice"
            ),
            Product(
                id ="4" ,
                name = "Fanta",
                price = 3000.0,
                amount = "330ml",
                image = R.drawable.fanta,
                detail = "The third best soda in the world, always a good choice"
            ),
        )
    }

}