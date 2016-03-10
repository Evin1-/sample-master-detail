package com.example.test.samplemasterdetail.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.entities.RelatedTopic;
import com.example.test.samplemasterdetail.fragments.MainFragment;
import com.example.test.samplemasterdetail.utils.ToonParser;

import java.util.List;

/**
 * Created by evin on 3/10/16.
 */
public class ToonsAdapter extends RecyclerView.Adapter<ToonsAdapter.ViewHolder> {

    private static final String TAG = "ToonsAdapterTAG_";
    private final List<RelatedTopic> mTopics;
    private final MainFragment mMainFragment;

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView txtTitle;
        public RelatedTopic relatedTopic;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.r_txt_title);

            txtTitle.setOnClickListener(new View.OnClickListener() {
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

        viewHolder.relatedTopic = topic;
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }
}
