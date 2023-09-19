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


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spinner_operations: Spinner = findViewById(R.id.spinner_operations)
        ArrayAdapter.createFromResource(
            this,
            R.array.operations_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner_operations.adapter = adapter
        }

        val calculate_button = findViewById<Button>(R.id.calculate);
        calculate_button.setOnClickListener {
            makeCalculations()

        }
    }
      fun makeCalculations() {
          var b=true;
          if(findViewById<TextView>(R.id.operand_one).text.isEmpty()){
              findViewById<TextView>(R.id.output).text = "Fields are empty!"
          b=false
          }
          if(findViewById<TextView>(R.id.operand_two).text.isEmpty()){
              findViewById<TextView>(R.id.output).text = "Fields are empty!"
              b=false;
          }
          if(b==true){
          var number1: Float = findViewById<TextView>(R.id.operand_one).text.toString().toFloat()
          var number2: Float = findViewById<TextView>(R.id.operand_two).text.toString().toFloat()
          var result: Float = 0.0F
          var operationchoice: String = findViewById<Spinner>(R.id.spinner_operations).selectedItem.toString()




          when(operationchoice) {
              "+" -> {
                  result = number1 + number2
                  findViewById<TextView>(R.id.output).text = result.toString()
              }
              "-" -> {
                  result = number1 - number2
                  findViewById<TextView>(R.id.output).text = result.toString()
              }
              "*" -> {
                  result = number1 * number2
                  findViewById<TextView>(R.id.output).text = result.toString()
              }
              "/" -> {
                  if(number2 != 0F){
                  result = number1 / number2
                  findViewById<TextView>(R.id.output).text = result.toString()
              }
                  else{
                      findViewById<TextView>(R.id.output).text = "Divide by 0"
                  }

              }
              "%" -> {
                  result = number1 % number2
                  findViewById<TextView>(R.id.output).text = result.toString()
              }
              else -> {result = 5F
              findViewById<TextView>(R.id.output).text = result.toString()
          }}
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