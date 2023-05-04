package com.mary.tarefasjp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.ktx.Firebase
import com.mary.tarefasjp.R
import com.mary.tarefasjp.itemlista.TarefaItem
import com.mary.tarefasjp.model.Tarefa
import com.mary.tarefasjp.repositorio.TarefasRepositorio
import com.mary.tarefasjp.ui.theme.BLACK
import com.mary.tarefasjp.ui.theme.PINKY
import com.mary.tarefasjp.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
){

   val tarefasRepositorio = TarefasRepositorio ()
   val context = LocalContext.current


    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = WHITE,
                title = {
                    Text(
                        text = "Lista de Tarefas",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color= BLACK
                         )
                    }
                )

        },
        backgroundColor = WHITE,

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          navController.navigate("salvarTarefa")
            },
            backgroundColor = PINKY
                ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = "Ícone de salvar tarefa"
                )

            }
        }



    ) {
        val listaTarefas = tarefasRepositorio.recuperarTarefas().collectAsState(mutableListOf()).value

        LazyColumn{
            itemsIndexed(listaTarefas){
                position, _, ->
                TarefaItem(position = position, listaTarefas = listaTarefas, context = context, navController = navController)
            }
        }

    }

}