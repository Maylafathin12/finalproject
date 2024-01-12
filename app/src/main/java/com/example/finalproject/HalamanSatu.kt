package com.example.finalproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.finalproject.ui.theme.FinalprojectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanSatu(
    pilihanMenu: List<String>,
    onSelectionChanged: (String) -> Unit,
    onNextButtonClicked: (Int) -> Unit,
    onCancelButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    var menuYgDipilih by rememberSaveable { mutableStateOf("") }
    var textJmlBeli by remember { mutableStateOf("") }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(dimensionResource(R.dimen.padding_medium))
        ) {
            pilihanMenu.forEach { item ->
                Row(
                    modifier = Modifier
                        .selectable(
                            selected = menuYgDipilih == item,
                            onClick = {
                                menuYgDipilih = item
                                onSelectionChanged(item)
                            }
                        ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = menuYgDipilih == item,
                        onClick = {
                            menuYgDipilih = item
                            onSelectionChanged(item)
                        }
                    )
                    Text(item)
                }
            }

            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium))
            ) {
                OutlinedTextField(
                    value = textJmlBeli,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = dimensionResource(R.dimen.padding_medium)),
                    label = { Text(text = "Jumlah Order") },
                    onValueChange = {
                        textJmlBeli = it
                    }
                )
            }

            Divider(
                thickness = dimensionResource(R.dimen.thickness_divider),
                modifier = Modifier.padding(bottom = dimensionResource(R.dimen.padding_medium))
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_medium))
                    .weight(1f, false),
                horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
                verticalAlignment = Alignment.Bottom
            ) {
                OutlinedButton(
                    modifier = Modifier.weight(1f),
                    onClick = onCancelButtonClicked
                ) {
                    Text(stringResource(R.string.cancel))
                }

                Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))

                Button(
                    modifier = Modifier.weight(1f),
                    enabled = textJmlBeli.isNotEmpty(),
                    onClick = {
                        onNextButtonClicked(textJmlBeli.toInt())
                    }
                ) {
                    Text(stringResource(R.string.next))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHalamanSatu() {
    FinalprojectTheme {
        HalamanSatu(
            pilihanMenu = listOf("Menu 1", "Menu 2", "Menu 3"),
            onSelectionChanged = { /* Handle selection changed */ },
            onNextButtonClicked = { /* Handle next button clicked */ },
            onCancelButtonClicked = { /* Handle cancel button clicked */ }
        )
    }
}

