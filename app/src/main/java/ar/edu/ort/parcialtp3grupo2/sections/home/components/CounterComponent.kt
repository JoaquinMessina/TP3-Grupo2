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
fun Counter(num: Int, onIncrement: () -> Unit, onDecrement: () -> Unit ) {
Box (modifier = Modifier
    .width(150.dp)
    .height(90.dp)){
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        SymbolButton(symbol = Icons.Default.KeyboardArrowDown,isInverted = true, onClick = {
            onDecrement()
        })
        Box(
            modifier = Modifier
                .border(BorderStroke(1.dp, Color.LightGray), RoundedCornerShape(17.dp))
                .padding(15.dp)
        ) {
            Text(
                text = num.toString(),
                fontSize = 20.sp,
                color = Color.Black
            )
        }

        SymbolButton(symbol = Icons.Default.Add, isInverted = true, onClick = {
            onIncrement()
        })
    }
}

}
