package com.example.test.samplemasterdetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.DetailsFragment;
import com.example.test.samplemasterdetail.fragments.MainFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MainFragment.OnToonClickCallback {
    private static final String TAG = "MainActivityTAG_";

    public static final String DETAILS_KEY = "BUNDLE_DETAILS_KEY";

    private MainFragment mMainFragment;
    private DetailsFragment mDetailsFragment;

    // TODO: 3/10/16 Change icon menu

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mMainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);
        mDetailsFragment = (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.details_fragment);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.main_menu_toggle).setVisible(!isTablet());

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.main_menu_settings) {
            return true;
        }

        if (id == R.id.main_menu_toggle) {
            refreshRecyclerLayout();
        }

        return super.onOptionsItemSelected(item);
    }

    private void refreshRecyclerLayout() {
        if (mMainFragment != null) {
            mMainFragment.toggleGrid();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private boolean isTablet() {
        return mDetailsFragment != null && mDetailsFragment.isAdded();
    }

    @Override
    public void toonClicked(RelatedTopic relatedTopic) {
        if (isTablet()) {
            refreshDetailsFragment(relatedTopic);
        } else {
            launchDetailsActivity(relatedTopic);
        }
    }

    private void launchDetailsActivity(RelatedTopic relatedTopic) {
        Log.d(TAG, "launchDetailsActivity: ");
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        intent.putExtra(DETAILS_KEY, relatedTopic);
        startActivity(intent);
    }

    private void refreshDetailsFragment(RelatedTopic relatedTopic) {
        Log.d(TAG, "refreshDetailsFragment: ");
        if (mDetailsFragment != null) {
            mDetailsFragment.refreshDetails(relatedTopic);
        }
    }
}
