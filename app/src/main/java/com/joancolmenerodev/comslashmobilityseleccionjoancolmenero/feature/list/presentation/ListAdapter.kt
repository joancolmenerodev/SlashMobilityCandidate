package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.R

class ListAdapter(private val onItemClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    private var list = ArrayList<Int>()

    fun addItems(numberList: List<Int>) {
        list.addAll(numberList)
        notifyDataSetChanged()
    }

    fun updateList(newList: List<Int>) {
        setList(newList)
        notifyDataSetChanged()
    }

    fun removeItemAt(number: Int) {
        list.remove(number)
        val copyList = arrayListOf<Int>()
        copyList.addAll(list)
        setList(copyList)
        notifyDataSetChanged()
    }

    fun removeAll() {
        list.clear()
        notifyDataSetChanged()
    }

    private fun setList(newList: List<Int>) {
        list.clear()
        list.addAll(newList)
    }

    fun getList() = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ListViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
    )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.bind(list[position], onItemClick)
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val tvNumber: TextView = itemView.findViewById(R.id.tv_number_list_item)

        fun bind(number: Int, onItemClick: (position: Int) -> Unit) {
            tvNumber.text = number.toString()
            tvNumber.background =
                ContextCompat.getDrawable(itemView.context, getColorByPosition(position))
            itemView.setOnClickListener {
                onItemClick.invoke(number)
            }

        }

    }
}