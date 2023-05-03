package com.mary.tarefasjp.components

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mary.tarefasjp.ui.theme.BLUE
import com.mary.tarefasjp.ui.theme.WHITE


@Composable

fun Botao(
    onClick:()-> Unit,
    modifier: Modifier,
    texto: String

){
    Button(
        onClick,
        modifier,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = BLUE,
            contentColor = WHITE)
    ) {
        Text(text = texto, fontWeight = FontWeight.Bold, fontSize = 18.sp)

    }
}
