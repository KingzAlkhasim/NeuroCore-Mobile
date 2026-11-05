package name.kingxtech.neurocore

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Bolt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val Night = Color(0xFF090B12)
private val Panel = Color(0xFF141827)
private val Violet = Color(0xFF8B5CF6)
private val Cyan = Color(0xFF38BDF8)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NeuroCoreApp() }
    }
}

@Composable
private fun NeuroCoreApp() {
    var input by remember { mutableStateOf("") }
    var messages by remember { mutableStateOf(listOf("assistant" to "Welcome to NeuroCore Mobile 👋\n\nYour private, on-device AI workspace. The chat UI is ready; local Qwen inference is the next milestone.")) }

    MaterialTheme(colorScheme = darkColorScheme(
        background = Night, surface = Panel, primary = Violet,
        secondary = Cyan, onBackground = Color(0xFFE9EAF2), onSurface = Color(0xFFE9EAF2)
    )) {
        Scaffold(containerColor = Night) { padding ->
            Column(Modifier.fillMaxSize().padding(padding)) {
                Row(
                    Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(Modifier.size(42.dp).background(Brush.linearGradient(listOf(Violet, Cyan)), CircleShape), Alignment.Center) {
                        Icon(Icons.Default.Bolt, contentDescription = null, tint = Color.White)
                    }
                    Spacer(Modifier.width(12.dp))
                    Column {
                        Text("NeuroCore", fontSize = 21.sp, color = Color.White)
                        Text("MOBILE  •  OFFLINE AI", fontSize = 10.sp, color = Cyan, letterSpacing = 2.sp)
                    }
                    Spacer(Modifier.weight(1f))
                    Surface(color = Color(0xFF17291F), shape = RoundedCornerShape(50)) {
                        Text("●  LOCAL", Modifier.padding(horizontal = 12.dp, vertical = 7.dp), color = Color(0xFF76E3A4), fontSize = 11.sp)
                    }
                }
                HorizontalDivider(color = Color(0xFF22283A))
                LazyColumn(Modifier.weight(1f).fillMaxWidth(), contentPadding = PaddingValues(18.dp), verticalArrangement = Arrangement.spacedBy(14.dp)) {
                    item {
                        Text("YOUR SPACE", color = Color(0xFF737D98), fontSize = 10.sp, letterSpacing = 2.sp)
                        Spacer(Modifier.height(10.dp))
                    }
                    items(messages) { (role, text) ->
                        val user = role == "user"
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = if (user) Arrangement.End else Arrangement.Start) {
                            Surface(
                                color = if (user) Color(0xFF292044) else Panel,
                                shape = RoundedCornerShape(18.dp, 18.dp, 18.dp, if (user) 18.dp else 5.dp),
                                modifier = Modifier.widthIn(max = 310.dp)
                            ) {
                                Text(text, Modifier.padding(16.dp), color = Color(0xFFE9EAF2), lineHeight = 22.sp)
                            }
                        }
                    }
                }
                Column(Modifier.fillMaxWidth().padding(horizontal = 16.dp, vertical = 12.dp)) {
                    Text("MODEL  •  QWEN 1.5B (COMING NEXT)", color = Color(0xFF77819B), fontSize = 10.sp, letterSpacing = 1.sp)
                    Spacer(Modifier.height(10.dp))
                    Row(
                        Modifier.fillMaxWidth().background(Panel, RoundedCornerShape(24.dp)).padding(7.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = input, onValueChange = { input = it },
                            placeholder = { Text("Message NeuroCore…", color = Color(0xFF737D98)) },
                            modifier = Modifier.weight(1f),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = Color.Transparent, unfocusedContainerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Transparent, unfocusedIndicatorColor = Color.Transparent
                            )
                        )
                        IconButton(onClick = {
                            if (input.isNotBlank()) {
                                messages = messages + ("user" to input.trim())
                                input = ""
                            }
                        }, modifier = Modifier.background(Brush.linearGradient(listOf(Violet, Cyan)), CircleShape)) {
                            Icon(Icons.Default.Send, contentDescription = "Send", tint = Color.White)
                        }
                    }
                }
            }
        }
    }
}
