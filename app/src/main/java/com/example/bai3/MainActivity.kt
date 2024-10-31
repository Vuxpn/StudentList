package com.example.bai3

import StudentAdapter
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var etSearch: EditText
    private lateinit var recyclerView: RecyclerView
    private lateinit var studentAdapter: StudentAdapter
    private val studentList = listOf(
        Student("Phan Nguyen Vu", "20210952"),
        Student("Phan Nguyen Vu", "20220952"),
        Student("Phan Nguyen Vu", "20230952"),
        Student("Phan Nguyen Vu", "20240952"),
        Student("Phan Nguyen Vu", "20250952")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etSearch = findViewById(R.id.etSearch)
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        studentAdapter = StudentAdapter(studentList)
        recyclerView.adapter = studentAdapter

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString().trim()
                if (query.length > 2) {
                    val filteredList = studentList.filter {
                        it.name.contains(query, ignoreCase = true) || it.mssv.contains(query, ignoreCase = true)
                    }
                    studentAdapter.updateList(filteredList)
                } else {
                    studentAdapter.updateList(studentList)
                }
            }

            override fun afterTextChanged(s: Editable?) {}
        })
    }
}