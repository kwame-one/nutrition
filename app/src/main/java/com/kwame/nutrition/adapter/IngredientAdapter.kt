package com.kwame.nutrition.adapter

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kwame.nutrition.R
import com.kwame.nutrition.architecture.models.Ingredient
import com.kwame.nutrition.listeners.ItemClickListener
import com.kwame.nutrition.utils.Helper
import javax.inject.Inject


class IngredientAdapter @Inject constructor(application: Application): RecyclerView.Adapter<IngredientAdapter.IngredientViewHolder>() {

    private lateinit var itemClickListener: ItemClickListener

    private val ingredient: MutableList<Ingredient> = mutableListOf();

    fun setIngredients(ingredient: List<Ingredient>) {
        this.ingredient.clear()
        this.ingredient.addAll(ingredient)
    }

    fun getIngredient(index: Int): Ingredient? {
        if (index >= ingredient.size || index < 0 ) {
            return null
        }

        return ingredient[index]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        return IngredientViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_nutrition, parent, false));
    }

    fun setOnItemClickListener(listener: ItemClickListener) {
        itemClickListener = listener
    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        val item = ingredient[position]

        holder.name.text = item.name
        holder.genus.text = item.genus
        holder.abbreviation.text = Helper.abbreviateName(item.name)

        holder.itemView.setOnClickListener {
            itemClickListener.onItemClick(position);
        }

    }

    override fun getItemCount(): Int {
        return ingredient.size
    }

    class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById(R.id.name)
        val genus: TextView = itemView.findViewById(R.id.genus)
        val abbreviation: TextView = itemView.findViewById(R.id.abbreviation)


    }

}