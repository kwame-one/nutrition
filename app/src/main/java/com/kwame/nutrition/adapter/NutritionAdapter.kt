package com.kwame.nutrition.adapter

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kwame.nutrition.R
import com.kwame.nutrition.architecture.models.Nutrition
import com.kwame.nutrition.listeners.ItemClickListener
import javax.inject.Inject


class NutritionAdapter @Inject constructor(application: Application): RecyclerView.Adapter<NutritionAdapter.NutritionViewHolder>() {

    private lateinit var itemClickListener: ItemClickListener

    private val nutrition: MutableList<Nutrition> = mutableListOf();

    fun setNutrition(nutrition: MutableList<Nutrition>) {
        this.nutrition.clear()
        this.nutrition.addAll(nutrition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NutritionViewHolder {
        return NutritionViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_nutrition, parent, false));
    }

    fun setOnItemClickListener(listener: ItemClickListener) {
        itemClickListener = listener
    }

    override fun onBindViewHolder(holder: NutritionViewHolder, position: Int) {
        val item = nutrition[position]


        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(position);
        }

    }

    override fun getItemCount(): Int {
        return nutrition.size
    }

    class NutritionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

//        val status: TextView = itemView.findViewById(R.id.status)
//        val cylinderId: TextView = itemView.findViewById(R.id.cylinder_id)
//        val date: TextView = itemView.findViewById(R.id.date)
//        val amount: TextView = itemView.findViewById(R.id.amount)

    }

}