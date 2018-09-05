package com.example.bob.myfragmentapp.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.bob.myfragmentapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements View.OnClickListener {


    public MainFragment() {
        // Required empty public constructor
    }

    // Declare the interface which is going to be implemented by any container activity listening to this fragment@
    public interface OnButtonClickedListener {
        public void onButtonClicked(View view);
    }

    // Declare callback here :
    private OnButtonClickedListener mCallback;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View result = inflater.inflate(R.layout.fragment_main, container, false);

        result.findViewById(R.id.fgt_main_btn).setOnClickListener(this);

        // Inflate the layout for this fragment
        return result;
    }

    /**
     * We are sure in this event that the fragment is attached to its parent.
     * @param context
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        this.createCallbackToParentActivity();
    }

    @Override
    public void onClick(View v) {

        Log.d(this.getClass().getSimpleName(),"Just clicking the button from main fragment...");
        mCallback.onButtonClicked(v);

    }

    // ----------------
    // FRAGMENT SUPPORT
    // ----------------

    private void createCallbackToParentActivity() {

        try {
            mCallback = (OnButtonClickedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(e.toString() + " must implement OnButtonClickedListener");
        }

    }
}
