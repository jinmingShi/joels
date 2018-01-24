package com.xfinity.gotviewer;

import com.xfinity.gotviewer.modelgot.ResponseGot;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface GotApiClient {
    @GET(".")
    Call<ResponseGot> getData(@Query(value = "q", encoded = true) String q, @Query("format") String format);
}
