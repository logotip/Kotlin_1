package ru.m.kotlin_1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButtonClickListener()
        val data = Note("Прекрасный день", "Friday")
        Toast.makeText(this, "${data.note} - ${data.day}", Toast.LENGTH_LONG).show()
        println(SomeCopy.two)
        for(i in 1..10) {
            println("WHO are you???!")
        }
        for(i in 10 downTo 1 step 2) {
            println("Bye Bye! Again")
        }
    }
//    fun onMyButtonClick(view: View?) {
//        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show()
//    }

    private fun ButtonClickListener(){
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            val textView = findViewById<TextView>(R.id.textView)
            textView.setText("Ну и пока, что ль!")
        })
    }




}


