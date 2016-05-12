package com.msholihin.popularmovies.loader;

import android.content.Context;

import com.msholihin.popularmovies.model.MovieData;
import com.msholihin.popularmovies.provider.FavoriteMovieContentProvider;

import java.util.List;

/**
 * Created by sholihin on 11/05/16.
 */
public class FavoriteResultsLoader extends CommonTaskLoader {
    private static final String TAG = "FavoriteResultsLoader";

    public FavoriteResultsLoader(Context context) {
        super(context);
    }

    @Override
    public List<MovieData> loadInBackground() {
        return FavoriteMovieContentProvider.getFavorites(getContext());
    }
}