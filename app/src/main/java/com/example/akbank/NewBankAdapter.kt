package com.example.akbank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso


interface NewBankClickListener {
    fun onBankClick(banks: Banks)
}
class NewBankAdapter(private val newList: ArrayList<Banks>,private val newBankClickListener: NewBankClickListener) :
    RecyclerView.Adapter<NewBankAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return newList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = newList[position]
        holder.tvheading.text = currentItem.title

        Picasso.get().load(currentItem.imageUrl).into(holder.titleImage)

        holder.itemView.setOnClickListener {
            newBankClickListener.onBankClick(currentItem)
        }
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleImage: ShapeableImageView = itemView.findViewById(R.id.ımageView)
        val tvheading: TextView = itemView.findViewById(R.id.list_item_id)
    }


}