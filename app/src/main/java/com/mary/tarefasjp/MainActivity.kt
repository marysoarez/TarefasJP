package com.mary.tarefasjp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mary.tarefasjp.ui.theme.TarefasJPTheme
import com.mary.tarefasjp.view.ListaTarefas
import com.mary.tarefasjp.view.SalvarTarefa

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TarefasJPTheme {

                val navController = rememberNavController( )
                NavHost(navController = navController,
                    startDestination = "listaTarefas"){
                    composable(
                        route = "listaTarefas"){
                            ListaTarefas(navController)
                        }

                    composable(route = "salvarTarefa"){
                        SalvarTarefa(navController)
                    }


                }

            }
        }
    }
}
