package ar.edu.ort.parcialtp3grupo2.sections.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.R

@Composable
fun ItemRow(label: String, fontSize: Int, color: Color, rightContent: Any, imageSize: Int? = null) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .height(60.dp)
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = label,
                fontSize = fontSize.sp,
                color = color
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                if (rightContent is String) {
                    Text(
                        text = rightContent,
                        fontSize = fontSize.sp
                    )
                } else if (rightContent is Int) {
                    Image(
                        painter = painterResource(id = rightContent),
                        contentDescription = null,
                        modifier = Modifier.size((imageSize ?: 24).dp) // Usa imageSize o 16.dp por defecto
                    )
                }
                Spacer(modifier = Modifier.width(5.dp))

                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
    }
}
