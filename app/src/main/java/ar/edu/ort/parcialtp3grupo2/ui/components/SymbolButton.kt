package ar.edu.ort.parcialtp3grupo2.ui.components

import android.graphics.drawable.Icon
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun SymbolButton(symbol: ImageVector, isInverted: Boolean = false, onClick: () -> Unit) { // will be + or -

    val buttonColor = if (isInverted) {
        Color.Transparent
    } else {
        Color(0xFF53B175)

    }

    val contentColor = if (isInverted) {
        Color(0xFF53B175)
    } else {
        Color.Transparent
    }

    Button(onClick = onClick,
        modifier = Modifier.width(62.dp).height(62.dp).border(
            width = if(isInverted) 1.dp else 0.dp,
            color = Color(0xFFDDDDDD),
            shape = RoundedCornerShape(24.dp)
        ),
        shape = RoundedCornerShape(24.dp),
        colors = ButtonColors(
            containerColor = buttonColor, // Verde en formato hexadecimal,
            contentColor,
            disabledContentColor = Color(0xFF000000),
            disabledContainerColor = Color(0xFF6F927D),
        ),
        ) {
        Icon(
            imageVector = symbol,
            modifier = Modifier.size(32.dp),
            contentDescription = null,
        )
    }
}