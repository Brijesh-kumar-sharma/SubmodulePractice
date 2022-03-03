package com.example.additionsubmodule

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var etNumber: EditText
    var job: Job? = null
    private val additionImplementor = AdditionImplementor()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tv_result)
        etNumber = findViewById(R.id.et_number)

        etNumber.doOnTextChanged { text, start, count, after ->
            job?.cancel()
            job = GlobalScope.launch(Dispatchers.Main) {
                if (text != null) {
                    if(text.isNotEmpty())
                    {
                        callFunction(text)
                    }

                }
            }
        }

    }

    private fun callFunction(text: CharSequence?) {
        val result = additionImplementor.getNumber(
            text.toString().lowercase(Locale.getDefault()).trim()
        )
        tvResult.text = result
    }
}