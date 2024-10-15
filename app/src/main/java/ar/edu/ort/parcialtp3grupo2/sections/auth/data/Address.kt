package ar.edu.ort.parcialtp3grupo2.sections.auth.data

data class Address(
    val city: String,
    val geolocation: Geolocation,
    val number: Int,
    val street: String,
    val zipcode: String
)