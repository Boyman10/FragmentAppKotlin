package com.example.bob.myfragmentapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.bob.myfragmentapp.R;
import com.example.bob.myfragmentapp.fragment.MainFragment;
import com.example.bob.myfragmentapp.fragment.SecondFragment;

public class DynamicFragActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener, SecondFragment.OnFragmentInteractionListener {

    private MainFragment mainFrg;
    private SecondFragment scdFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_frag);

        this.configureAndShowMainFragment();
        // 2 - Configure and show detail fragment
        this.configureAndShowSecondFragment();
    }

    /**
     * Displaying main fragment within frame layout
     */
    private void configureAndShowMainFragment() {

        mainFrg = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_main);

        // if not defined within layout
        // we create a new instance and attach it to the activity
        if (mainFrg == null) {
            mainFrg = new MainFragment();
            getSupportFragmentManager().beginTransaction() // support older android versions < 3.0
                    .add(R.id.frame_layout_main, mainFrg)
                    .commit();
        }

    }
    private void configureAndShowSecondFragment() {

        scdFrg = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout_detail);

        if (scdFrg == null && findViewById(R.id.frame_layout_detail) != null) {

            scdFrg = new SecondFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frame_layout_detail, scdFrg)
                    .commit();
        }
    }



    @Override
    public void onButtonClicked(View view) {

        int buttonTag = Integer.parseInt(view.getTag().toString());

        Log.d(this.getClass().getSimpleName(), "Clicked received from fragment to dynamic activity..." + buttonTag);

        if (scdFrg != null && scdFrg.isVisible()) {

            // Case of a tablet - we directly talk to the other fragment
            scdFrg.updateTextView(buttonTag);
        } else {

            // Case mobile phone - intent passing
            Intent intent = new Intent(this,DynamicSecondActivity.class);
            intent.putExtra(DynamicSecondActivity.EXTRA_BUTTON_TAG, buttonTag);
            startActivity(intent);
        }

    }

    @Override
    public void onFragmentInteraction() {
        Log.d(this.getClass().getSimpleName(), "Got back the click from fragment - a dynamic one !!");
    }
}
