package com.example.manuel.starwars.provider.movies;

import com.example.manuel.starwars.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code movies} table.
 */
public interface MoviesModel extends BaseModel {

    /**
     * Get the {@code title} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTitle();

    /**
     * Get the {@code popularity} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPopularity();

    /**
     * Get the {@code overview} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOverview();

    /**
     * Get the {@code posterpath} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPosterpath();
}
