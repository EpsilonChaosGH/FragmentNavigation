package com.example.fragmentsviewmodel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.fragmentsviewmodel.databinding.FragmentFirstBinding
import java.lang.IllegalArgumentException

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var options: Options

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        options =
            savedInstanceState?.getParcelable(KEY_OPTIONS) ?: arguments?.getParcelable(ARG_OPTIONS)
                    ?: throw IllegalArgumentException("oops")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentFirstBinding.inflate(inflater, container, false)


        binding.btNext.setOnClickListener { navigator().showSecondFragment() }

        binding.btBack.setOnClickListener { navigator().goBack() }

        binding.textView.text = options.text

        return binding.root
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(KEY_OPTIONS, options)
    }

    companion object {

        @JvmStatic
        val KEY_OPTIONS = "KEY_OPTIONS"

        @JvmStatic
        val ARG_OPTIONS = "ARG_OPTIONS"

        @JvmStatic
        fun newInstance(options: Options): FirstFragment {
            val fragment = FirstFragment()
            fragment.arguments = bundleOf(ARG_OPTIONS to options)
            return fragment
        }
    }
}
