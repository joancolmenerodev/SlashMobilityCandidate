package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.R
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ListFragment : Fragment(R.layout.list_fragment), ListContract.View {

    @Inject
    lateinit var presenter: ListContract.Presenter

    private lateinit var adapter: ListAdapter

    private lateinit var recyclerView: RecyclerView
    private lateinit var emptyList: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        presenter.onViewReady(this)
        initViews(view)
        initClickListeners(view)
        setupRecyclerView()
    }

    private fun inject() = AndroidSupportInjection.inject(this)

    private fun initClickListeners(view: View) {
        view.findViewById<View>(R.id.btn_add_items_to_list).setOnClickListener {
            val numbers = view.findViewById<EditText>(R.id.et_input_number).text.toString()
            presenter.addNumbers(number = numbers.toInt())
        }
        view.findViewById<View>(R.id.btn_remove_all_entries).setOnClickListener {
            presenter.removeAllItems()
        }
        view.findViewById<View>(R.id.btn_sort_ascending).setOnClickListener {
            presenter.sortAscending(adapter.getList())
        }
    }

    private fun initViews(view: View) {
        emptyList = view.findViewById(R.id.tv_empty_list)
        recyclerView = view.findViewById(R.id.list_numbers)
    }

    private fun setupRecyclerView() {
        adapter = ListAdapter { itemToDelete ->
            presenter.deleteItem(itemToDelete)
        }
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = adapter
    }

    override fun addItems(list: List<Int>) {
        emptyList.visibility = View.GONE
        adapter.addItems(list)
    }

    override fun deleteAllEntries() {
        adapter.removeAll()
    }

    override fun deleteItem(index: Int) {
        adapter.removeItemAt(index)
        if (adapter.getList().isEmpty()) showEmptyLayout()
    }

    override fun fillSortedList(list: List<Int>) {
        adapter.updateList(list)
    }

    override fun showEmptyLayout() {
        emptyList.visibility = View.VISIBLE
    }

    override fun showNumberNotValidError() {
        Toast.makeText(activity, getString(R.string.invalid_input_text), Toast.LENGTH_SHORT).show()
    }
}