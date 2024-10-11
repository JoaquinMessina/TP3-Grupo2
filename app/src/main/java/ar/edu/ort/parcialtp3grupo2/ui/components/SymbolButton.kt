package ar.edu.ort.parcialtp3grupo2.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SymbolButton(symbol: String, onClick: () -> Unit) { // will be + or -
    Button(onClick = onClick,
        modifier = Modifier.width(62.dp).height(62.dp),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonColors(
            containerColor = Color(0xFF53B175), // Verde en formato hexadecimal,
            contentColor = Color(0xFFFFFFFF),
            disabledContentColor = Color(0xFF000000),
            disabledContainerColor = Color(0xFF6F927D),
        ),
        ) {
        Text(
            text = symbol,
            fontSize = 28.sp
        )
    }
}