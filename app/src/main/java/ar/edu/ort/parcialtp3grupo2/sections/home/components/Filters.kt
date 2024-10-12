package ar.edu.ort.parcialtp3grupo2.sections.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.ui.draw.clip
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButtonRightText


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FiltersBottomSheet(
    onDismiss: () -> Unit //futura logica de quite
) {
    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        modifier = Modifier.fillMaxHeight()
    ) {

        FiltersContent(onDismiss)
    }
}


@Composable
fun FiltersContent(onDismiss: () -> Unit) {

    Column(
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = { onDismiss() }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Close",
                    tint = Color.Black
                )
            }
            Text(
                fontSize = 16.sp,
                text = "Filters",
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                color = Color.Black,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.width(48.dp))
        }
        Spacer(modifier = Modifier.height(15.dp))

        Column (
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(30.dp))
                .background(Color(0xFFF2F3F2))
                ,
            verticalArrangement = Arrangement.SpaceBetween

            ){
            Column (modifier = Modifier.padding(16.dp)){
                Text(
                    text = "Categories",
                    fontSize = 19.sp,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black // Texto en negro
                )
                Spacer(modifier = Modifier.height(8.dp))
                MyCheckboxes(listOf("Eggs", "Noodles & Pasta", "Chips & Crisp", "Fast Food"))

                Spacer(modifier = Modifier.height(24.dp))

                // Sección de "Brand"
                Text(
                    text = "Brand",
                    fontSize = 19.sp,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color.Black // Texto en negro
                )
                MyCheckboxes(listOf("Individual Collection", "Coca-Cola", "Ifad", "Kazi Farmas"))
            }
            GreenButtonRightText(onClick = { /*TODO*/ }, text = "Apply Filters")
        }
    }
}


@Composable
fun MyCheckboxes(list: List<String>) {
    val checkedState = remember { mutableStateListOf(false, false, false, false) }

    list.forEachIndexed { index, category ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
        ) {

            TriStateCheckbox(
                state = if (checkedState[index]) ToggleableState.On else ToggleableState.Off,
                onClick = { checkedState[index] = !checkedState[index] },
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(24.dp),
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Green,
                    uncheckedColor = Color.LightGray,
                    checkmarkColor = Color.White
                )
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(text = category, color = Color.Black)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TestPreview() {
    FiltersContent(onDismiss = { /* No hace nada en la vista previa */ })
}

