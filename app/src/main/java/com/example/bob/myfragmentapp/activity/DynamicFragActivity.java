package com.example.bob.myfragmentapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.bob.myfragmentapp.R;
import com.example.bob.myfragmentapp.fragment.MainFragment;

public class DynamicFragActivity extends AppCompatActivity implements MainFragment.OnButtonClickedListener {

    private MainFragment mainFrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_frag);

        this.configureAndShowMainFragment();
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

    @Override
    public void onButtonClicked(View view) {
        Log.d(this.getClass().getSimpleName(), "Clicked received from fragment to dynamic activity...");
    }
}
