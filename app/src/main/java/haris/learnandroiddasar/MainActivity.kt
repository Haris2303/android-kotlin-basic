package haris.learnandroiddasar

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import haris.learnandroiddasar.ui.theme.LearnAndroidBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hello_world)

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val sayHelloButton: Button = findViewById(R.id.sayHelloButton)
        val sayHelloTextView: TextView = findViewById(R.id.sayHelloTextView)

        sayHelloTextView.text = resources.getText(R.string.app_name)

        sayHelloButton.setOnClickListener {

//            Get resource values strings
            Log.d("BASIC", "This is debug log")
            Log.i("BASIC", "This is info log")
            Log.w("BASIC", "This is warning log")
            Log.e("BASIC", "This is error log")

            // Get resource values other
            Log.i("VALUE_RESOURCE", resources.getInteger(R.integer.maxPage).toString())
            Log.i("VALUE_RESOURCE", resources.getIntArray(R.array.numbers).joinToString(","))
            Log.i("VALUE_RESOURCE", resources.getBoolean(R.bool.isProductionMode).toString())
            Log.i("VALUE_RESOURCE", resources.getColor(R.color.background, theme).toString())

            sayHelloTextView.setBackgroundColor(resources.getColor(R.color.background, theme))

            val name = nameEditText.text.toString()
            sayHelloTextView.text = resources.getString(R.string.sayHelloTextView, name)

            resources.getStringArray(R.array.names).forEach {
                Log.i("ARRAY_NAMES", it)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LearnAndroidBasicTheme {
        Greeting("Haris")
    }
}