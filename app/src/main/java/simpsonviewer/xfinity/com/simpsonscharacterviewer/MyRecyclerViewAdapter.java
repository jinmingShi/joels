package simpsonviewer.xfinity.com.simpsonscharacterviewer;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

    public MyRecyclerViewAdapter(Context context, List<String> list) {
        this.context = context;
        this.relatedTopicsItems = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.response_cardview,null);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
       String[] Title =relatedTopicsItems.get(position).split("-");
       String title = Title[0];
       String description  = Title[1];

       holder.text.setText("Text: " + title);
      // holder.shipmentstatus.setText("Description: " +description );
       // holder.packageName.setText("Package Name: " + item.getPackagename());
       // String bitMapString = item.getShipmentid();
       // Bitmap bitmap = generateBarCode(bitMapString);
       // holder.barCode.setImageBitmap(bitmap);
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
        TextView shipmentstatus;
        TextView packageName;
        //TextView member_name;
        ImageView barCode;

        CustomViewHolder(View view) {
            super(view);
            text = view.findViewById(R.id.shipmentid);
            //shipmentstatus = view.findViewById(R.id.shipmentstatus);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, " " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
