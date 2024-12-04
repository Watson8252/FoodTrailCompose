package com.sabredg.android.foodtrail.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sabredg.android.foodtrail.R
import com.sabredg.android.foodtrail.model.Choice
import com.sabredg.android.foodtrail.model.Chosen

@Preview
@Composable
private fun ChoicesPagePreview() {
    ChoicesPage()
}

@Composable
fun ChoicesPage(
    modifier: Modifier = Modifier.Companion
) {
    Column(
        modifier = modifier
    ) {
        SubmitButton()
    }
}

@Composable
private fun ChoicesList(
    chosen: Chosen,
    modifier: Modifier = Modifier.Companion
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(Choice.values().toList()) { choice ->
            TextButton(
                onClick = {}
            ) {
                Text(choice.toString())
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