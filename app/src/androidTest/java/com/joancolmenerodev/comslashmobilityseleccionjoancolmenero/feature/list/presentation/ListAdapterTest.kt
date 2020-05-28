package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class ListAdapterTest {

    private lateinit var adapter: ListAdapter

    @Before
    fun setUp() {
        adapter = ListAdapter { }
    }

    @Test
    fun givenAddingNewItemsTheListSizeIncreases() {
        //ASSIGN
        val expectedSize = addTwoItemsToList.size + addThreeItemstoList.size

        //ACT
        adapter.addItems(addTwoItemsToList)
        adapter.addItems(addThreeItemstoList)

        //ASSERT
        assertEquals(adapter.getList().size, expectedSize)
    }

    @Test
    fun givenUpdateTheListItGetsTheValuesAndSizeFromTheNewOne() {
        //ASSIGN
        val expectedSize = sortedList.size

        //ACT
        adapter.addItems(initialList)
        adapter.updateList(sortedList)

        //ASSERT
        assertEquals(adapter.getList().size, expectedSize)
        assertEquals(adapter.getList(), sortedList)
    }

    @Test
    fun givenWeRemoveAnItemTheSizeAndTheListGetsUpdated() {
        //ASSIGN
        val expectedSize = initialList.size - ONE

        //ACT
        adapter.addItems(initialList)
        adapter.removeItemAt(initialList.last())

        //ASSERT
        assertEquals(adapter.itemCount, expectedSize)
    }

    @Test
    fun givenWeRemoveAllItemsListIsEmpty() {

        //ACT
        adapter.addItems(initialList)
        adapter.removeAll()

        //ASSERT
        assertTrue(adapter.itemCount == ZERO)

    }


    companion object {
        const val ONE = 1
        const val ZERO = 0
        val initialList = arrayListOf(30, 20, 10)
        val sortedList = arrayListOf(10, 20, 30)
        val addTwoItemsToList = arrayListOf(1, 2)
        val addThreeItemstoList = arrayListOf(3, 4, 5)

    }
}