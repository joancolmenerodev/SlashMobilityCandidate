package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.BasePresenter
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.base.presentation.PresenterView

interface ListContract {

    interface View : PresenterView {

        fun addItems(list: List<Int>)
        fun deleteAllEntries()
        fun deleteItem(index: Int)
        fun fillSortedList(list: List<Int>)
        fun showEmptyLayout()
        fun showNumberNotValidError()

    }

    interface Presenter : BasePresenter<View> {

        fun addNumbers(number: Int)
        fun removeAllItems()
        fun sortAscending(unsortedList: List<Int>)
        fun deleteItem(index: Int)
    }
}