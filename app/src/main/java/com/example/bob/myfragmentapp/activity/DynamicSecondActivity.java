package com.example.bob.myfragmentapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.bob.myfragmentapp.R;
import com.example.bob.myfragmentapp.fragment.SecondFragment;

public class DynamicSecondActivity extends AppCompatActivity {

    SecondFragment scdFrg;

    static final String EXTRA_BUTTON_TAG = "BTN_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_second);

        this.configureAndShowSecondFragment();
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
}
