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
            showValue()
        }
    }

    private fun showArray() { // функция показывает массив пользователю
        binding.textViewArray.text = binding.editTextNumber.text.toString()
    }

    private fun numEditText(): IntArray { // функция преоброзует введеные значения в массив чисел
        val stringEditText = binding.editTextNumber.text.toString()
        return stringEditText.split(" ").map { it.toInt() }.toIntArray()
    }

    private fun showValue() { // функция показывает минимальное значения массива пользователю
        binding.textViewShow.text = "Minimum value ${minValueArray(numEditText()).toString()}"
    }

    private fun minValueArray(array: IntArray): Int { // функция возрощает минимально значения из массива
        var mimValue = array[0]
        var minIndex = 0
        for (i in 1..<array.size - 1) {
            if (array[i] < array[mimValue]) {
                mimValue = array[i]
                minIndex = i
            }
        }
        return mimValue
    }
}