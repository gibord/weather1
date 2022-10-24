package com.example.weather.view.weatherlist

import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weather.R
import com.example.weather.databinding.FragmentWeatherListBinding
import com.example.weather.viewmodel.AppState

class WeatherListfragment : Fragment() {

    companion object {
        fun newInstance() = WeatherListfragment()
    }

    var isRussia = true

    private var _binding: FragmentWeatherListBinding? = null
    val binding: FragmentWeatherListBinding
        get() {
            return _binding!!
        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    lateinit var viewModel: WeatherListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherListViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, object : Observer<AppState> {
            override fun onChanged(t: AppState) {
                //Toast.makeText(requireContext(), "Работает $t", Toast.LENGTH_LONG).show()
                renderData(t)
            }

        })

        binding.weatherListFragmentFAB.setOnClickListener {
            isRussia = !isRussia
            if (isRussia) {
                viewModel.getWheaherListForRussia()
                binding.weatherListFragmentFAB.setImageResource(R.drawable.russian_flag)
            } else {
                viewModel.getWheaherListForWorld()
                binding.weatherListFragmentFAB.setImageResource(R.drawable.worl_flag)
            }
        }
        viewModel.getWheaherListForRussia()
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Error -> {/*TODO*/
            }
            AppState.Loading -> {/*TODO*/
            }
            is AppState.SuccessOne -> {
                val result = appState.weatherData
            }
            is AppState.SuccessMulti -> {
                binding.FragmentRecyclerView.adapter=WeatherListAdapter(appState.weatherList)
            }
        }

    }
}