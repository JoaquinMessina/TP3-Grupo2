package ar.edu.ort.parcialtp3grupo2.sections.home.data

class ProductRepository {

    fun getAllData(): List<Product> {
        return listOf(
            Product(
                id = 1,
                name = "Apple",
                price = 3000.0,
                amount = "1kg",
                image = 2,
                detail = "Apples are healthy and valiable meal for your day"
            ),
            Product(
                id = 2,
                name = "Sprite",
                price = 3000.0,
                amount = "330ml",
                image = 2,
                detail = "Fresh and sweet, always a good choice (of course over seven up)"
            ),
            Product(
                id = 3,
                name = "Coca Cola",
                price = 3000.0,
                amount = "330ml",
                image = 2,
                detail = "The best soda in the world, always a good choice"
            ),
            Product(
                id = 4,
                name = "Pepsi",
                price = 3000.0,
                amount = "330ml",
                image = 2,
                detail = "The second best soda in the world, always a good choice"
            ),
            Product(
                id = 5,
                name = "Fanta",
                price = 3000.0,
                amount = "330ml",
                image = 2,
                detail = "The third best soda in the world, always a good choice"
            ),
        )
    }

}