package com.example.pokedexcompose.ui.presentation.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexcompose.R

@Composable
fun PokemonApiErrorScreen(onRetry: () -> Unit) {
    PokemonApiError(onRetry)
}

@Composable
fun PokemonApiError(onRetry: () -> Unit) {

    Scaffold {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red)
                .consumeWindowInsets(it),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Oh não! Um Pokémon causou interferência!",
                fontSize = 20.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(16.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Pikachu triste",
                modifier = Modifier.size(150.dp),
                contentScale = ContentScale.Fit
            )

            Button(
                onClick = onRetry,
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = "Tentar Novamente", color = Color.Black)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPokemonApiErrorScreen() {
    PokemonApiErrorScreen(onRetry = {})
}
