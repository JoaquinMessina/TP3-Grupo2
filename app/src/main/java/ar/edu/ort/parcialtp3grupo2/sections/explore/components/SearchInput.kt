package ar.edu.ort.parcialtp3grupo2.sections.explore.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.outlined.Send
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SearchInput (
    text: String,
    onTextChange: (String) -> Unit,
    onClick: () -> Unit
){
    TextField(
        value = text,
        onValueChange = {
            onTextChange(it)
        },
        label = { Text("Search Store") },
        leadingIcon = {
            Icon(
                tint = MaterialTheme.colorScheme.tertiary,
                imageVector = Icons.Default.Search,
                contentDescription = "Email Icon"
            )
        },
        trailingIcon = {
            IconButton(onClick = { onClick() }) {
                Icon(
                    tint = MaterialTheme.colorScheme.tertiary,
                    imageVector =  Icons.Filled.Tune,
                    contentDescription = "Clear Text"
                )
            }
        },
        shape = RoundedCornerShape(16.dp),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = MaterialTheme.colorScheme.background,
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