package com.example.fragmentsviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fragmentsviewmodel.databinding.FragmentMenuBinding
import com.example.fragmentsviewmodel.databinding.FragmentSecondBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    private lateinit var options: Options

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        options = savedInstanceState?.getParcelable(KEY_OPTIONS) ?: Options.DEFAULT
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.btFragment1.setOnClickListener { openFirst() }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }


    private fun openFirst() {
        navigator().showFirstFragment(options)
    }

    companion object {
        @JvmStatic
        val KEY_OPTIONS = "KEY_OPTIONS"
    }
}