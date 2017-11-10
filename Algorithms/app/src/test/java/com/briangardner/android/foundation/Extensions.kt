package com.briangardner.android.foundation

fun Array<Int>.isSorted() : Boolean {
    return (1 until size).none { this[it -1] > this[it] }
}

fun generateRandomArray(size : Int) : Array<Int> {
    return Array(size, {_ -> (Math.random()*size).toInt() })
}