package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.button.MaterialButton
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    private lateinit var textResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        textView = findViewById(R.id.textView)
        textResult = findViewById(R.id.textResult)
        val btnC: MaterialButton = findViewById(R.id.btnC)
        val btn1: MaterialButton = findViewById(R.id.btn1)
        val btn2: MaterialButton = findViewById(R.id.btn2)
        val btn3: MaterialButton = findViewById(R.id.btn3)
        val btn4: MaterialButton = findViewById(R.id.btn4)
        val btn5: MaterialButton = findViewById(R.id.btn5)
        val btn6: MaterialButton = findViewById(R.id.btn6)
        val btn7: MaterialButton = findViewById(R.id.btn7)
        val btn8: MaterialButton = findViewById(R.id.btn8)
        val btn9: MaterialButton = findViewById(R.id.btn9)
        val btn0: MaterialButton = findViewById(R.id.btn0)
        val btnConstructor1: MaterialButton = findViewById(R.id.btnConstructor1)
        val btnConstructor2: MaterialButton = findViewById(R.id.btnConstructor2)
        val btnSlash: MaterialButton = findViewById(R.id.btnSlash)
        val btnMinus: MaterialButton = findViewById(R.id.btnMinus)
        val btnPlus: MaterialButton = findViewById(R.id.btnPlus)
        val btnMultiple: MaterialButton = findViewById(R.id.btnMultiple)
        val btnDot: MaterialButton = findViewById(R.id.btnDot)
        val btnDelete: MaterialButton = findViewById(R.id.btnDelete)
        val btnResult: MaterialButton = findViewById(R.id.btnResult)




        btn0.setOnClickListener { appendOnExpression("0", true) }
        btn1.setOnClickListener { appendOnExpression("1", true) }
        btn2.setOnClickListener { appendOnExpression("2", true) }
        btn3.setOnClickListener { appendOnExpression("3", true) }
        btn4.setOnClickListener { appendOnExpression("4", true) }
        btn5.setOnClickListener { appendOnExpression("5", true) }
        btn6.setOnClickListener { appendOnExpression("6", true) }
        btn7.setOnClickListener { appendOnExpression("7", true) }
        btn8.setOnClickListener { appendOnExpression("8", true) }
        btn9.setOnClickListener { appendOnExpression("9", true) }
        btnDot.setOnClickListener {
            if (textView.text.isNotEmpty()){
                appendOnExpression(".", true)
            }
        }
        btnC.setOnClickListener {
            textResult.text = ""
            textView.text = ""
        }
        btnDelete.setOnClickListener {
            val string = textView.text.toString().trim()
            if (string.isNotEmpty()){
                textView.text = string.substring(0, string.length - 1)
            }
            textResult.text = ""
        }
        btnResult.setOnClickListener {
            try {
                val expression = ExpressionBuilder(textView.text.toString().trim()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if (result == longResult.toDouble()){
                    textResult.text = longResult.toString()
                }else {
                    textResult.text = longResult.toString()
                }
            }catch (e: Exception){
                Toast.makeText(this, "e", Toast.LENGTH_SHORT).show()
            }
        }
        btnConstructor1.setOnClickListener { appendOnExpression("(", false) }
        btnConstructor2.setOnClickListener { appendOnExpression(")", false) }
        btnPlus.setOnClickListener { appendOnExpression("+", false) }
        btnMinus.setOnClickListener { appendOnExpression("-", false) }
        btnMultiple.setOnClickListener { appendOnExpression("*", false) }
        btnSlash.setOnClickListener { appendOnExpression("/", false) }
    }









    private fun appendOnExpression(string: String, addBtn: Boolean) {
        if (textResult.text.isNotEmpty()){
            textView.text = ""
        }

        if (addBtn){
            textResult.text = ""
            textView.append(string)
        } else{
            textView.append(textResult.text.toString().trim())
            textView.append(string)
            textResult.text = ""
        }
    }
}