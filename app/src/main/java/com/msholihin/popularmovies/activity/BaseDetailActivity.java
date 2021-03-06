package com.msholihin.popularmovies.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.msholihin.popularmovies.R;

import butterknife.Bind;

/**
 * Created by sholihin on 11/05/16.
 */
public class BaseDetailActivity extends AppCompatActivity {

    @Nullable
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    protected void setToolbar(boolean showHomeUp, boolean showTitle) {
        setToolbar(mToolbar, showHomeUp, showTitle);
    }

    public void setToolbar(Toolbar mToolbar, boolean showHomeUp, boolean showTitle) {
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeUp);
            getSupportActionBar().setDisplayShowTitleEnabled(showTitle);
        }
    }
}
