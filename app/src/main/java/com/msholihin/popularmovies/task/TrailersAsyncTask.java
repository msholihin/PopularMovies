package com.msholihin.popularmovies.task;

import android.util.Log;
import android.widget.ProgressBar;

import com.msholihin.popularmovies.BuildConfig;
import com.msholihin.popularmovies.http.HttpUtil;
import com.msholihin.popularmovies.model.Trailer;
import com.msholihin.popularmovies.model.TrailersResults;

import java.io.IOException;
import java.util.ArrayList;

import retrofit.Call;
import retrofit.Response;

/**
 * Created by sholihin on 11/05/16.
 */
public class TrailersAsyncTask extends CommonAsyncTask<Trailer> {

    private static final String TAG = "TrailersAsyncTask";

    private long mMovieId;

    public TrailersAsyncTask(long mMovieId, ProgressBar mProgressBar, FetchDataListener mListener) {
        super(mProgressBar, mListener);
        this.mMovieId = mMovieId;
    }


    @Override
    protected ArrayList<Trailer> doInBackground(Void... params) {

        Call<TrailersResults> createdCall = HttpUtil.getService().getTrailersResults(mMovieId, BuildConfig.THE_MOVIE_DB_API_KEY);
        try {
            Response<TrailersResults> result = createdCall.execute();
            return result.body().results;
        } catch (IOException e) {
            Log.e(TAG, "IOException occurred in doInBackground()");
        }
        return null;
    }

}
