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

class FragmentFirst : Fragment() {
    private var listener: FirstListener? = null
    private var tv_first: TextView? = null
    private var b_first: Button? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.first_fragment, container, false)

        tv_first = view.findViewById(R.id.tv_first)
        b_first = view.findViewById(R.id.b_first)
        b_first?.setOnClickListener(View.OnClickListener {
            listener?.onFirstSend("Sardor")
        })

        return view
        }
    fun updateFirstText(str: String){
        tv_first?.setText(str)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = if (context is FirstListener) {
            context
        } else {
            throw RuntimeException(context.toString() + "must implement FirstListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

     interface FirstListener {
         fun onFirstSend (str :String){}
    }
}


