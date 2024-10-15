package ar.edu.ort.parcialtp3grupo2.sections.auth.data

import okhttp3.Credentials
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

data class SuccesfulResponse (val token: String)

interface RetrofitService {
    @POST("auth/login")

    suspend fun GetToken(@Body credentials: User): Response<SuccesfulResponse>

}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}