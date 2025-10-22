package com.imasha.infotap.utils

import android.content.Context
import android.widget.Toast
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

object AppDialog {

    fun showToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @Composable
    fun ErrorDialog(
        message: String,
        onDismiss: () -> Unit
    ) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Error") },
            text = { Text(message) },
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "Ok")
                }
            }
        )
    }

    @Composable
    fun InfoDialog(
        title: String,
        message: String,
        onDismiss: () -> Unit
    ) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(title) },
            text = { Text(message) },
            confirmButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "Ok")
                }
            }
        )
    }

    @Composable
    fun ConfirmationDialog(
        title: String,
        message: String,
        onConfirm: () -> Unit,
        onDismiss: () -> Unit
    ) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(title) },
            text = { Text(message) },
            confirmButton = {
                TextButton(onClick = {
                    onConfirm()
                    onDismiss()
                }) {
                    Text(text = "Yes")
                }
            },
            dismissButton = {
                TextButton(onClick = onDismiss) {
                    Text(text = "No")
                }
            }
        )
    }

    @Composable
    fun SuccessDialog(
        message: String,
        onConfirm: () -> Unit
    ) {
        // Custom layout with Compose
        AlertDialog(
            onDismissRequest = { onConfirm() },
            title = { Text("Success") },
            text = { Text(message) },
            confirmButton = {
                TextButton(onClick = onConfirm) {
                    Text("OK")
                }
            }
        )
    }
}
