package ar.edu.ort.parcialtp3grupo2.sections.auth.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun GenericTextField(text: String){

    val (tx, setTx) = remember { mutableStateOf("") }

    Column {
        Text(text = text,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = Color(0xFF7C7C7C),
        )

        TextField(
            value = tx,
            onValueChange = setTx,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.Transparent,
                focusedContainerColor = Color.Transparent
            ),
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .fillMaxWidth()

        )

    }
}

@Composable
@Preview(showBackground = true)
fun GenericTextFieldPreview() {
    GenericTextField(text = "Email")
}