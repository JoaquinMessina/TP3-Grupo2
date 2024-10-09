package ar.edu.ort.parcialtp3grupo2.sections.home.data

class ProductRepository {

    fun getAllData(): List<Product> {
        return listOf(
            Product(
                name = "Apple",
                price = 3000.0,
                amount = "1kg",
                image = 2,
                detail = "Apples are healthy and valiable meal for your day"
            ),
            Product(
                name = "Sprite",
                price = 3000.0,
                amount = "330ml",
                image = 2,
                detail = "Fresh and sweet, always a good choice (of course over seven up)"
            ),
        )
    }

}