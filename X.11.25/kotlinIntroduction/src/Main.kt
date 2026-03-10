fun main() {
    val array = intArrayOf(1,2,3,4)
    
    val array2 = emptyArray<Int>()
    array2.plusElement(5)
    println(array.first())
    array.map { 
        println(it)
    }
    array2.forEach { 
        println(it)
    }
}