package com.example.manuel.starwars.provider.movies;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.starwars.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code movies} table.
 */
public class MoviesCursor extends AbstractCursor implements MoviesModel {
    public MoviesCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(MoviesColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTitle() {
        String res = getStringOrNull(MoviesColumns.TITLE);
        return res;
    }

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPopularity() {
        String res = getStringOrNull(MoviesColumns.POPULARITY);
        return res;
    }

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOverview() {
        String res = getStringOrNull(MoviesColumns.OVERVIEW);
        return res;
    }

    /**
     * Get the {@code posterpath} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPosterpath() {
        String res = getStringOrNull(MoviesColumns.POSTERPATH);
        return res;
    }
}
