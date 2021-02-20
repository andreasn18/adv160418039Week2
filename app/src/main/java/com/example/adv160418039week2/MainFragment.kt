package com.example.adv160418039week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    var number1 = 0
    var number2 = 0
    var poin = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
    fun newSoal(){
        number1 = Random.nextInt(0,100)
        number2 = Random.nextInt(0,100)
        txtNumber1.text = number1.toString()
        txtNumber2.text = number2.toString()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        newSoal()
        btnSubmit.setOnClickListener {
            if (txtAnswer.text.toString() == (number1 + number2).toString()){
                newSoal()
                poin++
                txtAnswer.setText("")
            }
            else{
                val action = MainFragmentDirections.actionGameFragment(poin)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}