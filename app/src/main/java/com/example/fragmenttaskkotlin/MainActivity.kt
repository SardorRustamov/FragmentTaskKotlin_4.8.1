package com.example.fragmenttaskkotlin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fragmenttaskkotlin.fragment.FragmentFirst
import com.example.fragmenttaskkotlin.fragment.FragmentSecond

class MainActivity : AppCompatActivity(), FragmentFirst.FirstListener, FragmentSecond.SecondListener{

    var fragmentFirst: FragmentFirst? = null
    var fragmentSecond: FragmentSecond? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
    }

    private fun initViews() {
        fragmentFirst = FragmentFirst()
        fragmentSecond = FragmentSecond()

        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_first, fragmentFirst!!)
            .replace(R.id.frame_second, fragmentSecond!!)
            .commit()
    }

     override fun onFirstSend(str: String){
        fragmentSecond!!.updateSecondText(str)
    }
    override fun onSecondSend(str: String) {
        fragmentFirst!!.updateFirstText(str)
    }

}