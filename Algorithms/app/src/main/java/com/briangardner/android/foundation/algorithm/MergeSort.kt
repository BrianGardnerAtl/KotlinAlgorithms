package com.briangardner.android.foundation.algorithm

class MergeSort {

    fun sort(input : Array<Int>) : Array<Int> {
        return sort(input, 0, input.size-1)
    }

    // make this private since it should not be called directly by other components
    private fun sort(input : Array<Int>, first : Int, last : Int) : Array<Int> {
        if (first < last) {
            val middle = (first+last)/2
            sort(input, first, middle)
            sort(input, middle+1, last)
            merge(input, first, middle, last)
        }
        return input
    }

    fun merge(input : Array<Int>, first : Int, middle : Int, end : Int) : Array<Int> {
        val (left, right) = splitArray(input, first, middle, end)
        var i = 0
        var j = 0
        for (k in first..end) {
            if (left[i] <= right[j]) {
                input[k] = left[i]
                i += 1
            } else {
                input[k] = right[j]
                j += 1
            }
        }
        return input
    }

    /*
    Split the input array into two sub arrays
    Requirements -> first <= middle < end
     */
    fun splitArray(input : Array<Int>, first : Int, middle : Int, end : Int) : Pair<Array<Int>, Array<Int>> {
        val leftLength = middle - first + 1
        val rightLength = end - middle
        val left = createSortArray(leftLength)
        val right = createSortArray(rightLength)
        for (i in 0 until leftLength) {
            left[i] = input[first + i]
        }
        for (j in 0 until rightLength) {
            right[j] = input[middle + j + 1]
        }
        return Pair(left, right)
    }

    // Sort array has a length + 1
    // The last position is taken up my Int.MAX_VALUE to facilitate the sorting in the merge method
    private fun createSortArray(length : Int) : Array<Int> {
        val array = Array(length+1, { _ -> 0})
        array[length] = Int.MAX_VALUE
        return array
    }
}