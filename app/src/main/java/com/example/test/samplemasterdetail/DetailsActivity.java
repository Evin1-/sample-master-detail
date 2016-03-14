package com.example.test.samplemasterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.DetailsFragment;
import com.example.test.samplemasterdetail.utils.ToonParser;

public class DetailsActivity extends AppCompatActivity {

    // TODO: 3/13/16 Fix details information bug

    private static final String TAG = "DetailsActivityTAG_";

    private DetailsFragment mDetailsFragment;
    private RelatedTopic mTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        retrieveFragments();
        setupToolbar();
        retrieveTopic();
        setTitleBar();
    }

    private void setTitleBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            String title = (mTopic != null)
                    ? ToonParser.parseText(mTopic.getText())[0]
                    : getString(R.string.activity_details_name);
            actionBar.setTitle(title);
            actionBar.setSubtitle(R.string.activity_details_name);
        }
    }


    private void retrieveFragments() {
        mDetailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details_fragment);
    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    private void retrieveTopic() {
        Intent incomingIntent = getIntent();
        if (incomingIntent.hasExtra(MainActivity.DETAILS_KEY)) {
            mTopic = incomingIntent.getParcelableExtra(MainActivity.DETAILS_KEY);
            if (mDetailsFragment != null) {
                mDetailsFragment.refreshDetails(mTopic);
            }
        }
    }
}
