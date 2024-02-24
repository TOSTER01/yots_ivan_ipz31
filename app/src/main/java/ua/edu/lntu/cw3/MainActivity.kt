package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ua.edu.lntu.cw3.ui.theme.IPZ_KR_3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_KR_3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyScreen()
                }
            }
        }
    }
}

data class ListItem(val title: String, val subtitle: String)

val twoDimensionalItems = listOf(
    listOf(
        ListItem("Заголовок 1", "Підзаголовок 1"),
        ListItem("Заголовок 2", "Підзаголовок 2"),
        ListItem("Заголовок 3", "Підзаголовок 3")
    ),
    listOf(
        ListItem("Заголовок 4", "Підзаголовок 4"),
        ListItem("Заголовок 5", "Підзаголовок 5"),
        ListItem("Заголовок 6", "Підзаголовок 6"),
        ListItem("Заголовок 7", "Підзаголовок 7"),
        ListItem("Заголовок 8", "Підзаголовок 8"),

        )
)

@Composable
fun ListItemView(item: ListItem) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(text = item.title, fontWeight = FontWeight.Bold, color = Color.Gray)
        Text(text = item.subtitle, color = Color.Blue)
    }
}


@Composable
fun ListItemViewSecond(item: ListItem) {
    Column(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth()
    ) {
        Text(text = item.title, fontWeight = FontWeight.W900, color = Color.DarkGray)
        Text(text = item.subtitle, color = Color.Green)
    }
}

@Composable
fun MyScreen() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(modifier = Modifier.weight(1f)) {
            twoDimensionalItems[0].forEach { item ->
                ListItemView(item = item)
                Divider()
            }
        }
        Column(modifier = Modifier.weight(1f)) {
            twoDimensionalItems[1].forEach { item ->
                ListItemViewSecond(item = item)
                Divider()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IPZ_KR_3Theme {
        MyScreen()
    }
}
