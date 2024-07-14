package com.example.lesktlrelativelayouttogglebuttonscrollview

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain: Toolbar
    private lateinit var loadTextTV: TextView
    private lateinit var loadBTN: Button

    private fun findId() {
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Электронная книга"
        toolbarMain.subtitle = "версия 1.0"
        loadTextTV = findViewById(R.id.loadTextTV)
        loadBTN = findViewById(R.id.loadBTN)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        findId()

        loadBTN.setOnClickListener{
            loadTextTV.text = loadBook(Database().text).joinToString(separator = " ")
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
fun loadBook(text: String): List<String> {
    return text.trim().splitToSequence(' ').filter { it.isNotEmpty() }.toList()
}