package com.droidknights.app2021.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.droidknights.app2021.shared.model.User
import com.droidknights.app2021.ui.core.compose.setThemeContent

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setThemeContent {
            SettingContainer()
        }
    }
}

@OptIn(ExperimentalStdlibApi::class)
@Composable
fun SettingContainer() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "setting") {
        composable("setting") {
            SettingScreen(
                onContributorClicked = {
                    navController.navigate("contributor")
                }
            )
        }
        composable("contributor") {
            val list = buildList {
                repeat(5) {
                    add(User("Droid Kngiths 2021", ""))
                }
            }
            ContributorScreen(list)
        }
    }
}