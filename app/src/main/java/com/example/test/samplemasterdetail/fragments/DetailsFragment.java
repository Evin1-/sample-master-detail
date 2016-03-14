package com.example.test.samplemasterdetail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.entities.RelatedTopic;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

    private static final String TAG = "DetailsFragmentTAG_";
    private RelatedTopic mTopic;

    @Bind(R.id.f_details_txt)
    TextView mTextView;

    public DetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    public void refreshDetails(RelatedTopic relatedTopic) {
        mTextView.setText(relatedTopic.getText());
    }
}
