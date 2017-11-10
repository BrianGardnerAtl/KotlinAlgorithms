package com.briangardner.android.foundation.algorithm

class InsertionSort {

    fun sort(input : Array<Int>) : Array<Int> {
        for (j in 1 until input.size) {
            val key = input[j]
            var i = j-1
            while (i>=0 && input[i]>key) {
                input[i+1] = input[i]
                i -= 1
            }
            input[i+1] = key
        }
        return input
    }
}