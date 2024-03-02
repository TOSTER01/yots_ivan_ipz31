import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ua.edu.lntu.cw4.ui.theme.IPZ_CR_4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CR_4Theme {
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

@Composable
fun MyScreen() {
    val items = listOf("Елемент 1", "Елемент 2", "Елемент 3", "Елемент 4", "Елемент 5")
    val selectedItem = remember { mutableStateOf(-1) }

    if (selectedItem.value != -1) {
        Screen2(selectedItem.value)
    } else {
        MyList(items) { index ->
            selectedItem.value = index
        }
    }
}

@Composable
fun MyList(items: List<String>, onItemClick: (Int) -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        itemsIndexed(items) { index, item ->
            ListItem(text = item, onItemClick = { onItemClick(index) })
        }
    }
}

@Composable
fun ListItem(text: String, onItemClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onItemClick)
    ) {
        Text(text = text, fontSize = 20.sp)
    }
}

@Composable
fun Screen2(itemIndex: Int) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Елемент $itemIndex", fontSize = 24.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyScreen()
}
