package com.example.weather.view.weatherlist

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weather.databinding.FragmentWeatherListBinding
import com.example.weather.viewmodel.AppState

class WeatherListfragment : Fragment() {

    companion object {
        fun newInstance() = WeatherListfragment()
    }

    lateinit var binding: FragmentWeatherListBinding
    lateinit var viewModel: WeatherListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.liveData.observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                Toast.makeText(requireContext(), "Работает $t", Toast.LENGTH_LONG).show()
            }

        })
        viewModel.sentRequest()
    }

}