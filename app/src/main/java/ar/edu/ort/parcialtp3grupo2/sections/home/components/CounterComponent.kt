package ar.edu.ort.parcialtp3grupo2.sections.home.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.ui.components.SymbolButton
@Composable
fun Counter(count: Int, onIncrement: () -> Unit, onDecrement: () -> Unit) {

    Row(
        modifier = Modifier
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Icon(imageVector = Icons.Default.Remove,
            contentDescription = null,
            tint = Color(0xFFB3B3B3),
            modifier = Modifier.clickable { onDecrement() }
                .padding(end = 10.dp))

        Box(
            modifier = Modifier
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(20.dp))
                .padding(16.dp)
                .height(20.dp)
        ) {
            Text(
                text = count.toString(),
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        Icon(imageVector = Icons.Default.Add,
            contentDescription = null,
            tint = Color(0xFF53B175),
            modifier = Modifier.clickable { onIncrement() }
                .padding(10.dp))

    }
}



