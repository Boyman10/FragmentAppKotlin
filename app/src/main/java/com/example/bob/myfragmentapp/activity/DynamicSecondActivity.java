package com.example.bob.myfragmentapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.bob.myfragmentapp.R;
import com.example.bob.myfragmentapp.fragment.SecondFragment;

public class DynamicSecondActivity extends AppCompatActivity implements SecondFragment.OnFragmentInteractionListener {

    SecondFragment scdFrg;

    public static final String EXTRA_BUTTON_TAG = "BTN_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_second);

        this.configureAndShowSecondFragment();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // call update method here as we are sure our second fragment is visible
        this.updateFragmentTextViewWithTag();
    }


    /**
     * Method used on resumed for mobile devices - receiving tag via intent
     */
    private void updateFragmentTextViewWithTag() {

        int buttonTag = getIntent().getIntExtra(EXTRA_BUTTON_TAG, 0);

        scdFrg.updateTextView(buttonTag);
    }

    private void configureAndShowSecondFragment() {

        scdFrg = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (scdFrg == null) {
            scdFrg = new SecondFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, scdFrg)
                    .commit();
        }
    }

    @Override
    public void onFragmentInteraction() {
        Log.d(this.getClass().getSimpleName(),"Back to second dynamic activity");
    }
}
