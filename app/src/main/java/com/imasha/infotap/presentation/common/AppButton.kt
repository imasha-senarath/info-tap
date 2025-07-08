package com.imasha.infotap.presentation.common

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.imasha.infotap.ui.theme.WhiteGray

@Composable
fun AppButton(
    text: String,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold)
        )
    }

}

@Composable
fun AppTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = onClick
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
            color = WhiteGray
        )
    }

}