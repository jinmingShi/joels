package com.xfinity.util.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.xfinity.R;

import static com.xfinity.util.Constants.NULL_TITLE;


/**
 * Detail Fragment shows the details of the item the user clicks on.
 */
public class DetailFragment extends Fragment {

    public static String ARG_POSITION = "position";
    private TextView title;
    private TextView description;
    private ImageView imageView;
    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        title = view.findViewById(R.id.detailsTitle);
        description = view.findViewById(R.id.detailsDescription);
        imageView = view.findViewById(R.id.detailsImage);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadDetailsFragment();
    }

    /**
     * loadDetailsFragment sets the title, description and the image to the view.
     * Receives the arguments that are set in the list fragment and displays it on the screen.
     * The action bar title is also set using the title of the item clicked
     */
    private void loadDetailsFragment() {
        Bundle args = getArguments();
        if(args == null){
            title.setText(NULL_TITLE);
            description.setText(NULL_TITLE);
        }else {
            ((MainActivity) getActivity()).setActionBarTitle(args.get("title").toString());
            title.setText(args.get("title").toString());
            description.setText(args.get("description").toString());
            String s = (String)args.get("image");
            if (s != null && !s.isEmpty()) {
                Picasso.with(getContext())
                        .load(s)
                        .into(imageView);
            }
        }
    }

    public void updateArticleView(String mtitle, String mdescription, String image) {
        this.title.setText(mtitle);
        description.setText(mdescription);
        if (image != null && !image.isEmpty()) {
            Picasso.with(getContext())
                    .load(image)
                    .into(imageView);
        }
    }
}
