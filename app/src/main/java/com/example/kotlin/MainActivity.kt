package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.kotlin.models.PersonComplete
import kotlinx.android.synthetic.main.activity_main.*
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity(), View.OnLongClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn1 = findViewById<Button>(R.id.btn1)
        val btn3 = findViewById<Button>(R.id.btn3)

        btn1.setOnClickListener { btn1Listener() }
        btn3.setOnClickListener { btn3Listener() }
        btn4.setOnClickListener { btn4Listener() }
        btn6.setOnClickListener { btn6Listener() }
        btn7.setOnClickListener { btn7Listener() }
        btn8.setOnClickListener { btn8Listener() }
        btn3.setOnLongClickListener(this)

    }

    fun btn6Listener() {
        val intent = Intent(this, IntentExtraActivity::class.java)
        intent.putExtra("nombre", "Carlos")
        intent.putExtra("apellido", "Carlos")
        intent.putExtra("edad", 30)
        intent.putExtra("bool", true)


        startActivity(intent)
    }

    fun btn7Listener() {
        val intent = Intent(this, IntentExtraActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        startActivity(intent)
        finish()
    }

    fun btn8Listener() {
        val person = PersonComplete("Lidia", "Garrido", 29, false)
        val intent = Intent(this, IntentExtraActivity::class.java)
        intent.putExtra("persona", person)
        startActivity(intent)
    }

    fun btn4Listener(){
        startActivity(Intent(this, ListView::class.java))
    }

    fun btn1Listener() {
        startActivity(Intent(this, IntentActivity::class.java))
    }

    fun btn3Listener() {
        startActivity(Intent(this, PicassoExample::class.java))
    }

    fun xmlClic(view : View) {
        toast("xmlClic")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        toast("onBackPressed")
    }

    private fun toast(text : String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }

    override fun onLongClick(v: View?): Boolean {

        when (v!!.id) {
            R.id.btn3 -> toast("btn3 Long Pressed")
        }

        return true
    }
}
