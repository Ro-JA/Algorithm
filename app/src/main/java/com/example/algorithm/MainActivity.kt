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
        binding.buttonMinValue.setOnClickListener {
            showArray()
            minValueArray(numEditText())
        }
    }

    private fun numEditText(): IntArray { // функция преоброзует воденые значения в массив чисел
        val stringEditText = binding.editTextNumber.text.toString()
        return stringEditText.split(" ").map { it.toInt() }.toIntArray()
    }

    private fun showArray() {
        binding.textViewArray.text = numEditText().joinToString()
    }

    private fun minValueArray(array: IntArray) { // функция возрощает минимально значения из массива
        var mimValue = array[0]
        var minIndex = 0
        for (i in 1..<array.size - 1) {
            if (array[i] < array[mimValue]) {
                mimValue = array[i]
                minIndex = i
            }
        }
    }
}