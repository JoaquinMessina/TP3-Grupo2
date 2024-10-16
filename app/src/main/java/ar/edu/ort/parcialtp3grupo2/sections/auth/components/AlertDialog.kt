package ar.edu.ort.parcialtp3grupo2.sections.auth.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun AlertDialog(shouldShowDialog: MutableState<Boolean>, topText: String, message: String) {

    if (shouldShowDialog.value) {
        AlertDialog(
            onDismissRequest = {
                shouldShowDialog.value = false
            },
            backgroundColor = Color.White,
            title = { Text(text = topText) },
            text = { Text(text = message) },
            confirmButton = {
                Button(
                    onClick = {
                        shouldShowDialog.value = false
                    },


                ) {
                    Text(
                        text = "Confirm",
                        //Modifier.background(color = MaterialTheme.colorScheme.primary)
                        //color = MaterialTheme.colorScheme.primary
                        //color = contentColor

                    )
                }
            }
        )
    }
}