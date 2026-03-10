package com.example.ratingbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.twotone.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RatingBar(
    rating: Float,
    onRatingChanged: (Float) -> Unit,
    maxRating: Int = 5
) {
    Row(horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        for (i in 1..maxRating) {
            val isHalfFilled = rating > i - 1 && rating < i
            Icon(
                imageVector = when {
                    i <= rating -> Icons.Default.Star
                    isHalfFilled -> Icons.Default.Add
                    else -> Icons.TwoTone.Star
                },
                contentDescription = "Rating $i",
                modifier = Modifier
                    .size(32.dp)
                    .clickable { onRatingChanged(i.toFloat()) },
                tint = Color.Yellow
            )
        }
    }
}