package com.example.manuel.starwars.provider.movies;


import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.Nullable;

import com.example.manuel.starwars.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code movies} table.
 */
public class MoviesContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return MoviesColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable MoviesSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable MoviesSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public MoviesContentValues putTitle(@Nullable String value) {
        mContentValues.put(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesContentValues putTitleNull() {
        mContentValues.putNull(MoviesColumns.TITLE);
        return this;
    }

    public MoviesContentValues putPopularity(@Nullable String value) {
        mContentValues.put(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesContentValues putPopularityNull() {
        mContentValues.putNull(MoviesColumns.POPULARITY);
        return this;
    }

    public MoviesContentValues putOverview(@Nullable String value) {
        mContentValues.put(MoviesColumns.OVERVIEW, value);
        return this;
    }

    public MoviesContentValues putOverviewNull() {
        mContentValues.putNull(MoviesColumns.OVERVIEW);
        return this;
    }

    public MoviesContentValues putPosterpath(@Nullable String value) {
        mContentValues.put(MoviesColumns.POSTERPATH, value);
        return this;
    }

    public MoviesContentValues putPosterpathNull() {
        mContentValues.putNull(MoviesColumns.POSTERPATH);
        return this;
    }
}
