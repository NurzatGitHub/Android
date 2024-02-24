package com.example.lab1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(var items:List<Item>,var contex: Context) : RecyclerView.Adapter<ItemsAdapter.MyViewHolder>(){

    class  MyViewHolder(view:View):RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.item_list_image)
        val title: TextView = view.findViewById(R.id.item_list_title)
        val text: TextView = view.findViewById(R.id.item_list_text)
        val price: TextView = view.findViewById(R.id.item_list_price)
        val button: Button = view.findViewById(R.id.item_list_button)
        val btn: Button = view.findViewById(R.id.item_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_in_list,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = items[position]
        holder.title.text = items[position].title
        holder.text.text = items[position].text
        holder.price.text = items[position].price
        holder.button.text = "${currentItem.price}"
//        Picasso.get().load(currentItem.image).into(holder.image)
        val imageId = contex.resources.getIdentifier(
            items[position].image,"drawable",
            contex.packageName
        )
        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener {
            val intent = Intent(contex,ItemActivity::class.java)

            intent.putExtra("itemImage",items[position].image)
            intent.putExtra("itemTitle",items[position].title)
            intent.putExtra("itemDesc",items[position].desc)
            intent.putExtra("itemText",items[position].text)
            intent.putExtra("itemPrice",items[position].price)

            contex.startActivity(intent)
        }
    }
}