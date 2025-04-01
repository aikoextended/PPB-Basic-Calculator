package com.example.mycalculator

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycalculator.ui.theme.MyCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorUI()
        }
    }
}

@Composable
fun CalculatorUI() {
    var num1 by remember { mutableStateOf("0") }
    var num2 by remember { mutableStateOf("0") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 100.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(value = num1, onValueChange = { num1 = it }, label = { Text("Number 1") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = num2, onValueChange = { num2 = it }, label = { Text("Number 2") })
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {
                result = try { (num1.toInt() + num2.toInt()).toString() } catch (e: Exception) { "Error" }
            }) { Text(text = "Add") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                result = try { (num1.toInt() - num2.toInt()).toString() } catch (e: Exception) { "Error" }
            }) { Text(text = "Sub") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                result = try { (num1.toInt() * num2.toInt()).toString() } catch (e: Exception) { "Error" }
            }) { Text(text = "Mul") }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                result = try { (num1.toInt() / num2.toInt()).toString() } catch (e: Exception) { "Error" }
            }) { Text(text = "Div") }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Result:",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            color = MaterialTheme.colorScheme.onBackground
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = result,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
        )

    }
}
