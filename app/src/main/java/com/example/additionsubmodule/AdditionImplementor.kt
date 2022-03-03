package com.example.additionsubmodule

class AdditionImplementor:AdditionInterface {
    override fun getNumber(text: String): String {
        var number=text.toInt()
        number += 100
        return number.toString()
    }
}