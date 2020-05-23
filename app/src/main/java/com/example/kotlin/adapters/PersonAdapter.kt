package com.example.kotlin.adapters

import android.app.Person
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.kotlin.R
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.list_view_person.view.*

class PersonAdapter(val context:Context, var list : List<com.example.kotlin.models.Person>) : BaseAdapter() {

    private val mInflator : LayoutInflater = LayoutInflater.from(context)

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {


        val view : View
        val vh : PersonViewHolder

        if (convertView == null) {
            view = mInflator.inflate(R.layout.list_view_person, parent, false)
            vh = PersonViewHolder(view)
            view.tag = vh
        } else {
            view = convertView
            vh = view.tag as PersonViewHolder
        }

        val fullName = "${list[position].nombre}"
        vh.fullName.text = fullName
        vh.age.text = list[position].apellid

        return view
    }
}


private class PersonViewHolder(view:View) {
    val fullName : TextView = view.tv_nombre
    val age : TextView = view.tv_apellido
}