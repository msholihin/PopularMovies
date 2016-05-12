package com.msholihin.popularmovies.task;

import android.util.Log;
import android.widget.ProgressBar;

import com.msholihin.popularmovies.BuildConfig;
import com.msholihin.popularmovies.http.HttpUtil;
import com.msholihin.popularmovies.model.Review;
import com.msholihin.popularmovies.model.ReviewResults;

import java.io.IOException;
import java.util.ArrayList;

import retrofit.Call;
import retrofit.Response;

/**
 * Created by sholihin on 11/05/16.
 */
public class ReviewsAsyncTask extends CommonAsyncTask<Review> {

    private static final String TAG = "ReviewsAsyncTask";
    private final long mMovieId;

    public ReviewsAsyncTask(long movieId, ProgressBar mProgressBar, FetchDataListener mListener) {
        super(mProgressBar, mListener);
        this.mMovieId = movieId;
    }

    @Override
    protected ArrayList<Review> doInBackground(Void... params) {
        Call<ReviewResults> createdCall = HttpUtil.getService().getReviewsResults(mMovieId, BuildConfig.THE_MOVIE_DB_API_KEY);
        try {
            Response<ReviewResults> result = createdCall.execute();
            return result.body().results;
        } catch (IOException e) {
            Log.e(TAG, "IOException occurred in doInBackground()");
        }
        return null;
    }
}
