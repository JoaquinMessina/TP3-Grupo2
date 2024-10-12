package ar.edu.ort.parcialtp3grupo2.sections.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SectionTitle(title: String) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp, 16.dp)
    ){
        Text(
            text = title,
            fontSize = 24.sp,
            fontWeight = FontWeight(700),
        )

        Text(text = "See all", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color(0xFF53B175))
    }
}