@file:OptIn(ExperimentalMaterial3Api::class)

package ar.edu.ort.parcialtp3grupo2.sections.home.components
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButtonRightText
import ar.edu.ort.parcialtp3grupo2.ui.navigation.AppDestination

@Composable
fun CheckoutBottomSheet(
    onDismiss: () -> Unit,
    sheetState: SheetState,
    navController: NavController
) {
    ModalBottomSheet(
        sheetState = sheetState,
        onDismissRequest = { onDismiss() },
        dragHandle = {false}
    ) {
        CheckboxBottomSheetContent(onDismiss, navController)
    }
}


@Composable
fun CheckboxBottomSheetContent(onDismiss: () -> Unit, navController: NavController) {
    Column (verticalArrangement = Arrangement.SpaceBetween){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Checkout",
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                )
                IconButton(onClick = { onDismiss()}) {
                    Icon(
                        imageVector = Icons.Default.Close,
                        contentDescription = "Close",
                        tint = Color.Black
                    )
                }
            }
            Spacer(modifier = Modifier.height(25.dp))

            Row {

            }
            Divider(color = Color.LightGray, thickness = 0.7.dp)
            ItemRow("Delivery", 18, MaterialTheme.colorScheme.secondary, rightContent ="Select Method")
            Divider(color = Color.LightGray, thickness = 0.7.dp)
            ItemRow("Pament",18 , MaterialTheme.colorScheme.secondary, R.drawable.masterlogo)
            Divider(color = Color.LightGray, thickness = 0.7.dp)
            ItemRow("Promo Code",18 , MaterialTheme.colorScheme.secondary, "Pick discount")
            Divider(color = Color.LightGray, thickness = 0.7.dp)
            ItemRow("Total Cost",18,  MaterialTheme.colorScheme.secondary,"$13.97")
            Divider(color = Color.LightGray, thickness = 0.7.dp)

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("By placing an order you agree to our\n")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary)) {
                        append("Terms")
                    }
                    append(" And ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.tertiary)) {
                        append("Conditions")
                    }
                },
                fontSize = 15.sp,
                color = Color.Gray
            )
        }
        GreenButtonRightText(onClick = { navController.navigate(AppDestination.OrderAccepted.route) }, text = "Place Order")
    }


}
