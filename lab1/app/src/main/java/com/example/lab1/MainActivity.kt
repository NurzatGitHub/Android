package com.example.lab1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.EditText
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var itemsAdapter: ItemsAdapter
    private val allItems = arrayListOf<Item>()
    private val filteredItems = arrayListOf<Item>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        itemsAdapter = ItemsAdapter(allItems, this)
        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = itemsAdapter

        allItems.addAll(getAllItems())

        searchButton.setOnClickListener {
            val query = searchEditText.text.toString().trim()
            filterItems(query)
        }
    }

    private fun getAllItems(): List<Item> {
        val items = arrayListOf<Item>()

        items.add(Item(1,"carbonara","Naruto Pizza","30, traditional dough 30.570 g","Куриные кусочки, моцарелла, ананасы, фирменный соус альфредо, соус терияки","3 900 тг."))
        items.add(Item(2,"wowkebab","Вау,Кебаб","30, традиционное тесто 30, 530 г","Кебаб из говядины, соус ранч, моцарелла, сладкий перец, томаты, красный лук, фирменный томатный соус","от 2 900 тг."))
        items.add(Item(3,"hamcheese","Баварская","30, традиционное тесто 30, 550 г","Острая чоризо из цыпленка, маринованные огурчики, красный лук, томаты, соус медово-горчичный, моцарелла, фирменный томатный соус","от 2 700 тг."))
        items.add(Item(5,"cheesy", "Cheesy", "Mozzarella cheese, cheddar cheese, parmesan cheese, Alfredo sauce","Соус ранч, ветчина из цыпленка, моцарелла, маринованные огурчики, красный лук", "от 2 000 тг."))
        items.add(Item(6,"pepperonifresh", "Pepperoni Fresh", "Chicken pepperoni, extra mozzarella cheese, tomatoes, marinara sauce","Цыпленок, шампиньоны, соус сливочный с грибами, красный лук, чеснок, моцарелла, смесь сыров чеддер и пармезан, фирменный соус альфредо", "от 2 700 тг."))
        items.add(Item(7,"doublecincken", "Double Chicken", "Double chicken, mozzarella cheese, Alfredo sauce","Пепперони из цыпленка, увеличенная порция моцареллы, томаты, томатный соус", "от 1 900 тг."))
        items.add(Item(9,"chorizo", "Chorizo fresh", "Spicy chorizo, sweet pepper, mozzarella cheese, marinara sauce","Моцарелла, сыры чеддер и пармезан, соус альфредо", "от 1 900 тг."))
        items.add(Item(10,"hamcheese", "Ham & Cheese", "Chicken ham, mozzarella cheese, Alfredo sauce","Пепперони из цыпленка, увеличенная порция моцареллы, томаты, томатный соус", "2 700 тг"))
        items.add(Item(11,"carbonara", "Carbonara", "Chicken ham, cheddar cheese, parmesan cheese, tomatoes, red onion, mozzarella cheese, Alfredo sauce, garlic, Italian seasoning","Цыпленок, моцарелла, сыры чеддер и пармезан, сырный соус, томаты, соус альфредо, чеснок", "2 700 тг"))
        items.add(Item(12,"chessychicken", "Cheesy chicken", "Chicken, mozzarella cheese, cheddar cheese, parmesan cheese, cheese sauce, tomatoes, Alfredo sauce, garlic","Ветчина из цыпленка, шампиньоны, моцарелла, томатный соус", "2 700 тг"))

        return items
    }
    private fun filterItems(query: String) {
        filteredItems.clear()

        if (query.isEmpty()) {
            filteredItems.addAll(allItems)
        } else {
            for (item in allItems) {
                if (item.title.contains(query, ignoreCase = true) || item.desc.contains(query, ignoreCase = true)) {
                    filteredItems.add(item)
                }
            }
        }

        itemsAdapter.items = filteredItems
        itemsAdapter.notifyDataSetChanged()
    }
}