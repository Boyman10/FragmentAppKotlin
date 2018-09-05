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


    override fun onClick(v: View?) {

        Log.d(javaClass.simpleName,"click on btn from second fragment -> back to activity..")

        listener?.onFragmentInteraction()
    }

    private var listener: OnFragmentInteractionListener? = null
    private var btn: Button? = null


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        var result : View? = inflater.inflate(R.layout.fragment_second, container, false)

        result?.findViewById<View>(R.id.scd_frg_btn)?.setOnClickListener(this)

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

}
