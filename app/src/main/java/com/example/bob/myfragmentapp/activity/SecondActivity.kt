package com.example.bob.myfragmentapp.activity

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.bob.myfragmentapp.R
import com.example.bob.myfragmentapp.fragment.SecondFragment

class SecondActivity : AppCompatActivity(), SecondFragment.OnFragmentInteractionListener {

    override fun onFragmentInteraction(uri: Uri) {
        Log.i(javaClass.simpleName,"Back to our activity from fragment...")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
    }
}
