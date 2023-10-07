package com.example.simple_calculator_app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.simple_calculator_app.ui.theme.Simple_Calculator_AppTheme
import android.widget.Spinner;
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.view.LayoutInflater
import android.content.Intent


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner_operations: Spinner = findViewById(R.id.spinner_operations)
        ArrayAdapter.createFromResource(
            this,
            R.array.buildings_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_operations.adapter = adapter
        }

        val submit_button = findViewById<Button>(R.id.submit_button);
        submit_button.setOnClickListener {
            var school_field = findViewById<TextView>(R.id.school_name).text.toString()
            var building_choice = findViewById<Spinner>(R.id.spinner_operations).selectedItem.toString()
            if (school_field == ""){
                Toast.makeText(this, "Enter a School!", Toast.LENGTH_LONG).show()
            }
            else if(school_field != "Boston University"){
                Toast.makeText(this, "Invalid School!", Toast.LENGTH_LONG).show()
            }
            else if(building_choice == "N/A"){
                Toast.makeText(this, "No Building Selected!", Toast.LENGTH_LONG).show()
            }
            else{
                var correct_toast = Toast.makeText(this,"Welcome Terrier!" , Toast.LENGTH_SHORT)
                correct_toast.show()
                val main_app = Intent(this, MainApp::class.java)
                startActivity(main_app)

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
    Simple_Calculator_AppTheme {
        Greeting("Android")
    }
}