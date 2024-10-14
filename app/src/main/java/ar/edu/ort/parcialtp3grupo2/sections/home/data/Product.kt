package ar.edu.ort.parcialtp3grupo2.sections.home.data

data class Product(
    val id: String,
    val name: String,
    val price: Double,
    val amount: String,
    val image: Int, //futuramente agregar imagen
    val detail: String,

    val categoryId: Int
)
