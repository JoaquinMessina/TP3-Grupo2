package ar.edu.ort.parcialtp3grupo2.sections.explore.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SearchInput (
    text: String,
    onTextChange: (String) -> Unit
){
    TextField(
        value = text,
        onValueChange = {
            onTextChange(it)
        },
        label = { Text("Search Store") },
        leadingIcon = {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                contentDescription = "Email Icon"
            )
        },
        trailingIcon = {
            IconButton(onClick = { text }) {
                Icon(
                    imageVector =  Icons.AutoMirrored.Outlined.Send,
                    contentDescription = "Clear Text"
                )
            }
        },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xF2F3F2FF),
            cursorColor = Color(0x00000000),
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .width(500.dp)
            .padding(horizontal = 16.dp)
    )
}