package com.gb.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gb.presentation.ui.theme.WeatherTheme
import com.gb.presentation.viewmodels.RealTimeViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val viewModel: RealTimeViewModel by viewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShowRealtimeWeather()
                }
            }
        }
    }

    @Preview
    @Composable
    private fun ShowRealtimeWeather() {
        MainWeatherView(resource = R.drawable.sun, temperature = 22.55f, location = "London")
    }
    @Composable
    private fun MainWeatherView(resource: Int, temperature: Float, location: String) {
        val boxModifier = Modifier
            .padding(25.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Min)
        Column {
            Card(shape = CardDefaults.elevatedShape, colors = CardDefaults.cardColors(MaterialTheme.colorScheme.error)) {
                Row (verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.Center, modifier = boxModifier) {
                    Image(painter = painterResource(id = resource), contentDescription = "Realtime Weather")
                    Column {
                        Text(text = location)
                        Text(text = temperature.toString())
                    }
                }
            }
            HorizontalListView()
            Button(onClick = {viewModel.getRealtimeWeather()}) {
                Text(text = "kliki")
            }
        }
    }

    @Composable
    fun HorizontalListView() {
        val items = (1..50).toList()

        LazyRow(contentPadding = PaddingValues(horizontal = 10.dp, vertical = 20.dp)) {
            items(items) { item ->
                Text(
                    text = "Item $item",
                    modifier = Modifier
                        .padding(end = 10.dp)
                        .background(color = Color.LightGray)
                        .padding(16.dp)
                )
            }
        }
    }
}








