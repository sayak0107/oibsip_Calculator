package com.example.simple_calculator


import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity()  {
    private lateinit var buttonAdd: Button
    private lateinit var buttonSub: Button
    private lateinit var buttonMul: Button
    private lateinit var buttonDiv: Button
    private lateinit var editTextN1: EditText
    private lateinit var editTextN2: EditText
    private lateinit var textView: TextView

//Change 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAdd = findViewById(R.id.btn_add)
        buttonSub = findViewById(R.id.btn_sub)
        buttonMul = findViewById(R.id.btn_mul)
        buttonDiv = findViewById(R.id.btn_divide)
        editTextN1 = findViewById(R.id.number1)
        editTextN2 = findViewById(R.id.number2)
        textView = findViewById(R.id.answer)

        buttonAdd.setOnClickListener {
            performOperation("+")
        }
        buttonSub.setOnClickListener {
            performOperation("-")
        }
        buttonMul.setOnClickListener {
            performOperation("*")
        }
        buttonDiv.setOnClickListener {
            performOperation("/")
        }
    }

    @SuppressLint("SetTextI18n")
    private fun performOperation(operator: String) {
        val num1 = editTextN1.text.toString().toDoubleOrNull()
        val num2 = editTextN2.text.toString().toDoubleOrNull()

        if((num1 == null )|| (num2 == null)){
              Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show()
              return
          }

        val answer = when (operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> {
                if (num2 != 0.0) {
                    num1 / num2
                } else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            else -> 0.0
        }
        textView.text = "Answer = $answer"
//        textView.text = answer.toString()
    }
}