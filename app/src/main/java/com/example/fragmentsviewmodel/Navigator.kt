package com.example.fragmentsviewmodel

import androidx.fragment.app.Fragment


fun Fragment.navigator(): Navigator{
    return requireActivity() as Navigator
}
interface Navigator {

    fun showFirstFragment(options: Options)

    fun showSecondFragment()

    fun goBack()

    fun goToMenu()
}