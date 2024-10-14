package ar.edu.ort.parcialtp3grupo2.sections.auth.data

data class User(
    val __v: Int,
    val address: Address,
    val email: String,
    val id: Int,
    val name: Name,
    val password: String,
    val phone: String,
    val username: String
)
