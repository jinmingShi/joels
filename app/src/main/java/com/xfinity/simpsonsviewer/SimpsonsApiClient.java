package com.xfinity.simpsonsviewer;

import com.xfinity.simpsonsviewer.modelsimspons.MyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface SimpsonsApiClient {
  /*  String item = "MTUwNTIyODgxMDg4Mw==";

    String encodedItem = URLEncoder.encode(item, "utf-8");

    @Query(value = "item", encoded = true) String item
*/
    @GET(".")
    Call<MyResponse> getData(@Query(value = "q",encoded = true)String q , @Query("format") String format);
/*


    @FormUrlEncoded
    @POST(".")
    Call<MyResponse> getData(@Field("q") String name, @Field("format") String format);
*/
}
