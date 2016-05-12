package com.msholihin.popularmovies.http;


import com.msholihin.popularmovies.util.Constants;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by sholihin on 11/05/16.
 */
public class HttpUtil {

    private static MovieDBService service;

    static {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.MOVIE_URL).addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(MovieDBService.class);
    }

    public static MovieDBService getService() {
        return service;
    }
}
