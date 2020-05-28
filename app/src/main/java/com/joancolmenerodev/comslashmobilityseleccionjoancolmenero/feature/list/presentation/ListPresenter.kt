package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain.GetListSortedAscendingUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain.GetRandomNumbersUseCase
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.domain.exceptions.ListExceptions
import javax.inject.Inject

class ListPresenter @Inject constructor(
    val getRandomNumbersUseCase: GetRandomNumbersUseCase,
    val getListSortedAscendingUseCase: GetListSortedAscendingUseCase
) : ListContract.Presenter {

    private var view: ListContract.View? = null

    override fun addNumbers(number: Int) {
        getRandomNumbersUseCase.execute(number).fold(
            ::handleException,
            ::handleListSucceed
        )

    }

    private fun handleException(listExceptions: ListExceptions) {
        when (listExceptions) {
            is ListExceptions.EmptyList -> view?.showEmptyLayout()
            is ListExceptions.NumberNotValidException -> view?.showNumberNotValidError()
        }
    }

    private fun handleListSucceed(list: List<Int>) {
        view?.addItems(list)
    }

    private fun handleSucceedSorting(list: List<Int>) {
        view?.fillSortedList(list)
    }


    override fun removeAllItems() {
        view?.deleteAllEntries()
        view?.showEmptyLayout()
    }

    override fun sortAscending(unsortedList: List<Int>) {
        getListSortedAscendingUseCase.execute(list = unsortedList)
            .fold(::handleException, ::handleSucceedSorting)
    }

    override fun deleteItem(index: Int) {
        view?.deleteItem(index)
    }

    override fun onViewReady(view: ListContract.View) {
        this.view = view
    }

    override fun onViewDestroyed() {
        this.view = null
    }

}