package com.example.ciagluhnaapka

class Luhna {
    fun sumaMnozona(kod: String): Int{
        var sum = 0
        var flaga = true
        for (i in kod){
            var liczba = i.toString().toInt()
            if (flaga) liczba *= 2
            if (liczba > 9) liczba -= 9
            sum += liczba
            flaga = !flaga
        }
        return sum
    }

    fun czyPoprawny(suma: Int): Boolean{
        return suma % 10 == 0
    }
}