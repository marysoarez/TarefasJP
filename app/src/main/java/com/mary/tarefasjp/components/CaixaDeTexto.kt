package com.mary.tarefasjp.components

import android.widget.NumberPicker.OnValueChangeListener
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.mary.tarefasjp.ui.theme.BLACK
import com.mary.tarefasjp.ui.theme.BLUE
import com.mary.tarefasjp.ui.theme.ShapeEditText
import com.mary.tarefasjp.ui.theme.WHITE

@Composable
fun CaixaDeTexto(
    value:String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label:String,
    maxLines: Int,
    keyboardType: KeyboardType
){

    OutlinedTextField(
        value =value ,
        onValueChange,
        modifier,
        label = {
            Text(text = label)
        },
        maxLines = maxLines,
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = BLACK,
            focusedBorderColor = BLUE,
            focusedLabelColor = BLUE,
            backgroundColor = WHITE,
            cursorColor = BLUE
        ),
        shape = ShapeEditText.small,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        )

    )

}
