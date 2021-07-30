package com.droidknights.app2021.setting.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidknights.app2021.core.ui.compose.util.toColor
import com.droidknights.app2021.setting.ui.compose.NetworkImage
import com.droidknights.app2021.shared.model.User

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun ContributorScreen(
    contributors: List<User>,
    onBackAction: () -> Unit
) {
    Scaffold(
        topBar = {
            SettingAppBar(
                title = "Contributors",
                navigationIcon = {
                    IconButton(onClick = onBackAction) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            cells = GridCells.Fixed(3),
            modifier = Modifier.padding(innerPadding),
            contentPadding = PaddingValues(10.dp)
        ) {
            items(contributors) { contributor ->
                ContributorProfile(
                    modifier = Modifier.padding(8.dp),
                    contributor = contributor
                )
            }
        }
    }
}

@Composable
private fun ContributorProfile(
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
            NetworkImage(
                imageUrl = contributor.photoUrl,
                nonSuccessTintColor = "#43B1B3".toColor(),
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f)
                    .clip(CircleShape)
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
        ContributorScreen(list) {}
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