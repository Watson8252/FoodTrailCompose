package com.sabredg.android.foodtrail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.sabredg.android.foodtrail.R
import com.sabredg.android.foodtrail.model.Choice
import com.sabredg.android.foodtrail.model.Chosen

@Composable
fun ChoicesPage(
    modifier: Modifier = Modifier
) {
    var chosen by rememberSaveable { mutableStateOf(Chosen()) }

    Column(
        modifier = modifier
    ) {
        ChoicesList(
            chosen = chosen,
            onEditChosen = { chosen = it },
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
        )

        ChosenList(
            chosen = chosen,
            modifier = modifier
                .fillMaxWidth()
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
        onEditChosen(chosen.addChoice(choice))
    }

    LazyColumn(
        modifier = modifier
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
    modifier: Modifier = Modifier
) {
    LazyRow(
        modifier = modifier
    ) {
        items(chosen.chosenList) {choice ->
            Text(text = choice.toString())
        }
    }
}

@Composable
private fun SubmitButton(
    modifier: Modifier = Modifier
) {
    Button(
        modifier = modifier
            .fillMaxWidth(),
        onClick = { /**TODO**/ }
    ) {
        Text(text = stringResource(R.string.submit_choices_button))
    }
}