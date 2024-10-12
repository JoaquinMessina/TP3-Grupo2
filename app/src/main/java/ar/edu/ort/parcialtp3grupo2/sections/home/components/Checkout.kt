@file:OptIn(ExperimentalMaterial3Api::class)

package ar.edu.ort.parcialtp3grupo2.sections.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcialtp3grupo2.R
import ar.edu.ort.parcialtp3grupo2.ui.components.GreenButtonRightText

@Composable
fun CheckoutBottomSheet(
    onDismiss: () -> Unit //futura logica de quite
) {
    ModalBottomSheet(
        onDismissRequest = { onDismiss() }
    ) {
        CheckboxBottomSheetContent(onDismiss)
    }
}


@Composable
fun CheckboxBottomSheetContent(onDismiss: () -> Unit) {
    Column (verticalArrangement = Arrangement.SpaceBetween){
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
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
            ItemRow("Delivery", 18, Color.Gray, rightContent ="Select Method")
            Divider(color = Color.LightGray, thickness = 0.7.dp)
            ItemRow("Pament",18 , Color.Gray, R.drawable.masterlogo)
            Divider(color = Color.LightGray, thickness = 0.7.dp)
            ItemRow("Promo Code",18 , Color.Gray, "Pick discount")
            Divider(color = Color.LightGray, thickness = 0.7.dp)
            ItemRow("Total Cost",18,  Color.Gray,"$13.97")
            Divider(color = Color.LightGray, thickness = 0.7.dp)

            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = buildAnnotatedString {
                    append("By placing an order you agree to our\n")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                        append("Terms")
                    }
                    append(" And ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, color = Color.Black)) {
                        append("Conditions")
                    }
                },
                fontSize = 15.sp,
                color = Color.Gray
            )
        }
        GreenButtonRightText(onClick = { /*TODO*/ }, text = "Place Order")
    }


}




@Preview(showBackground = true)
@Composable
fun testRow(){
    CheckboxBottomSheetContent(onDismiss = { })
}