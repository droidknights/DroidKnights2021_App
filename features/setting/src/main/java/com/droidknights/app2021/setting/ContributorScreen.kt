package com.droidknights.app2021.setting

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.droidknights.app2021.shared.model.User
import com.droidknights.app2021.ui.core.compose.util.toColor

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ContributorScreen(
    contributors: List<User>
) {
    Scaffold(
        topBar = {
            Column(
                Modifier.padding(start = 24.dp, top = 24.dp, end = 24.dp, bottom = 14.dp)
            ) {
                Text(
                    text = "Contributors",
                    color = "#2F2E32".toColor(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(contributors) { contributor ->
                ContributorProfile(
                    modifier = Modifier.padding(10.dp),
                    contributor = contributor
                )
            }
        }
    }
}

@Composable
fun ContributorProfile(
    modifier: Modifier = Modifier,
    contributor: User
) {
    Card(
        modifier = modifier.aspectRatio(1f),
        shape = RoundedCornerShape(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(CircleShape),
                painter = rememberImagePainter(
                    data = contributor.photoUrl,
                    builder = {
                        crossfade(true)
                        placeholder(R.drawable.ic_black_android_24)
                        error(R.drawable.ic_black_android_24)
                    },
                ),
                colorFilter = ColorFilter.tint(color = "#43B1B3".toColor()),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = contributor.name,
                color = "#2F2E32".toColor(),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Preview(heightDp = 250)
@Composable
fun ContributorsProfilePreview() {
    val list = buildList {
        repeat(5) {
            add(User("Droid Kngiths 2021", ""))
        }
    }
    Surface {
        ContributorScreen(list)
    }
}

@Preview(widthDp = 150, heightDp = 150)
@Composable
fun ContributorProfilePreview() {
    Surface {
        ContributorProfile(
            contributor = User("Droid Kngiths 2021", "")
        )
    }
}