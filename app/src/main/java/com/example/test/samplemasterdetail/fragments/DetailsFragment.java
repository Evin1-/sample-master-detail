package com.example.test.samplemasterdetail.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.samplemasterdetail.BuildConfig;
import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.utils.PrefsHelper;
import com.example.test.samplemasterdetail.utils.ToonParser;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment {

        // TODO: 3/14/16 Check if mTopic not null textViewFav at first

    private static final String TAG = "DetailsFragmentTAG_";
    private RelatedTopic mTopic;

    private static final String SIMPSONS_FLAVOR = "simpsons";

    @Bind(R.id.f_details_txt)
    TextView mTextView;
    @Bind(R.id.f_details_img_background)
    ImageView mImageView;
    @Bind(R.id.f_details_fav_txt)
    TextView mTextViewFav;

    private boolean isFavorite;

    private final int IMAGE_PLACEHOLDER = (BuildConfig.FLAVOR.contains(SIMPSONS_FLAVOR))
            ? R.drawable.simpsons_placeholder
            : R.drawable.got_placeholder;

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

    @OnClick(R.id.f_details_fav_txt)
    public void detailsFavClick(){
        Log.d(TAG, "detailsFavClick: ");
    }

    public void refreshDetails(RelatedTopic relatedTopic) {
        if (relatedTopic == null) {
            return;
        }

        mTopic = relatedTopic;
        checkIfFavorite();

        String[] parsedText = ToonParser.parseText(mTopic.getText());
        setImageOrPlaceholder(mTopic, mImageView);
        mTextView.setText(parsedText[1]);
    }

    private void checkIfFavorite() {
        String title = ToonParser.parseText(mTopic.getText())[0];
        isFavorite = PrefsHelper.isFavorite(getContext(), title);

        if (isFavorite) {
            mTextViewFav.setText(getText(R.string.details_fragment_remove_favorites_button));
        } else {
            mTextViewFav.setText(getText(R.string.details_fragment_add_favorites_button));
        }
    }

    private void setImageOrPlaceholder(RelatedTopic topic, ImageView imageViewIcon) {
        if (topic == null) {
            return;
        }

        String url = topic.getIcon().getURL();

        if (url.isEmpty()) {
            Picasso.with(getContext())
                    .load(IMAGE_PLACEHOLDER)
                    .into(imageViewIcon);
        } else {
            Picasso.with(getContext())
                    .load(url)
                    .error(IMAGE_PLACEHOLDER)
                    .into(imageViewIcon);
        }
    }

}
