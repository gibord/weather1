package com.example.weather.view.weatherlist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.FragmentWeatherListRecyclerItemBinding
import com.example.weather.domain.Weather

class WeatherListAdapter(private val dataList : List <Weather>): RecyclerView.Adapter<WeatherListAdapter.WeatherVievHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherVievHolder {
        val binding=FragmentWeatherListRecyclerItemBinding.inflate(LayoutInflater.from(parent.context))
        return WeatherVievHolder(binding.root)
    }

    override fun onBindViewHolder(holder: WeatherVievHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount(): Int {
       return dataList.size
    }
    class WeatherVievHolder(view: View):RecyclerView.ViewHolder(view){
        fun bind(weather: Weather){
           val binding= FragmentWeatherListRecyclerItemBinding.bind(itemView)
            binding.CityName.text=weather.city.name
        }
    }
}