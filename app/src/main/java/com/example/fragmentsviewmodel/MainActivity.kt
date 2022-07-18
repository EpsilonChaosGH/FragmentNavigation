package com.example.fragmentsviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.fragmentsviewmodel.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            val fragment = MenuFragment()

            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerView,fragment)
                .commit()

        }
    }

    private fun launchFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

    override fun showFirstFragment(options: Options) {
        launchFragment(FirstFragment.newInstance(options))
    }

    override fun showSecondFragment() {
        launchFragment(SecondFragment())
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun goToMenu() {
        supportFragmentManager.popBackStack(null,FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }
}
