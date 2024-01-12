package com.example.finalproject

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanPembeli(
    onSubmitButtonClick: (MutableList<String>) -> Unit,
    onCancelButtonClick: () -> Unit,
) {
    var namaTxt by rememberSaveable { mutableStateOf("") }
    var alamatTxt by rememberSaveable { mutableStateOf("") }
    var teleponTxt by rememberSaveable { mutableStateOf("") }
    var ListDataTxt: MutableList<String> = mutableListOf(namaTxt, alamatTxt, teleponTxt)

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Data Pelanggan",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(value = namaTxt,
            onValueChange = { namaTxt = it },
            label = { Text(text = "Nama") })

        OutlinedTextField(value = alamatTxt,
            onValueChange = { alamatTxt = it },
            label = { Text(text = "Alamat") })

        OutlinedTextField(value = teleponTxt,
            onValueChange = { teleponTxt = it },
            label = { Text(text = "Telepon") },
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f, false), horizontalArrangement = Arrangement.Center
        ) {
            OutlinedButton(
                onClick = onCancelButtonClick, modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(id = R.string.cancel))
            }

            Spacer(modifier = Modifier.width(dimensionResource(R.dimen.padding_medium)))

            Button(
                onClick = { onSubmitButtonClick(ListDataTxt) },
                enabled = namaTxt.isNotEmpty() && alamatTxt.isNotEmpty() && teleponTxt.isNotEmpty(),
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(id = R.string.btn_selanjutnya))
            }
        }
    }
}


