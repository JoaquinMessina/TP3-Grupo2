package ar.edu.ort.parcialtp3grupo2.sections.explore.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import ar.edu.ort.parcialtp3grupo2.R as res

@Composable
fun CategoryCard(color: Color, title: String, onClick: () -> Unit) {
    Box(modifier = Modifier
        .width(180.dp)
        .height(190.dp)
        .border(
            width = 1.dp,

            color = color.copy(alpha = 0.7f),
            shape = RoundedCornerShape(18.dp)
        )
        .background(color.copy(alpha = 0.1f), shape = RoundedCornerShape(18.dp))
        .clickable { onClick() }
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
                Image(
                    painter = painterResource(id = res.drawable.fruits),
                    contentDescription = "Shoe",
                    modifier = Modifier
                        .size(100.dp)
                )
            Text(
                text = title,
                color = Color.Black,
                fontSize = 16.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
                    .align(Alignment.CenterHorizontally)

            )
        }
    }
}