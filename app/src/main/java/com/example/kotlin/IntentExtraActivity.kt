package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlin.models.PersonComplete
import kotlinx.android.synthetic.main.activity_intent_extra.*

class IntentExtraActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extra)

        button.setOnClickListener { startActivity(Intent(this, MainActivity::class.java)) }
        getIntentExtra()
        getIntentObject()
    }

    private fun getIntentObject() {
        val people : PersonComplete? = intent.getSerializableExtra("persona") as? PersonComplete

        if (people != null) {
            textView.text = people.nombre
            textView2.text = people.apellid
            textView3.text = people.edad.toString()
            checkBox.isChecked = people.bool
        }
    }

    private fun getIntentExtra() {
        val nombre : String? = intent.getStringExtra("nombre")
        val ape : String? = intent.getStringExtra("apellido")
        val edad : Int = intent.getIntExtra("edad", -1)
        val bool : Boolean = intent.getBooleanExtra("bool", false)


        if (nombre != null && ape != null && edad >= 0) {
            textView.text = nombre
            textView2.text = ape
            textView3.text = edad.toString()
            checkBox.isChecked = bool
        }
    }
}
