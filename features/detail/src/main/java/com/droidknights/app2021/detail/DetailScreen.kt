package com.droidknights.app2021.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidknights.app2021.ui.core.compose.layout.Tag
import com.droidknights.app2021.ui.core.compose.util.color
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            FlowRow(mainAxisSpacing = 6.dp) {
                repeat(5) {
                    Tag(text = "Tag $it", color = "#897dad".color)
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "테스트",
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(18.dp))
            ProfilesInfo()
        }
        Divider(modifier = Modifier.height(8.dp), color = "#F5F5F5".color)

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        ) {
            Text(
                text = "내용",
                color = "#2F2E32".color,
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = """
                    드로이드나이츠는 "안드로이드 개발자들을 위한 컨퍼런스"를 표방하며 안드로이드 기술에 대한 세션으로 안드로이드 개발자들의 경험을 공유하고 만남의 장을 만드는 컨퍼런스 입니다.
                 
                    한국은 높은 안드로이드점유율과 관련 제조사, 플랫폼 개발회사, 앱 개발회사 등 개발 생태계가 잘 발달하였음에도 불구하고 안드로이드 개발자들이 지식을 나눌 수 있는 기회가 부족하다는 필요로 인해 비영리 개발자 조직에 의해 만들어졌습니다. 
                """.trimIndent(),
                color = "#9B9B9B".color,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
fun ProfilesInfo(
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        ProfileImages()
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = "발표자 · 발표자")
    }
}

@Composable
fun ProfileImages() {
    ProfileOverLayout {
        repeat(2) {
            Image(
                painter = painterResource(id = R.drawable.ic_android_92b9e9_24),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape)
                    .background(color = Color.White)
                    .border(2.dp, color = Color.White, shape = CircleShape),
                contentDescription = null,
            )
        }
    }
}

@Composable
fun ProfileOverLayout(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        modifier = modifier,
        content = content
    ) { measurables, constraints ->
        val placeables = measurables.map { measurable ->
            measurable.measure(constraints)
        }

        val layoutWidth = placeables.sumOf { it.width } - if (placeables.size > 1) {
            (placeables.size - 1) * 11.dp.toPx().toInt()
        } else {
            0
        }

        layout(
            width = layoutWidth,
            height = placeables.maxOf { it.height }
        ) {
            var xPosition = 0

            placeables.forEach { placeable ->
                placeable.placeRelative(x = xPosition, y = 0)
                xPosition += 24.dp.toPx().toInt()
            }
        }
    }
}