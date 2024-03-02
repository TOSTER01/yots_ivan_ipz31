import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ua.edu.lntu.cw4.ui.theme.IPZ_CR_4Theme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            IPZ_CR_4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = { Text(text = "My App") }
                            )
                        }
                    ) {
                        MyScreen(navController)
                    }
                }
            }
        }
    }
}

@Composable
fun MyScreen(navController: NavController) {
    var selectedItem by rememberSaveable { mutableStateOf<Int?>(null) }

    if (selectedItem != null) {
        Screen2(selectedItem!!, onBack = { selectedItem = null })
    } else {
        MyList(navController, onItemClick = { index ->
            selectedItem = index
        })
    }
}

@Composable
fun MyList(navController: NavController, onItemClick: (Int) -> Unit) {
    val items = listOf("Елемент 1", "Елемент 2", "Елемент 3", "Елемент 4", "Елемент 5")

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(items) { item ->
            ListItem(
                text = item,
                onItemClick = onItemClick,
                itemIndex = Character.getNumericValue(item.last())
            )
        }
    }
}

@Composable
fun ListItem(text: String, onItemClick: (Int) -> Unit, itemIndex: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onItemClick(itemIndex) }
    ) {
        Text(text = text, fontSize = 20.sp, modifier = Modifier.padding(8.dp))
    }
}

@Composable
fun Screen2(itemIndex: Int, onBack: () -> Unit) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Елемент номер $itemIndex", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = onBack) {
                Text("Back")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    IPZ_CR_4Theme {
        MyScreen(navController = rememberNavController())
    }
}
