package ar.edu.ort.parcialtp3grupo2.sections.auth.data

class AuthRepository {
    private val Retrofit = RetrofitServiceFactory.makeRetrofitService()
    suspend fun login(email: String, password: String) : String? {
        val response = Retrofit.GetToken(User(email,password))
        if(response.isSuccessful) {
            val body = response.body()
            if(body?.token != null) {
                return body.token
            } else {
                return null
            }
        } else {
            return null
        }
    }
}
