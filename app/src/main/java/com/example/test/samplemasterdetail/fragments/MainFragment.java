package com.example.test.samplemasterdetail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.adapters.ToonsAdapter;
import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.tasks.CharactersTask;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private static final String TAG = "MainFragmentTAG_";
    @Bind(R.id.f_main_recycler)
    RecyclerView mRecycler;

    ToonsAdapter mToonsAdapter;
    List<RelatedTopic> mTopics;

    public MainFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mTopics = new ArrayList<>();
        mToonsAdapter = new ToonsAdapter(mTopics);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecycler.setAdapter(mToonsAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(null));
        refreshRecycler(true);
    }

    private void refreshRecycler(boolean overrideSavedInstance) {
        if (overrideSavedInstance) {
            new CharactersTask(this).execute();
        }
    }

    public void refreshResults(List<RelatedTopic> relatedTopics) {
        if (relatedTopics != null) {
            mTopics.clear();
            mTopics.addAll(relatedTopics);
            mToonsAdapter.notifyDataSetChanged();
        }
    }
}
