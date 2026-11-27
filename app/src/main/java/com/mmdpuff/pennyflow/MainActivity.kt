package com.mmdpuff.pennyflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.mmdpuff.pennyflow.core.room.NoteDatabase
import com.mmdpuff.pennyflow.core.viewmodel.Repository
import com.mmdpuff.pennyflow.core.viewmodel.ViewModel
import com.mmdpuff.pennyflow.navigation.AppNavHost
import com.mmdpuff.pennyflow.ui.models.AppColors
import com.mmdpuff.pennyflow.ui.theme.LocalAppColors
import com.mmdpuff.pennyflow.ui.theme.PennyflowTheme

val colors: AppColors
    @Composable
    get() = LocalAppColors.current

@Suppress("TYPE_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : ComponentActivity() {
    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            NoteDatabase::class.java,
            name = "notes.db",

            ).build()
    }

    private val viewModel by viewModels<ViewModel>(factoryProducer = {
        object : ViewModelProvider.Factory {
            override fun <T : androidx.lifecycle.ViewModel> create(
                modelClass: Class<T>
            ): T {
                if (modelClass.isAssignableFrom(ViewModel::class.java)) {
                    return ViewModel(Repository(db)) as T
                }

                throw IllegalArgumentException("Unknown ViewModel class")
            }
        }
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            PennyflowTheme {


                val navController = rememberNavController()

                AppNavHost()
//                Scaffold(
//                    modifier = Modifier.fillMaxSize(),
//                ) { innerPadding ->
//                    SetupScreen(modifier = Modifier.padding(innerPadding))
//                }
            }
        }
    }
}
