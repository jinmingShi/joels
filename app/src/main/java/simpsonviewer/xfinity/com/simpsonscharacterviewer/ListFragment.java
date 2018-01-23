package simpsonviewer.xfinity.com.simpsonscharacterviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.RelatedTopicsItem;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.network.ApiClient;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.network.RetrofitClient;

/**
 * Created by Jinming on 1/23/18.
 */

public class ListFragment extends Fragment
{
    public RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    private ApiClient apiClient;
    private List<String> list;
    private final String TAG = "TAG";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        apiClient = RetrofitClient.getRetrofit().create(ApiClient.class);
    }

    public MyRecyclerViewAdapter getAdapter() {
        return adapter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        list = new ArrayList<>();
        adapter = new MyRecyclerViewAdapter(getActivity(), list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*            String item = "simpsons+characters";
                    String encodedItem = URLEncoder.encode(item, "utf-8");*/
        Call<simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.Response> call = apiClient.getData("simpsons+characters", "json");
        call.enqueue(new Callback<simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.Response>() {
            @Override
            public void onResponse(Call<simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.Response> call, Response<simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.Response> response) {
                Log.d(TAG, "onFailure: " + call.request().url());
                List<RelatedTopicsItem> res = response.body().getRelatedTopics();
                for (RelatedTopicsItem item : res) {
                    list.add(item.getText());
                }
                Log.d(TAG, "onResponse: " + list.size());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.Response> call, Throwable t) {
                Log.d("TAG", "onFailure: " + "all");
                Log.d(TAG, "onFailure: " + call.request().url());
            }
        });
    }
}
