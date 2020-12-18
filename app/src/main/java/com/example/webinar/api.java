package com.example.webinar;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class api {


    private static final String url = "https://newsapi.org/v2/";

    private static Postservices postservices = null;

    static Postservices getPostservices() {
        if (postservices == null) {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
            postservices = retrofit.create(Postservices.class);
        }
        return postservices;
    }




    public interface Postservices {
        @GET("top-headlines")
        Call<PostList> getpostlist(@Query("country") String country, @Query("apiKey")String apikey);


    }

}
