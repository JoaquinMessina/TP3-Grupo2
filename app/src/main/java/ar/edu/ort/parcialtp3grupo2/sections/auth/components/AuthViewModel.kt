package ar.edu.ort.parcialtp3grupo2.sections.auth.components

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ar.edu.ort.parcialtp3grupo2.sections.auth.data.AuthRepository
import ar.edu.ort.parcialtp3grupo2.sections.explore.data.Category
import ar.edu.ort.parcialtp3grupo2.sections.explore.data.CategoryRepository
import kotlinx.coroutines.launch


class AuthViewModel : ViewModel() {
    private val authRepository = AuthRepository()


    suspend fun login(email: String, password: String) : String? {

        return authRepository.login(email, password)

    }

}