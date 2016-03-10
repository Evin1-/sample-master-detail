package com.example.test.samplemasterdetail.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.test.samplemasterdetail.R;
import com.example.test.samplemasterdetail.entities.RelatedTopic;

import java.util.List;

/**
 * Created by evin on 3/10/16.
 */
public class ToonsAdapter extends RecyclerView.Adapter<ToonsAdapter.ViewHolder> {

    private static final String TAG = "ToonsAdapterTAG_";
    private final List<RelatedTopic> mTopics;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView txtTitle;

        public ViewHolder(View itemView) {
            super(itemView);

            txtTitle = (TextView) itemView.findViewById(R.id.r_txt_title);
        }
    }

    public ToonsAdapter(List<RelatedTopic> topics) {
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

        TextView textView = viewHolder.txtTitle;
        textView.setText(topic.getText());
    }

    @Override
    public int getItemCount() {
        return mTopics.size();
    }
}
