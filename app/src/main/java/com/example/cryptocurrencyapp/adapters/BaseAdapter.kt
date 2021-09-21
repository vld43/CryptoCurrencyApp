package com.example.cryptocurrencyapp.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

// Абстрактный базовый класс адаптера
abstract class BaseAdapter<VH : BaseAdapter.BaseViewHolder> : RecyclerView.Adapter<VH>() {

    // Список элементов
    var items: ArrayList<Any> = ArrayList()

    // Размер списка
    override fun getItemCount() = items.size

    // Связывает View с содержимым
    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }

    // Возырвщает позицию элемента в списке
    fun getItem(position: Int) = items[position]

    // Добавление одного элемента
    fun add(newItem: Any) {
        items.add(newItem)
    }

    // Добавление всех элементов
    fun add(newItems: List<Any>) {
        items.addAll(newItems)
    }

    // Абстрактный класс ViewHolder
    abstract class BaseViewHolder(protected val view: View) : RecyclerView.ViewHolder(view) {

        abstract fun bind(item: Any)
    }
}