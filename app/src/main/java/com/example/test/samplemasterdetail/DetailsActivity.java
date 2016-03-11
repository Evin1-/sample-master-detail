package com.example.test.samplemasterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.DetailsFragment;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivityTAG_";

    private DetailsFragment mDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDetailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details_fragment);

        retrieveTopic();
    }

    private void retrieveTopic() {
        Intent incomingIntent = getIntent();
        if (incomingIntent.hasExtra(MainActivity.DETAILS_KEY)) {
            RelatedTopic relatedTopic = incomingIntent.getParcelableExtra(MainActivity.DETAILS_KEY);
            if (mDetailsFragment != null) {
                mDetailsFragment.refreshDetails(relatedTopic);
            }
        }
    }
}
