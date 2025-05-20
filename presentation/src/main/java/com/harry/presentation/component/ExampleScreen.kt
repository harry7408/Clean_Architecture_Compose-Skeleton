package com.harry.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.harry.presentation.ui.theme.CleanArchitectureTheme
import com.harry.presentation.viewmodel.ExampleScreenViewModel

@Composable
fun ExampleScreen(
    modifier: Modifier,
    viewModel: ExampleScreenViewModel = hiltViewModel()
) {
    val id = viewModel.id.collectAsState()
    val name = viewModel.name.collectAsState()

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = id.value.toString()
        )

        Spacer(modifier = modifier.size(12.dp))

        Button(
            onClick = {
                viewModel.getId()
                viewModel.getName()
            }
        ) {
            Text(text = "값 가져오기")
        }

        Spacer(modifier = modifier.size(12.dp))

        Text(
            text = name.value
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExampleScreenPreview() {
    CleanArchitectureTheme {
        ExampleScreen(Modifier)
    }
}