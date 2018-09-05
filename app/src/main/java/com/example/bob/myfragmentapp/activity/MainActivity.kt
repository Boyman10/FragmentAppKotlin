package com.example.bob.myfragmentapp.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.bob.myfragmentapp.R
import com.example.bob.myfragmentapp.fragment.MainFragment

/**
 * @see https://kotlinlang.org/docs/reference/classes.html
 */
class MainActivity : AppCompatActivity(), MainFragment.OnButtonClickedListener {

    override fun onButtonClicked(view: View?) {
        Log.i(javaClass.simpleName, "Button clicked !")
        launchSecondActivity()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun launchSecondActivity() {
        val myIntent = Intent(this, SecondActivity::class.java)
        startActivity(myIntent)
    }

}
