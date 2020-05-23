package com.example.kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.adapters.PersonAdapter
import com.example.kotlin.models.Person
import kotlinx.android.synthetic.main.activity_list_view.*

class ListView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        listView.adapter = PersonAdapter(this, getPerson())
    }


    private fun getPerson() : List<Person> {

        return listOf<Person>(
            Person("carlos", "30"),
            Person("Alvaro", "25"),
            Person("Roberto", "30"),
            Person("carlos", "30"),
            Person("Alvaro", "25"),
            Person("Roberto", "30"),
            Person("carlos", "30"),
            Person("Alvaro", "25"),
            Person("Roberto", "30"),
            Person("carlos", "30"),
            Person("Alvaro", "25"),
            Person("Roberto", "30"),
            Person("carlos", "30"),
            Person("Alvaro", "25"),
            Person("Roberto", "30")
        )
    }
}
