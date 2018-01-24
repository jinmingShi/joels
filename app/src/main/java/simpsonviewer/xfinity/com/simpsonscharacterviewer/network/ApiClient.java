package simpsonviewer.xfinity.com.simpsonscharacterviewer.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.MyResponse;

/**
 * Created by Jinming on 1/23/18.
 */

public interface ApiClient {
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
