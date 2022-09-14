package com.example.fragmenttaskkotlin.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmenttaskkotlin.R

class FragmentSecond : Fragment() {
   // private var listener:InterfaceAA? = null
    private var listener: SecondListener? = null
    private var tv_second: TextView? = null
    private var b_second: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.second_fragment, container, false)

        tv_second = view.findViewById(R.id.tv_second)
        b_second = view.findViewById(R.id.b_second)
        b_second?.setOnClickListener {
            listener?.onSecondSend("R")
        }
        return view
    }
    fun updateSecondText(str: String){
        tv_second?.setText(str)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is SecondListener) {
            context
        } else {
            throw RuntimeException(context.toString() + "must implement FirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

      interface SecondListener {
        fun onSecondSend (str :String)
    }
}
