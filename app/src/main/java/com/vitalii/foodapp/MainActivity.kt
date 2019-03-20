package com.vitalii.foodapp

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import kotlinx.android.synthetic.main.menu_item.view.*

class MainActivity : AppCompatActivity() {


    private var listOfFoods:ArrayList<Food> = ArrayList()
    private var adapter:FoodAdapter? = null
    private lateinit var mGridView: GridView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mGridView = findViewById(R.id.gridMenu)

        addFood()

        adapter=FoodAdapter(this,listOfFoods)
        mGridView.adapter = adapter
    }

    private fun addFood(){
        listOfFoods.add(Food("Coffe","Some description",R.drawable.coffee_pot))
        listOfFoods.add(Food("Honey","Some description",R.drawable.honey))
        listOfFoods.add(Food("Ice Cream","Some description",R.drawable.strawberry_ice_cream))
        listOfFoods.add(Food("Sugar Cubes","Some description",R.drawable.sugar_cubes))
    }

    inner class FoodAdapter:BaseAdapter{
        var listOfFood = ArrayList<Food>()
        var context:Context?=null
        constructor(context:Context, listOfFood:ArrayList<Food>):super(){
            this.context = context
            this.listOfFood = listOfFood
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

            val inflater = layoutInflater
            val foodView = inflater.inflate(R.layout.menu_item, null)
            foodView.imgFood.setImageResource(listOfFood[position].image)
            foodView.txtFoodName.text = listOfFood[position].name

            return foodView
        }

        override fun getItem(position: Int): Any {
            return listOfFood[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return listOfFood.size
        }

    }
}
