package com.droidknights.app2021.core.ui.compose.layout.progressindicator

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.droidknights.app2021.core.ui.compose.util.toColor

@Composable
fun DotProgressIndicator(
    modifier: Modifier = Modifier
) {
    val dots = listOf("#4285F4", "#EA4335", "#FBBC05", "#34A853")
        .map { color ->
            color.toColor()
        }

    val transition = rememberInfiniteTransition()
    val offsetAnimator = dots.mapIndexed { index, _ ->
        animateOffsetWithDelay(transition, index * DELAY_UNIT, dots.size)
    }

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center
    ) {
        dots.forEachIndexed { index, dot ->
            if (index > 0) {
                Spacer(Modifier.width(DOT_SIZE.div(2f)))
            }
            DroidIndicator(dot, offsetAnimator[index].value)
        }
    }
}

@Composable
private fun animateOffsetWithDelay(
    transition: InfiniteTransition,
    delayMs: Int,
    maxDots: Int
) = transition.animateFloat(
    initialValue = 0f,
    targetValue = 0f,
    animationSpec = infiniteRepeatable(
        animation = keyframes {
            durationMillis = DELAY_UNIT * (maxDots + 2)
            0f at delayMs with LinearEasing
            MAX_OFFSET at delayMs + DELAY_UNIT with LinearEasing
            0f at delayMs + DELAY_UNIT * 2
        }
    )
)

@Composable
private fun DroidIndicator(
    color: Color,
    offset: Float,
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier
            .size(DOT_SIZE)
            .offset(y = -offset.dp)
            .background(
                color = color,
                shape = CircleShape
            )
    )
}

@Preview(heightDp = 40)
@Composable
private fun PreviewDots() {
    DotProgressIndicator()
}

@Preview
@Composable
private fun PreviewDot() {
    DroidIndicator(Color.Yellow, 0f)
}

private const val DELAY_UNIT = 250
private const val MAX_OFFSET = 15f
private val DOT_SIZE = 20.dp