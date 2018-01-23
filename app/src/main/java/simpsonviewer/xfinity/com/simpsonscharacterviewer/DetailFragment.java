package simpsonviewer.xfinity.com.simpsonscharacterviewer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView title;
    private TextView descriptio;

    public DetailFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        Bundle args = getArguments();
        title = view.findViewById(R.id.detailsTitle);
        descriptio = view.findViewById(R.id.detailsDescription);
        title.setText(args.get("title").toString());
        descriptio.setText(args.get("description").toString());
        String desc = args.get("description").toString();
        Log.d("Desc","check"+desc);
        return view;
    }

}
