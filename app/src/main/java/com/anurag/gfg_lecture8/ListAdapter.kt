package com.anurag.gfg_lecture8

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(val list: List<KeyValuePair>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val keyTextView: TextView = itemView.findViewById(R.id.KeyTextView)
        val valueTextView: TextView = itemView.findViewById(R.id.valueTextView)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return ListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.keyTextView.text = list[position].keyText
        holder.valueTextView.text = list[position].valueText
    }

    override fun getItemCount(): Int {
        return list.size
    }
}