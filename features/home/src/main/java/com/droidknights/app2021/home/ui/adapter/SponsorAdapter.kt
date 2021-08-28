package com.droidknights.app2021.home.ui.adapter

import android.view.ViewGroup
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.droidknights.app2021.home.compose.adapters.ComposeListAdapter
import com.droidknights.app2021.home.compose.adapters.ComposeViewHolder
import com.droidknights.app2021.home.compose.view.NetworkImage
import com.droidknights.app2021.home.util.recyclerview.ItemDiffCallback
import com.droidknights.app2021.shared.model.Sponsor
import timber.log.Timber

class SponsorAdapter(
    sponsors: List<Sponsor>,
    private val itemHandler: ItemHandler,
) : ComposeListAdapter<Sponsor, SponsorAdapter.SponsorViewHolder>(ItemDiffCallback(
    onItemsTheSame = { old, new -> old.name == new.name },
    onContentsTheSame = { old, new -> old == new }
)) {

    init {
        submitList(sponsors + sponsors + sponsors)
    }

    class SponsorViewHolder(
        composeView: ComposeView,
        private val itemHandler: ItemHandler
    ) : ComposeViewHolder<Sponsor>(composeView) {

        @Composable
        override fun ViewHolder(input: Sponsor) {
            SponsorItem(input, itemHandler)
        }
    }

    interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SponsorViewHolder {
        return SponsorViewHolder(ComposeView(parent.context), itemHandler)
    }

    override fun onBindViewHolder(holder: SponsorViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }
}

@ExperimentalCoilApi
@Composable
fun SponsorItem(
    sponsor: Sponsor,
    itemHandler: SponsorAdapter.ItemHandler
) {
    Column(
        Modifier.wrapContentHeight()
            .padding(vertical = 10.dp)
    ) {
        NetworkImage(
            sponsor.photoUrl,
            Color(0xFF43B1B3),
            Modifier.height(22.dp).wrapContentWidth()
                .clickable {
                    itemHandler.clickSponsor(sponsor)
                }
        )
    }
}

@ExperimentalCoilApi
@Preview(
    backgroundColor = 0x000000
)
@Composable
fun PreviewSponsor() {
    SponsorItem(
        sponsor = Sponsor(
            "toss",
            "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_toss.png",
            "https://toss.im/"
        ),
        itemHandler = object : SponsorAdapter.ItemHandler {
            override fun clickSponsor(sponsor: Sponsor) {

            }
        }
    )
}