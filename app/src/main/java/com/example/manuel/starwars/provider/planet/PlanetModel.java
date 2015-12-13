package com.example.manuel.starwars.provider.planet;

import com.example.manuel.starwars.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code planet} table.
 */
public interface PlanetModel extends BaseModel {

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Get the {@code rotationperiod} value.
     * Can be {@code null}.
     */
    @Nullable
    String getRotationperiod();

    /**
     * Get the {@code orbitalperiod} value.
     * Can be {@code null}.
     */
    @Nullable
    String getOrbitalperiod();

    /**
     * Get the {@code diameter} value.
     * Can be {@code null}.
     */
    @Nullable
    String getDiameter();

    /**
     * Get the {@code climate} value.
     * Can be {@code null}.
     */
    @Nullable
    String getClimate();

    /**
     * Get the {@code gravity} value.
     * Can be {@code null}.
     */
    @Nullable
    String getGravity();

    /**
     * Get the {@code terrain} value.
     * Can be {@code null}.
     */
    @Nullable
    String getTerrain();

    /**
     * Get the {@code surfacewater} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSurfacewater();

    /**
     * Get the {@code population} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPopulation();
}
