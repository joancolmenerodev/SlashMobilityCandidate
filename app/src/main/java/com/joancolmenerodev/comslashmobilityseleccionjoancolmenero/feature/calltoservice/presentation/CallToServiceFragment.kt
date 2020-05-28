package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.calltoservice.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.call_to_service_fragment.*
import javax.inject.Inject

class CallToServiceFragment : Fragment(R.layout.call_to_service_fragment),
    CallToServiceContract.View {

    @Inject
    lateinit var presenter: CallToServiceContract.Presenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject()
        presenter.onViewReady(this)
        initClickListeners(view)
    }

    private fun inject() = AndroidSupportInjection.inject(this)

    private fun initClickListeners(view: View) {
        view.findViewById<View>(R.id.btn_go_to_list).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.go_to_list_action)
        )
        view.findViewById<View>(R.id.btn_call_service).setOnClickListener {
            presenter.loadResults()
        }
    }

    override fun showHttpBinIp(ip: String) {
        tv_response.text = String.format(getString(R.string.response), ip)
    }

    override fun showReversedHttpBinIp(ipReversed: String) {
        tv_response_reversed.text = String.format(getString(R.string.response), ipReversed)
    }

    override fun showNoInternetAvailable() =
        Toast.makeText(activity, getString(R.string.no_internet_text), Toast.LENGTH_SHORT).show()

    override fun showProgressBar(visible: Boolean) {
        progress.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun showNotFoundError() {
        Toast.makeText(activity, getString(R.string.not_found_text), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.onViewDestroyed()
    }
}