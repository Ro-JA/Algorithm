package com.example.algorithm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.algorithm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding // создаем переменую типа binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater) //иниацилизируем обект который будет использоваться для доступа к view
        setContentView(binding.root) // передаем его что бы сделать активным экраном
        binding.buttonMinValue.setOnClickListener { minValueArray(getValuesEditText()) }
    }

    private fun minValueArray(array: IntArray) { // доделать finish
        var mimValue = array[0]
        var minIndex = 0
        for (i in 1..<array.size - 1) {
            if (array[i] < array[mimValue]) {
                mimValue = array[i]
                minIndex = i
            }
        }
    }

    private fun getValuesEditText(): IntArray {
        val stringInEditText = binding.editTextNumber.text.toString()
        return stringInEditText.split(",").map { it.toInt() }.toIntArray()
    }


}