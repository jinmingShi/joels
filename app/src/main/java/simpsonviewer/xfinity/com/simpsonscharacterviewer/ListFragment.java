package simpsonviewer.xfinity.com.simpsonscharacterviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.MyResponse;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.RelatedTopicsItem;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.network.ApiClient;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.network.RetrofitClient;

/**
 * Created by Jinming on 1/23/18.
 */

public class ListFragment extends Fragment {
    public RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    private ApiClient apiClient;
    private List<String> list;
    private List<String> urls;
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
        list = new ArrayList<>();
        urls = new ArrayList<>();

        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        adapter = new MyRecyclerViewAdapter(getActivity(), list, urls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Call<MyResponse> call = apiClient.getData("simpsons+characters", "json");
        call.enqueue(new Callback<MyResponse>() {
            @Override
            public void onResponse(Call<MyResponse> call, Response<MyResponse> response) {
                List<RelatedTopicsItem> res = response.body().getRelatedTopics();
                for (RelatedTopicsItem item : res) {
                    list.add(item.getText());
                    urls.add(item.getIcon().getURL());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MyResponse> call, Throwable t) {
                Log.d("TAG", "onFailure: " + "all");
                Log.d(TAG, "onFailure: " + call.request().url());
            }
        });
    }
}
