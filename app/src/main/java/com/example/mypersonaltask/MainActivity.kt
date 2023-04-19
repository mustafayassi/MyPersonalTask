package com.example.mypersonaltask


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.mypersonaltask.data.ApiManger
import com.example.mypersonaltask.databinding.ActivityMainBinding
import kotlin.random.Random


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ApiManger.makeRequestUsingOkhttp { response ->
            runOnUiThread {
                binding.temperatureText.text =
                    response.data?.timelines?.get(0)?.intervals?.get(0)?.values?.temperature.toString()
                val temperature =
                    response.data?.timelines?.get(0)?.intervals?.get(0)?.values?.temperature

                val listOfWinter = listOf(
                    R.drawable.winter_1,
                    R.drawable.winter_2,
                    R.drawable.winter_3,
                    R.drawable.winter_4
                )

                val listOfSummer = listOf(
                    R.drawable.summer_1,
                    R.drawable.summer_2,
                    R.drawable.summer_3,
                    R.drawable.summer_4
                )

                when {
                    temperature!! < 30.0 -> {
                        binding.clothes.setImageResource(
                            listOfWinter[Random.nextInt(listOfWinter.size)]
                        )
                    }
                    temperature >= 30.0 -> {
                        binding.clothes.setImageResource(
                            listOfWinter[Random.nextInt(listOfSummer.size)]
                        )
                    }


                }
                binding.nextButton.setOnClickListener {
                    when {
                        temperature!! < 30.0 -> {
                            binding.clothes.setImageResource(
                                listOfWinter[Random.nextInt(listOfWinter.size)]
                            )
                        }
                        temperature >= 30.0 -> {
                            binding.clothes.setImageResource(
                                listOfWinter[Random.nextInt(listOfSummer.size)]
                            )
                        }
                    }
                }

            }
        }
    }


}
