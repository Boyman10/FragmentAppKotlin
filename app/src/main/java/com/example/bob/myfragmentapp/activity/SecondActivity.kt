package com.example.bob.myfragmentapp.activity

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bob.myfragmentapp.R
import com.example.bob.myfragmentapp.fragment.SecondFragment

class SecondActivity : AppCompatActivity(), SecondFragment.OnFragmentInteractionListener {

    /**
     * Starting the dynamic version of the Fragment application
     */
    override fun onFragmentInteraction() {
        Log.i(javaClass.simpleName,"Back to our activity from fragment...")

        val myIntent = Intent(this, DynamicFragActivity::class.java)
        startActivity(myIntent)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}
