package com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.feature.list.presentation

import com.joancolmenerodev.comslashmobilityseleccionjoancolmenero.R

fun getColorByPosition(position: Int): Int {
    return if (position % 2 == 0) R.color.colorAccent else R.color.colorPrimary
}