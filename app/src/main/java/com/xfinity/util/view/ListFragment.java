package com.xfinity.util.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.xfinity.BuildConfig;
import com.xfinity.R;
import com.xfinity.gotviewer.modelgot.ResponseGot;
import com.xfinity.simpsonsviewer.modelsimspons.MyResponse;
import com.xfinity.simpsonsviewer.modelsimspons.RelatedTopicsItem;
import com.xfinity.gotviewer.GotApiClient;
import com.xfinity.simpsonsviewer.SimpsonsApiClient;
import com.xfinity.util.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.xfinity.util.Constants.*;


public class ListFragment extends Fragment {
    public RecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    private SimpsonsApiClient simpsonsApiClient;
    private GotApiClient gotApiClient;
    private List<String> list;
    private List<String> urls;
    private final String TAG = "TAG";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simpsonsApiClient = RetrofitClient.getRetrofit().create(SimpsonsApiClient.class);
        gotApiClient = RetrofitClient.getRetrofit().create(GotApiClient.class);
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
        if(BuildConfig.FLAVOR.equals("simpsons")) {
            networkCallForSimpsons();
        }
        else if(BuildConfig.FLAVOR.equals("got")) {
            networkCallForGot();
        }
    }


    /**
     * networkCallForGot hits the got webserver and fetches the data for the GOT network call
     */
    private void networkCallForGot() {
        ((MainActivity) getActivity()).setActionBarTitle(GOT_ACTION_BAR);
        Call<ResponseGot> call = gotApiClient.getData("the+wire+characters", "json");
        call.enqueue(new Callback<ResponseGot>() {
            @Override
            public void onResponse(Call<ResponseGot> call, Response<ResponseGot> response) {
                List<com.xfinity.gotviewer.modelgot.RelatedTopicsItem> res = response.body().getRelatedTopics();
                for (com.xfinity.gotviewer.modelgot.RelatedTopicsItem item : res) {
                    list.add(item.getText());
                    urls.add(item.getIcon().getURL());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ResponseGot> call, Throwable t) {
                Log.d("TAG", "onFailure: " + "all");
                Toast.makeText(getContext(),"Xfinity webservices DONT WORK AS WELL!!!!",Toast.LENGTH_LONG).show();
                Log.d(TAG, "onFailure: " + call.request().url());
            }
        });
    }


    /**
     * networkCallForSimpsons hits the Simpsons webserver and fetches the data for the Simpsons network call
     */
    private void networkCallForSimpsons() {
        ((MainActivity) getActivity()).setActionBarTitle(SIMPSON_ACTION_BAR);
        Call<MyResponse> call = simpsonsApiClient.getData("simpsons+characters", "json");
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
