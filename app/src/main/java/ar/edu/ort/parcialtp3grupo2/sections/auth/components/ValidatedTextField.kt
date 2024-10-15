package ar.edu.ort.parcialtp3grupo2.sections.auth.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ValidatedTextField(text: String, value: String, setValue: (String) -> Unit, isValid: Boolean = false) {


    Column {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color(0xFF7C7C7C),
        )
        TextField(
            value = value,
            onValueChange = setValue,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            trailingIcon = {
                if (isValid) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Valid email",
                        tint = Color(0xFF53B175)
                    )
                }
            }
        )
    }
}
