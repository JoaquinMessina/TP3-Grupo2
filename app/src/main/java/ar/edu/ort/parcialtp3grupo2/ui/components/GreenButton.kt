package ar.edu.ort.parcialtp3grupo2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.ui.theme.BrandTheme


@Composable
fun  GreenButton(onClick: () -> Unit, text: String, leftIcon: ImageVector? = null, isInverted: Boolean = false) {

    val backgroundColor = if (isInverted) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.primary
    val contentColor = if (isInverted) Color(0xFF53B175) else Color(0xF2F3F2FF)

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
           backgroundColor,
            contentColor
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .height(67.dp),
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){

        if (leftIcon != null) {
                Icon(
                    imageVector = leftIcon,
                    contentDescription = null,
                    tint = contentColor,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .padding(start = 16.dp),
                )
        }
        Text(
            text = text,
            fontSize = 18.sp
        )
        }

    }
}

@Composable
fun GreenButtonRightText(onClick: () -> Unit,isInverted: Boolean = false, text: String, rightText: String? = null) {
    val backgroundColor = if (isInverted) MaterialTheme.colorScheme.background else MaterialTheme.colorScheme.primary
    val contentColor = if (isInverted) Color(0xFF53B175) else Color(0xF2F3F2FF)
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            backgroundColor,
            contentColor
        ),
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
            .height(67.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = text,
                fontSize = 18.sp
            )
            if (rightText != null) {
                Text(
                    text = rightText,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .align(Alignment.CenterEnd)
                        .background(
                            Color(0xFF489E67),
                            shape = RoundedCornerShape(4.dp)
                        )
                        .padding(horizontal = 4.dp, vertical = 1.dp)
                )
            }
        }
    }
}




