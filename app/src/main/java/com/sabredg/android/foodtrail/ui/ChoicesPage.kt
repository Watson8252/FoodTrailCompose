package com.sabredg.android.foodtrail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sabredg.android.foodtrail.R
import com.sabredg.android.foodtrail.model.Choice

@Preview
@Composable
private fun ChoicesPagePreview() {
    ChoicesPage()
}

@Composable
fun ChoicesPage(
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {
        ChoicesList(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        )
        SubmitButton()
    }
}

@Composable
private fun ChoicesList(
    modifier: Modifier = Modifier.Companion
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(Choice.entries.toTypedArray()) { choice ->
            Button(
                onClick = {}
            ) {
                Text(text = choice.toString())
            }
        }
    }
}

@Composable
private fun SubmitButton(
    modifier: Modifier = Modifier.Companion
) {
    TextButton(
        modifier = modifier,
        onClick = { /**TODO**/ }
    ) {
        Text(text = stringResource(R.string.submit_choices_button))
    }
}

@Composable
private fun ComposableButton(

    modifier: Modifier = Modifier
) {}