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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.ktx.Firebase
import com.mary.tarefasjp.R
import com.mary.tarefasjp.itemlista.TarefaItem
import com.mary.tarefasjp.model.Tarefa
import com.mary.tarefasjp.ui.theme.BLACK
import com.mary.tarefasjp.ui.theme.PINKY
import com.mary.tarefasjp.ui.theme.WHITE

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ListaTarefas(
    navController: NavController
){

    Firebase

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
        val listaTarefas: MutableList<Tarefa> = mutableListOf(
            Tarefa(
                tarefa = "Jogar Futebol",
                descricao = "Tirar um tempino para jogar futebol",
                prioridade = 0
            ),
            Tarefa(
                tarefa = "ir ao cinema",
                descricao = "vai sair Super mario",
                prioridade = 1
            ),
            Tarefa(
                tarefa = "ir para a faculdade",
                descricao = "Tirar um tempino para jogar futebol",
                prioridade = 2
            ),
            Tarefa(
                tarefa = "GRAVE",
                descricao = "Tirar um tempino para jogar futebol",
                prioridade = 3
            )
        )

        LazyColumn{
            itemsIndexed(listaTarefas){
                position, _ ->
                TarefaItem(position, listaTarefas)
            }
        }

    }

}