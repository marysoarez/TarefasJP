package com.mary.tarefasjp.repositorio

import com.mary.tarefasjp.datasource.DataSource
import com.mary.tarefasjp.model.Tarefa
import kotlinx.coroutines.flow.Flow

class TarefasRepositorio{


    private val dataSource= DataSource()

    fun salvarTareda(
        tarefa:String,
        descricao:String,
        prioridade:Int
    ){
        dataSource.salvarTarefa(tarefa, descricao, prioridade)

    }

    fun recuperarTarefas(): Flow<MutableList<Tarefa>>{
        return dataSource.recuperarTarefas()
    }

    fun deletarTarefas(tarefa: String){
        dataSource.deletarTarefa(tarefa)
    }
}