package ar.edu.ort.parcialtp3grupo2.sections.auth.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState

@Composable
fun AlertDialog(shouldShowDialog: MutableState<Boolean>, topText: String, message: String) {
    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            },

            title = { Text(text = topText) },
            text = { Text(text = message) },
            confirmButton = {
                Button(
                    onClick = {
                        shouldShowDialog.value = false
                    }
                ) {
                    Text(
                        text = "Confirm",
                        //color = Color.White
                    )
                }
            }
        )
    }
}