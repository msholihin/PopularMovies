package com.msholihin.popularmovies.loader;

import android.content.Context;
import android.util.Log;

import com.msholihin.popularmovies.BuildConfig;
import com.msholihin.popularmovies.http.HttpUtil;
import com.msholihin.popularmovies.model.MovieData;
import com.msholihin.popularmovies.model.MovieResults;
import com.msholihin.popularmovies.util.Constants;
import com.msholihin.popularmovies.util.PreferenceUtil;

import java.io.IOException;
import java.util.List;

import retrofit.Call;
import retrofit.Response;

/**
 * Created by sholihin on 11/05/16.
 */
public class ResultsLoader extends CommonTaskLoader {
    private static final String TAG = "ResultsLoader";

    public ResultsLoader(Context context) {
        super(context);
    }

    @Override
    public List<MovieData> loadInBackground() {
        Call<MovieResults> createdCall = HttpUtil.getService().getMovieResults(BuildConfig.THE_MOVIE_DB_API_KEY, PreferenceUtil.getPrefs(getContext(), Constants.MODE_VIEW, Constants.SORT_BY_POPULARITY_DESC));
        try {
            Response<MovieResults> result = createdCall.execute();
            return result.body().results;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(TAG, "IOException occurred in loadInBackground()");
        }
        return null;
    }
}