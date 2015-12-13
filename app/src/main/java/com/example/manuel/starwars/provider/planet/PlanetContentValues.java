package com.example.manuel.starwars.provider.planet;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.starwars.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code planet} table.
 */
public class PlanetContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return PlanetColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable PlanetSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable PlanetSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public PlanetContentValues putName(@Nullable String value) {
        mContentValues.put(PlanetColumns.NAME, value);
        return this;
    }

    public PlanetContentValues putNameNull() {
        mContentValues.putNull(PlanetColumns.NAME);
        return this;
    }

    public PlanetContentValues putRotationperiod(@Nullable String value) {
        mContentValues.put(PlanetColumns.ROTATIONPERIOD, value);
        return this;
    }

    public PlanetContentValues putRotationperiodNull() {
        mContentValues.putNull(PlanetColumns.ROTATIONPERIOD);
        return this;
    }

    public PlanetContentValues putOrbitalperiod(@Nullable String value) {
        mContentValues.put(PlanetColumns.ORBITALPERIOD, value);
        return this;
    }

    public PlanetContentValues putOrbitalperiodNull() {
        mContentValues.putNull(PlanetColumns.ORBITALPERIOD);
        return this;
    }

    public PlanetContentValues putDiameter(@Nullable String value) {
        mContentValues.put(PlanetColumns.DIAMETER, value);
        return this;
    }

    public PlanetContentValues putDiameterNull() {
        mContentValues.putNull(PlanetColumns.DIAMETER);
        return this;
    }

    public PlanetContentValues putClimate(@Nullable String value) {
        mContentValues.put(PlanetColumns.CLIMATE, value);
        return this;
    }

    public PlanetContentValues putClimateNull() {
        mContentValues.putNull(PlanetColumns.CLIMATE);
        return this;
    }

    public PlanetContentValues putGravity(@Nullable String value) {
        mContentValues.put(PlanetColumns.GRAVITY, value);
        return this;
    }

    public PlanetContentValues putGravityNull() {
        mContentValues.putNull(PlanetColumns.GRAVITY);
        return this;
    }

    public PlanetContentValues putTerrain(@Nullable String value) {
        mContentValues.put(PlanetColumns.TERRAIN, value);
        return this;
    }

    public PlanetContentValues putTerrainNull() {
        mContentValues.putNull(PlanetColumns.TERRAIN);
        return this;
    }

    public PlanetContentValues putSurfacewater(@Nullable String value) {
        mContentValues.put(PlanetColumns.SURFACEWATER, value);
        return this;
    }

    public PlanetContentValues putSurfacewaterNull() {
        mContentValues.putNull(PlanetColumns.SURFACEWATER);
        return this;
    }

    public PlanetContentValues putPopulation(@Nullable String value) {
        mContentValues.put(PlanetColumns.POPULATION, value);
        return this;
    }

    public PlanetContentValues putPopulationNull() {
        mContentValues.putNull(PlanetColumns.POPULATION);
        return this;
    }
}
