package com.droidknights.app2021.util

import android.content.Context
import java.nio.charset.Charset

class AssetUtil private constructor() {
    companion object {
        fun loadAsset(context: Context, fileName: String): String {
            return context.assets.open(fileName).use {
                val size = it.available()
                val buffer = ByteArray(size)
                it.read(buffer)

                String(buffer, Charset.forName("UTF-8"))
            }
        }
    }
}