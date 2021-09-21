package com.example.cryptocurrencyapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.cryptocurrencyapp.R

class CurrenciesAdapter : BaseAdapter<CurrenciesAdapter.CurrencyViewHolder>() {

    // Создаёт ViewHolder и инициализирует views для списка
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return CurrencyViewHolder(v)
    }

    // Реализация ViewHolder
    class CurrencyViewHolder(view: View) : BaseAdapter.BaseViewHolder(view) {

        private val ivCurrencyIcon = view.findViewById<ImageView>(R.id.ivCurrencyIcon)
        private val tvCurrencySym = view.findViewById<TextView>(R.id.tvCurrencySym)
        private val tvCurrencyName = view.findViewById<TextView>(R.id.tvCurrencyName)
        private val tvCurrencyMarketCap = view.findViewById<TextView>(R.id.tvCurrencyMarketCap)
        private val tvCurrencyPrice = view.findViewById<TextView>(R.id.tvCurrencyPrice)

        init {
            // Слушатель клика по элементам списка
            itemView.setOnClickListener {

            }
        }

        // Привязываем элементы представления списка к RecyclerView и заполняем данными
        override fun bind(item: Any) {
            let {
                item as Currency
                Glide.with(view.context).load(item.image).into(ivCurrencyIcon)
                tvCurrencySym.text = item.symbol
                tvCurrencyName.text = item.name
                tvCurrencyMarketCap.text = item.marketCap
                tvCurrencyPrice.text = item.price.toString()
            }
        }

    }

    // Класс данных для элемента списка
    data class Currency(
        val id: String,
        val symbol: String,
        val name: String,
        val image: String,
        val price: Float,
        val marketCap: String,
        val marketCapRank: Int,
        val totalVolume: Float,
        val priceChangePercentage24h: Float,
        val marketCapChangePercentage24h: Float,
        val circulatingSupply: Double,
        val totalSupply: Float,
        val ath: Float,
        val athChangePercentage: Float
    )
}