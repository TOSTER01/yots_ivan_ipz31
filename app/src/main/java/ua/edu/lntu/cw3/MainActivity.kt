package ua.edu.lntu.cw3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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

                }
            }
        }
    }
}

data class ListItem(val title: String, val subtitle: String)

@Composable
fun ListItemView(item: ListItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = item.title, fontWeight = FontWeight.Bold)
            Text(text = item.subtitle, color = Color.Gray)
        }
        Column {
            Text(text = item.title, fontWeight = FontWeight.Bold)
            Text(text = item.subtitle, color = Color.Gray)
        }
    }
}

@Composable
fun VerticalScrollableList(items: List<ListItem>) {
    LazyColumn {
        items(items.size) { index ->
            ListItemView(item = items[index])
            Divider()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MyScreen() {
    val items = listOf(
        ListItem("Елемент 1", "Опис елементу 1"),
        ListItem("Елемент 2", "Опис елементу 2"),
    )

    VerticalScrollableList(items = items)
}