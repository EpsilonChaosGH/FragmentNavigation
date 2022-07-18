package com.example.fragmentsviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fragmentsviewmodel.MenuFragment.Companion.KEY_OPTIONS
import com.example.fragmentsviewmodel.databinding.FragmentFirstBinding
import com.example.fragmentsviewmodel.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

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

        binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.textView.text = options.text

        binding.btSend.setOnClickListener { options.text = binding.editTextNumber.text.toString() }

        binding.btBack.setOnClickListener { navigator().goBack() }

        binding.btMenu.setOnClickListener { navigator().goToMenu() }

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }
}