package com.example.manuel.starwars.provider.planet;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.starwars.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code planet} table.
 */
public class PlanetCursor extends AbstractCursor implements PlanetModel {
    public PlanetCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(PlanetColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getName() {
        String res = getStringOrNull(PlanetColumns.NAME);
        return res;
    }

    /**
     * Get the {@code rotationperiod} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getRotationperiod() {
        String res = getStringOrNull(PlanetColumns.ROTATIONPERIOD);
        return res;
    }

    /**
     * Get the {@code orbitalperiod} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getOrbitalperiod() {
        String res = getStringOrNull(PlanetColumns.ORBITALPERIOD);
        return res;
    }

    /**
     * Get the {@code diameter} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getDiameter() {
        String res = getStringOrNull(PlanetColumns.DIAMETER);
        return res;
    }

    /**
     * Get the {@code climate} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getClimate() {
        String res = getStringOrNull(PlanetColumns.CLIMATE);
        return res;
    }

    /**
     * Get the {@code gravity} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getGravity() {
        String res = getStringOrNull(PlanetColumns.GRAVITY);
        return res;
    }

    /**
     * Get the {@code terrain} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getTerrain() {
        String res = getStringOrNull(PlanetColumns.TERRAIN);
        return res;
    }

    /**
     * Get the {@code surfacewater} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSurfacewater() {
        String res = getStringOrNull(PlanetColumns.SURFACEWATER);
        return res;
    }

    /**
     * Get the {@code population} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPopulation() {
        String res = getStringOrNull(PlanetColumns.POPULATION);
        return res;
    }
}
