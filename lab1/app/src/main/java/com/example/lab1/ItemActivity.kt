package com.example.lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val image: ImageView = findViewById(R.id.item_list_image_1)
        val title: TextView = findViewById(R.id.item_list_title_1)
        val desc: TextView = findViewById(R.id.item_list_desc_1)
        val text: TextView = findViewById(R.id.item_list_text_1)
        val price: TextView = findViewById(R.id.item_list_price_1)


//        image.text = intent.getStringExtra("imageTitle")
        title.text = intent.getStringExtra("itemTitle")
        desc.text = intent.getStringExtra("itemDesc")
        text.text = intent.getStringExtra("itemText")
        price.text = intent.getStringExtra("itemPrice")
    }
}