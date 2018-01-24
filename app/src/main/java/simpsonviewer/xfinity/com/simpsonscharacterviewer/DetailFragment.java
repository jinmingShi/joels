package simpsonviewer.xfinity.com.simpsonscharacterviewer;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView title;
    private TextView descriptio;
    private ImageView imageView;
    public DetailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        title = view.findViewById(R.id.detailsTitle);
        descriptio = view.findViewById(R.id.detailsDescription);
        imageView = view.findViewById(R.id.detailsImage);

        Bundle args = getArguments();
        title.setText(args.get("title").toString());
        descriptio.setText(args.get("description").toString());
        String s = (String)args.get("image");
        if (s != null && !s.isEmpty()) {
            Picasso.with(getContext())
                    .load(s)
                    .into(imageView);
        }
        return view;
    }
}
