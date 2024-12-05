package com.sabredg.android.foodtrail.ui

import android.widget.GridView
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sabredg.android.foodtrail.R
import com.sabredg.android.foodtrail.model.Choice
import com.sabredg.android.foodtrail.model.Chosen

@Preview
@Composable
fun ChoicesPage(
    modifier: Modifier = Modifier
) {
    var chosen by rememberSaveable { mutableStateOf(Chosen()) }

    Column(
        modifier = modifier.fillMaxSize()
    ) {
        ChoicesList(
            chosen = chosen,
            onEditChosen = { chosen = it },
            modifier = modifier
                .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                .fillMaxWidth()
        )

        ChosenList(
            chosen = chosen,
            onEditChosen = { chosen = it },
            modifier = modifier
        )

        SubmitButton()
    }
}

@Composable
private fun ChoicesList(
    chosen: Chosen,
    onEditChosen: (Chosen) -> Unit,
    modifier: Modifier = Modifier
) {

    var choiceAdded by rememberSaveable { mutableStateOf<Choice?>(null) }

    choiceAdded?.let { choice ->
        if (chosen.chosenList.contains(choice).not() && chosen.chosenList.size <3){
            onEditChosen(chosen.addChoice(choice))
        }
    }
    Text(
        text = "Choose From:",
        modifier = modifier.padding(top = 24.dp)
    )

    LazyColumn (
        modifier = modifier
            .border(
                width = 2.dp,
                color = Color.DarkGray,
                shape = RoundedCornerShape(16.dp)
            )
            .background(
                Color.LightGray,
                shape = RoundedCornerShape(16.dp)
            )
            .height(400.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        items(Choice.entries.toTypedArray()) { choice ->
            Button(
                modifier = modifier,
                onClick = { choiceAdded = choice }
            ) {
                Text(text = choice.toString())
            }
        }
    }
}

@Composable
private fun ChosenList(
    chosen: Chosen,
    onEditChosen: (Chosen) -> Unit,
    modifier: Modifier = Modifier
) {
    var choiceRemoved by rememberSaveable { mutableStateOf<Choice?>(null) }

    choiceRemoved?.let { choice ->
        if (chosen.chosenList.contains(choice)){
            onEditChosen(chosen.removeChoice(choice))
        }
        choiceRemoved = null
    }

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center
    ) {
        items(chosen.chosenList) {choice ->
            Button(
                modifier = Modifier
                    .padding(4.dp),
                onClick = { choiceRemoved = choice }
            ){
                Text(text = choice.toString())
            }
        }
    }
}

@Composable
private fun SubmitButton(
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier,
        onClick = { /**TODO**/ }
    ) {
        Text(text = stringResource(R.string.submit_choices_button))
    }
}