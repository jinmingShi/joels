package simpsonviewer.xfinity.com.simpsonscharacterviewer.network;

import java.net.URLEncoder;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import simpsonviewer.xfinity.com.simpsonscharacterviewer.Model.Response;

/**
 * Created by Jinming on 1/23/18.
 */

public interface ApiClient {
  /*  String item = "MTUwNTIyODgxMDg4Mw==";

    String encodedItem = URLEncoder.encode(item, "utf-8");

    @Query(value = "item", encoded = true) String item
*/
    @GET(".")
    Call<Response> getData(@Query(value = "q",encoded = true)String q , @Query("format") String format);
/*


    @FormUrlEncoded
    @POST(".")
    Call<Response> getData(@Field("q") String name, @Field("format") String format);
*/
}
