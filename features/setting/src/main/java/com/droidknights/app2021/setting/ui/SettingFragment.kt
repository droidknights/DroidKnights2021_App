package com.droidknights.app2021.setting.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.droidknights.app2021.setting.Route
import com.droidknights.app2021.setting.ScreenAction
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
    NavHost(navController = navController, startDestination = Route.Setting.destination) {
        composable(Route.Setting.destination) {
            SettingScreen { action ->
                val route = when (action) {
                    ScreenAction.Speaker -> Route.Speaker
                    ScreenAction.Contributor -> Route.Contributor
                    ScreenAction.Staff -> Route.Staff
                }
                navController.navigate(route.destination)
            }
        }
        composable(Route.Speaker.destination) {
            val list = buildList {
                repeat(20) {
                    add(User("Droid Kngiths 2021", "", "회사명", "링크"))
                }
            }
            SpeakerScreen(list)
        }
        composable(Route.Contributor.destination) {
            val list = buildList {
                repeat(5) {
                    add(User("Droid Kngiths 2021", ""))
                }
            }
            ContributorScreen(list)
        }
        composable(Route.Staff.destination) {
            val list = buildList {
                repeat(5) {
                    add(User("Droid Kngiths 2021", ""))
                }
            }
            StaffScreen(list)
        }
    }
}