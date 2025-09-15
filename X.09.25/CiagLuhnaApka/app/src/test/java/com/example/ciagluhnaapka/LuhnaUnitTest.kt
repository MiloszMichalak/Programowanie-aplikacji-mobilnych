package com.example.ciagluhnaapka

import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import org.junit.Test

class LuhnaUnitTest {

    @Test
    fun testSumaMnozona() {
        val luhna = Luhna()
        val kod = "4566945729580997"
        val expectedSum = 90
        val actualSum = luhna.sumaMnozona(kod)
        assertEquals(expectedSum, actualSum)
    }

    @Test
    fun testCzyPoprawny() {
        val luhna = Luhna()
        val suma = 90
        val expectedValidity = true
        val actualValidity = luhna.czyPoprawny(suma)
        assertEquals(expectedValidity, actualValidity)
    }
}