package simpsonviewer.xfinity.com.simpsonscharacterviewer;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.RelatedTopicsItem;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.CustomViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<String> relatedTopicsItems;
    boolean isSwitchView = true;
    private static final int LIST_ITEM = 0;
    private static final int GRID_ITEM = 1;
    String title,description;
    public ClickOnItemListener listener;

    interface ClickOnItemListener {
        void onClickOnItemListender(String title, String description);
    }

    public MyRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        listener = (ClickOnItemListener) context;
        this.relatedTopicsItems = list;
        inflater = LayoutInflater.from(context);
    }
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
            view = LayoutInflater.from(parent.getContext()).inflate( R.layout.response_cardview, null);
        }else{
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.response_cardview_grid, null);
        }
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
       String[] Title =relatedTopicsItems.get(position).split("-");
       title = Title[0];
       description  = Title[1];
       holder.text.setText("Text: " + title);
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
        TextView text;

        CustomViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.shipmentid);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] Title =relatedTopicsItems.get(getAdapterPosition()).split("-");
                    String ti = Title[0];
                    String desc = Title[1];
                    listener.onClickOnItemListender(ti, desc);
                }
            });
        }
    }
}
