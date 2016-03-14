package com.example.test.samplemasterdetail.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.test.samplemasterdetail.BuildConfig;
import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.MainFragment;
import com.example.test.samplemasterdetail.utils.ToonParser;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by evin on 3/10/16.
 */
public class ToonsAdapter extends RecyclerView.Adapter<ToonsAdapter.ViewHolder> {

    // TODO: 3/13/16 Change placeholders
    // TODO: 3/13/16 Placeholder images

    private static final String TAG = "ToonsAdapterTAG_";
    private static final String SIMPSONS_FLAVOR = "simpsons";

    private final List<RelatedTopic> mTopics;
    private final MainFragment mMainFragment;

    private final int IMAGE_PLACEHOLDER = (BuildConfig.FLAVOR.contains(SIMPSONS_FLAVOR))
            ? R.drawable.simpsons_placeholder
            : R.drawable.got_placeholder;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView txtTitle;
        public final ImageView imgIcon;
        public RelatedTopic relatedTopic;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.r_txt_title);
            imgIcon = (ImageView) itemView.findViewById(R.id.r_img_icon);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMainFragment.toonClicked(relatedTopic);
                }
            });
        }
    }

    public ToonsAdapter(MainFragment mainFragment, List<RelatedTopic> topics) {
        mMainFragment = mainFragment;
        mTopics = topics;
    }

    @Override
    public ToonsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View termView = inflater.inflate(R.layout.recycler_item, parent, false);

        return new ViewHolder(termView);
    }

    @Override
    public void onBindViewHolder(ToonsAdapter.ViewHolder viewHolder, int position) {
        RelatedTopic topic = mTopics.get(position);

        //We can be sure that this function always returns an array with length 2
        String[] parsedText = ToonParser.parseText(topic.getText());

        TextView textView = viewHolder.txtTitle;
        textView.setText(parsedText[0]);

        ImageView imageViewIcon = viewHolder.imgIcon;

        if (mMainFragment != null && mMainFragment.isGrid()) {
            imageViewIcon.setVisibility(View.VISIBLE);

            String url = topic.getIcon().getURL();

            if (url.isEmpty()) {
                Picasso.with(mMainFragment.getContext())
                        .load(IMAGE_PLACEHOLDER)
                        .resize(100, 100)
                        .into(imageViewIcon);
            } else {
                Picasso.with(mMainFragment.getContext())
                        .load(url)
                        .resize(100, 100)
                        .placeholder(IMAGE_PLACEHOLDER)
                        .error(IMAGE_PLACEHOLDER)
                        .into(imageViewIcon);
            }
        } else {
            imageViewIcon.setVisibility(View.GONE);
        }

        viewHolder.relatedTopic = topic;
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }
}
