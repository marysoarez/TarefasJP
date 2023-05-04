package com.mary.tarefasjp.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.mary.tarefasjp.components.Botao
import com.mary.tarefasjp.components.CaixaDeTexto
import com.mary.tarefasjp.constantes.Constantes
import com.mary.tarefasjp.repositorio.TarefasRepositorio
import com.mary.tarefasjp.ui.theme.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SalvarTarefa(
    navController: NavController
){

    val scope = rememberCoroutineScope()
    val context= LocalContext.current
    val tarefasRepositorio = TarefasRepositorio()

    Scaffold(
        topBar = {
            TopAppBar (
                backgroundColor = BLUE,
                title = {
                    Text(text = "Salvar Tarefa",
                         fontSize = 15.sp,
                         fontWeight = FontWeight.Bold,
                          color= BLACK
                    )
                         }
                    )

        }
    ) {

        var tituloTarefa by remember {
            mutableStateOf("")
        }

        var descricaoTarefa by remember {
            mutableStateOf("")
        }

        var semPrioridadeTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeBaixaTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeMediaTarefa by remember {
            mutableStateOf(false)
        }

        var prioridadeAltaTarefa by remember {
            mutableStateOf(false)
        }

        Column(modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
        ) {
            CaixaDeTexto(
                value = tituloTarefa,
                onValueChange = {
                                tituloTarefa=it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label ="Título Tarefa" ,
                maxLines =1 ,
                keyboardType = KeyboardType.Text
            )
            CaixaDeTexto(
                value = descricaoTarefa,
                onValueChange = {
                    descricaoTarefa=it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label ="Descrição da Tarefa" ,
                maxLines =5 ,
                keyboardType = KeyboardType.Text
            )
            Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Nível de Prioridade")

                RadioButton(
                    selected = prioridadeBaixaTarefa,
                    onClick = { prioridadeBaixaTarefa=!prioridadeBaixaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_GREEN_DISABLED,
                        selectedColor = RADIO_BUTTON_GREEN_SELECTED
                    )
                )

                //RADIO MEDIA PRIORIDADE

                RadioButton(
                    selected = prioridadeMediaTarefa,
                    onClick = { prioridadeMediaTarefa=!prioridadeMediaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_YELLOW_DISABLED,
                        selectedColor = RADIO_BUTTON_YELLOW_SELECTED
                    )
                )

                //RADIO ALTA PRIORIDADE

                RadioButton(
                    selected = prioridadeAltaTarefa,
                    onClick = { prioridadeAltaTarefa=!prioridadeAltaTarefa
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = RADIO_BUTTON_RED_DISABLED,
                        selectedColor = RADIO_BUTTON_RED_SELECTED
                    )
                )

            }
            
            Botao(
                onClick = {
                    var mensagem = true

                          scope.launch(Dispatchers.IO){
                              if(tituloTarefa.isEmpty()){
                                  mensagem=false
                              }else if(tituloTarefa.isNotEmpty()&&descricaoTarefa.isNotEmpty()&& prioridadeBaixaTarefa){
                                  tarefasRepositorio.salvarTareda(tituloTarefa, descricaoTarefa,Constantes.PRIORIDADE_BAIXA)
                                  mensagem=true
                              }else if(tituloTarefa.isNotEmpty()&&descricaoTarefa.isNotEmpty()&& prioridadeMediaTarefa){
                                  tarefasRepositorio.salvarTareda(tituloTarefa, descricaoTarefa,Constantes.PRIORIDADE_MEDIA)
                                  mensagem=true
                              }else if(tituloTarefa.isNotEmpty()&&descricaoTarefa.isNotEmpty()&& prioridadeAltaTarefa){
                                  tarefasRepositorio.salvarTareda(tituloTarefa, descricaoTarefa,Constantes.PRIORIDADE_ALTA)
                                  mensagem=true
                              }else if(tituloTarefa.isNotEmpty()&&descricaoTarefa.isNotEmpty()&& semPrioridadeTarefa){
                                  tarefasRepositorio.salvarTareda(tituloTarefa, descricaoTarefa,Constantes.SEM_PRIORIDADE)
                                  mensagem=true
                              }
                              else if(tituloTarefa.isNotEmpty()&& prioridadeBaixaTarefa){
                                  tarefasRepositorio.salvarTareda(tituloTarefa, descricaoTarefa,Constantes.PRIORIDADE_BAIXA)
                                  mensagem=true
                              }
                              else if(tituloTarefa.isNotEmpty()&& prioridadeMediaTarefa){
                                  tarefasRepositorio.salvarTareda(tituloTarefa, descricaoTarefa,Constantes.PRIORIDADE_MEDIA)
                                  mensagem=true
                              }
                              else if(tituloTarefa.isNotEmpty()&& prioridadeAltaTarefa){
                                  tarefasRepositorio.salvarTareda(tituloTarefa, descricaoTarefa,Constantes.PRIORIDADE_ALTA)
                                  mensagem=true
                              }
                              else{
                                  tarefasRepositorio.salvarTareda(tituloTarefa, descricaoTarefa,Constantes.SEM_PRIORIDADE)
                                  mensagem=true
                              }



                          }
                        scope.launch(Dispatchers.Main) {
                            if(mensagem){
                                Toast.makeText(context, "Sucesso ao salvar Tarefa",
                                Toast.LENGTH_SHORT).show()
                                navController.popBackStack()
                            }else{
                                Toast.makeText(context, "Título da tarefa é obrigatório",
                                    Toast.LENGTH_SHORT).show()

                            }

                        }

                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp),
                texto = "Salvar"
            )


        }

    }

}