package com.example.kotlin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_picasso_example.*

class PicassoExample : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_picasso_example)

        Picasso.with(this).load("http://static.pexels.com/photos/288264/pexels-photo-288264.jpeg").fetch()

        btnPicasso1.setOnClickListener { loadImgs() }
    }

    fun loadImgs() {
        val context : Context = this

        Picasso
            .with(this)
            .load("http://static.pexels.com/photos/288264/pexels-photo-288264.jpeg")
            .resize(50, 50)
            .centerCrop()
            .transform(CircleTransform())
            .into(img1)

        Picasso
            .with(this)
            .load("http://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
            .fetch(object : Callback {
                override fun onSuccess() {
                    img2.alpha = 0f
                    Picasso.with(context)
                        .load("http://static.pexels.com/photos/288929/pexels-photo-288929.jpeg")
                        .fit()
                        .into(img2)
                    img2.animate().setDuration(300).alpha(1f).start()
                }

                override fun onError() {

                }
            })

    }
}
