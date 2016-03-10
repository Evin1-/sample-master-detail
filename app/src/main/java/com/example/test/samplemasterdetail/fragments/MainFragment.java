package com.example.test.samplemasterdetail.fragments;


import android.os.Bundle;
import android.os.StrictMode;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.adapters.ToonsAdapter;
import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.retrofit.RetrofitHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @Bind(R.id.f_main_recycler)
    RecyclerView mRecycler;

    ToonsAdapter mToonsAdapter;
    List<RelatedTopic> mTopics;

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);

        mTopics = new ArrayList<>();
        mToonsAdapter = new ToonsAdapter(mTopics);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecycler.setAdapter(mToonsAdapter);
        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        refreshRecycler();
    }

    private void refreshRecycler() {

        // TODO: 3/10/16 Remove StrictMode

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        RetrofitHelper retrofitHelper = new RetrofitHelper();
        mTopics.addAll(retrofitHelper.getCharacters());
        mToonsAdapter.notifyDataSetChanged();
    }
}
