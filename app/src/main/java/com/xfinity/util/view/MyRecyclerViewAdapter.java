package com.xfinity.util.view;


import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xfinity.R;

import java.util.List;

/**
 * Adapter for the recyclerView
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder>
implements  ISelectedTopic{
    private Context context;
    private LayoutInflater inflater;
    List<String> relatedTopicsItems;
    List<String> urls;

    boolean isSwitchView = true;
    //LIST_ITEM and GRID_ITEM are variables to check ad set the change in the layouts
    private static final int LIST_ITEM = 0;
    private static final int GRID_ITEM = 1;

    String title,description;
    public ClickOnItemListener listener;

    @Override
    public void onTopicSelected(String title, String description, String url) {
        listener.onClickOnItemListener(title, description, url);

    }

    //Custom interface to pass data between the fragments.
    public interface ClickOnItemListener {
        void onClickOnItemListener(String title, String description, String image);
    }

    //Constructor for the Adapter
    public MyRecyclerViewAdapter(Context context, List<String> list, List<String> urls) {
        this.context = context;
        listener = (ClickOnItemListener) context;
        this.relatedTopicsItems = list;
        this.urls = urls;
        inflater = LayoutInflater.from(context);
    }

    /**
     * returns
     * @param position
     * @return
     */
    @Override
    public int getItemViewType (int position) {
        if (isSwitchView){
            return LIST_ITEM;
        }else{
            return GRID_ITEM;
        }
    }
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       // View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.response_cardview,null);
        View view;
        if (viewType == LIST_ITEM){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.response_cardview, null);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.response_cardview_grid, null);
        }
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        if(position %2==0)
            holder.itemView.setBackgroundColor(Color.GRAY);
        else
            holder.itemView.setBackgroundColor(Color.LTGRAY);
       String[] Title = relatedTopicsItems.get(position).split("-");
       title = Title[0];
       description  = Title[1];
       holder.text.setText(title);

       if (urls.get(position).isEmpty() || urls.get(position) == null) {
            holder.imageView.setImageResource(R.mipmap.ic_launcher);
        } else {
            Picasso.with(context)
                    .load(urls.get(position))
                    .into(holder.imageView);
        }
    }


    public boolean toggleItemViewType () {
        isSwitchView = !isSwitchView;
        return isSwitchView;
    }
    @Override
    public int getItemCount() {
        return relatedTopicsItems.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        private ImageView imageView;

        CustomViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.shipmentid);
            imageView = view.findViewById(R.id.imageView);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] Title =relatedTopicsItems.get(getAdapterPosition()).split("-");
                    String ti = Title[0];
                    String desc = Title[1];
                    onTopicSelected(ti,desc,urls.get(getAdapterPosition()));
                }
            });
        }
    }


}
