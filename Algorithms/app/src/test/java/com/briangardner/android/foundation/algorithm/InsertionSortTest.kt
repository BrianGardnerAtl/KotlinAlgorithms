package com.briangardner.android.foundation.algorithm

import com.briangardner.android.foundation.generateRandomArray
import com.briangardner.android.foundation.isSorted
import org.junit.Test

class InsertionSortTest {

    private val sort = InsertionSort()

    @Test
    fun itSortsARandomArray() {
        val checking = generateRandomArray(1000)
        val sorted = sort.sort(checking)
        assert(sorted.isSorted())
    }
}