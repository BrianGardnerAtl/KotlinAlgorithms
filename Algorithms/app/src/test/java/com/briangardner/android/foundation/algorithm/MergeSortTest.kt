package com.briangardner.android.foundation.algorithm

import com.briangardner.android.foundation.generateRandomArray
import com.briangardner.android.foundation.isSorted
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class MergeSortTest {

    private val sort = MergeSort()

    @Test
    fun itSortsARandomArray() {
        val checking = generateRandomArray(1000)
        val sorted = sort.sort(checking)
        assert(sorted.isSorted())
    }

    // Test the merge method
    @Test
    fun itCorrectlyMergesAnArray() {
        val input = arrayOf(10, 30, 4, 15)
        val expected = arrayOf(4, 10, 15, 30)
        val first = 0
        val last = input.size - 1
        val middle = (first+last)/2
        assertThat(sort.merge(input, first, middle, last), equalTo(expected))
    }

    // Test the splitArray method
    @Test
    fun itCorrectlySplitsALargerArray() {
        val input = arrayOf(1,2,3,4,5,6,7,8,9,10)
        val expectedLeft = arrayOf(1,2,3,4,5, Int.MAX_VALUE)
        val expectedRight = arrayOf(6,7,8,9,10, Int.MAX_VALUE)
        val first = 0
        val last = input.size - 1
        val middle = (first+last)/2
        val (left,right) = sort.splitArray(input, first, middle, last)
        assertThat(left, equalTo(expectedLeft))
        assertThat(right, equalTo(expectedRight))
    }

    @Test
    fun itCorrectlySplitsASmallerArray() {
        val input = arrayOf(1,2)
        val expectedLeft = arrayOf(1, Int.MAX_VALUE)
        val expectedRight = arrayOf(2, Int.MAX_VALUE)
        val first = 0
        val last = input.size - 1
        val middle = (first+last)/2
        val (left,right) = sort.splitArray(input, first, middle, last)
        assertThat(left, equalTo(expectedLeft))
        assertThat(right, equalTo(expectedRight))
    }
}