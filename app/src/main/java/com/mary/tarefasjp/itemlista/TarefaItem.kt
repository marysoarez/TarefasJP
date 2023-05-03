package com.mary.tarefasjp.itemlista

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.mary.tarefasjp.R
import com.mary.tarefasjp.model.Tarefa
import com.mary.tarefasjp.ui.theme.RADIO_BUTTON_GREEN_SELECTED
import com.mary.tarefasjp.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.mary.tarefasjp.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.mary.tarefasjp.ui.theme.WHITE

@Composable
fun TarefaItem(
    position:Int,
    listaTarefas: MutableList<Tarefa>
){
    val tituloTarefa= listaTarefas[position].tarefa
    val descricaoTarefa = listaTarefas[position].descricao
    val prioridade = listaTarefas[position].prioridade

    var nivelDePrioridade: String=when(prioridade){
        0-> {
            "Sem Prioridade"
        }
        1->{
            "PRIORIDADE BAIXA"
        }
        2->{
            "prioridade média"
        }
        else -> {
            "prioridade alta"
        }
    }

    val color= when(prioridade){
        0->{
            Color.Black
        }
        1->{
            RADIO_BUTTON_GREEN_SELECTED
        }
        2->{
            RADIO_BUTTON_YELLOW_SELECTED
        }
        else->{
            RADIO_BUTTON_RED_SELECTED
        }
    }

    Card(
        backgroundColor = WHITE,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),

    ) {
        ConstraintLayout (
            modifier = Modifier.padding(20.dp)
                ){
            val(txtTitulo, txtDescricao, cardPrioridade, txtPrioridade, btDeletar) = createRefs()

            Text(text = tituloTarefa.toString(),
            modifier = Modifier.constrainAs(txtTitulo){
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)
            })

            Text(text = descricaoTarefa.toString(),
                modifier = Modifier.constrainAs(txtDescricao){
                    top.linkTo(txtTitulo.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                })

            Text(text = nivelDePrioridade,
                modifier = Modifier.constrainAs(txtPrioridade){
                    top.linkTo(txtDescricao.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                })
            Card(backgroundColor = color,
                modifier = Modifier
                    .size(15.dp)
                    .constrainAs(cardPrioridade) {
                        top.linkTo(txtDescricao.bottom, margin = 10.dp)
                        start.linkTo(txtPrioridade.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)

                    }) {

            }

            IconButton(
                onClick = {
            /*TODO*/
            },
            modifier = Modifier.constrainAs(btDeletar){
                top.linkTo(txtDescricao.bottom, margin = 10.dp)
                start.linkTo(cardPrioridade.end, margin = 30.dp)
                end.linkTo(parent.end, margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)

            }
                ) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                    contentDescription = null )
             }
            
        }


    }
}
