package biz.aydin.toggle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import biz.aydin.toggle.domain.GetNewGreetingUseCase
import biz.aydin.toggle.domain.GetOldGreetingUseCase
import biz.aydin.toggle.domain.NewDomainToggle
import biz.aydin.toggle.domain.NewServiceToggle
import biz.aydin.toggle.domain.NewUIToggle
import biz.aydin.toggle.presentation.GreetingsViewModel
import biz.aydin.toggle.presentation.HomeScreen
import biz.aydin.toggle.presentation.theme.ToggleTheme
import biz.aydin.toggle.service.GetFeatureToggleService
import biz.aydin.toggle.service.GreetingsService

class MainActivity : ComponentActivity() {
    private val newUIToggle = NewUIToggle(GetFeatureToggleService())
    private val newDomainToggle = NewDomainToggle(GetFeatureToggleService())
    private val newServiceToggle = NewServiceToggle(GetFeatureToggleService())
    private val viewModel = GreetingsViewModel(
        getOldGreeting = GetOldGreetingUseCase(GreetingsService(newServiceToggle)),
        getNewGreeting = GetNewGreetingUseCase(GreetingsService(newServiceToggle)),
        newDomainToggle = newDomainToggle,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToggleTheme {
                HomeScreen(
                    viewModel,
                    newUIToggle
                )
            }
        }
    }
}
