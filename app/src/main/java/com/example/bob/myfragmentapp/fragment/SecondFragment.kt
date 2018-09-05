package com.example.bob.myfragmentapp.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.example.bob.myfragmentapp.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SecondFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 *
 */
class SecondFragment : Fragment(), View.OnClickListener {


    var textView: TextView? = null

    private var listener: OnFragmentInteractionListener? = null
    private var btn: Button? = null

    // 1 - Declare a buttonTag tracking
    private var buttonTag: Int = 0
    private val KEY_BTN_TAG: String = "com.example.bob.myfragmentapp.fragment.SecondFragment.KEY_BTN_TAG"

    override fun onClick(v: View?) {

        Log.d(javaClass.simpleName,"click on btn from second fragment -> back to activity..")

        listener?.onFragmentInteraction()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null) {
            val btnTagRestored: Int = savedInstanceState.getInt(KEY_BTN_TAG, 0)
            this.updateTextView(btnTagRestored)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_BTN_TAG, this.buttonTag)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var result : View? = inflater.inflate(R.layout.fragment_second, container, false)

        result?.findViewById<View>(R.id.scd_frg_btn)?.setOnClickListener(this)

        this.textView = result?.findViewById(R.id.txt_view)


        // Inflate the layout for this fragment
        return result
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction()
    }


    fun updateTextView(tag : Int) {

        this.buttonTag = tag

        when (tag) {
            10 -> this.textView?.setText("good man 1")
            20 -> this.textView?.setText("yeah 2")
            30 -> this.textView?.setText("great 3")

            else -> this.textView?.setText("No tag met !")
        }
    }

}
