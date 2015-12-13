package com.example.manuel.starwars.provider.planet;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.manuel.starwars.provider.base.AbstractSelection;

/**
 * Selection for the {@code planet} table.
 */
public class PlanetSelection extends AbstractSelection<PlanetSelection> {
    @Override
    protected Uri baseUri() {
        return PlanetColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PlanetCursor} object, which is positioned before the first entry, or null.
     */
    public PlanetCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PlanetCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public PlanetCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code PlanetCursor} object, which is positioned before the first entry, or null.
     */
    public PlanetCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new PlanetCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public PlanetCursor query(Context context) {
        return query(context, null);
    }


    public PlanetSelection id(long... value) {
        addEquals("planet." + PlanetColumns._ID, toObjectArray(value));
        return this;
    }

    public PlanetSelection idNot(long... value) {
        addNotEquals("planet." + PlanetColumns._ID, toObjectArray(value));
        return this;
    }

    public PlanetSelection orderById(boolean desc) {
        orderBy("planet." + PlanetColumns._ID, desc);
        return this;
    }

    public PlanetSelection orderById() {
        return orderById(false);
    }

    public PlanetSelection name(String... value) {
        addEquals(PlanetColumns.NAME, value);
        return this;
    }

    public PlanetSelection nameNot(String... value) {
        addNotEquals(PlanetColumns.NAME, value);
        return this;
    }

    public PlanetSelection nameLike(String... value) {
        addLike(PlanetColumns.NAME, value);
        return this;
    }

    public PlanetSelection nameContains(String... value) {
        addContains(PlanetColumns.NAME, value);
        return this;
    }

    public PlanetSelection nameStartsWith(String... value) {
        addStartsWith(PlanetColumns.NAME, value);
        return this;
    }

    public PlanetSelection nameEndsWith(String... value) {
        addEndsWith(PlanetColumns.NAME, value);
        return this;
    }

    public PlanetSelection orderByName(boolean desc) {
        orderBy(PlanetColumns.NAME, desc);
        return this;
    }

    public PlanetSelection orderByName() {
        orderBy(PlanetColumns.NAME, false);
        return this;
    }

    public PlanetSelection rotationperiod(String... value) {
        addEquals(PlanetColumns.ROTATIONPERIOD, value);
        return this;
    }

    public PlanetSelection rotationperiodNot(String... value) {
        addNotEquals(PlanetColumns.ROTATIONPERIOD, value);
        return this;
    }

    public PlanetSelection rotationperiodLike(String... value) {
        addLike(PlanetColumns.ROTATIONPERIOD, value);
        return this;
    }

    public PlanetSelection rotationperiodContains(String... value) {
        addContains(PlanetColumns.ROTATIONPERIOD, value);
        return this;
    }

    public PlanetSelection rotationperiodStartsWith(String... value) {
        addStartsWith(PlanetColumns.ROTATIONPERIOD, value);
        return this;
    }

    public PlanetSelection rotationperiodEndsWith(String... value) {
        addEndsWith(PlanetColumns.ROTATIONPERIOD, value);
        return this;
    }

    public PlanetSelection orderByRotationperiod(boolean desc) {
        orderBy(PlanetColumns.ROTATIONPERIOD, desc);
        return this;
    }

    public PlanetSelection orderByRotationperiod() {
        orderBy(PlanetColumns.ROTATIONPERIOD, false);
        return this;
    }

    public PlanetSelection orbitalperiod(String... value) {
        addEquals(PlanetColumns.ORBITALPERIOD, value);
        return this;
    }

    public PlanetSelection orbitalperiodNot(String... value) {
        addNotEquals(PlanetColumns.ORBITALPERIOD, value);
        return this;
    }

    public PlanetSelection orbitalperiodLike(String... value) {
        addLike(PlanetColumns.ORBITALPERIOD, value);
        return this;
    }

    public PlanetSelection orbitalperiodContains(String... value) {
        addContains(PlanetColumns.ORBITALPERIOD, value);
        return this;
    }

    public PlanetSelection orbitalperiodStartsWith(String... value) {
        addStartsWith(PlanetColumns.ORBITALPERIOD, value);
        return this;
    }

    public PlanetSelection orbitalperiodEndsWith(String... value) {
        addEndsWith(PlanetColumns.ORBITALPERIOD, value);
        return this;
    }

    public PlanetSelection orderByOrbitalperiod(boolean desc) {
        orderBy(PlanetColumns.ORBITALPERIOD, desc);
        return this;
    }

    public PlanetSelection orderByOrbitalperiod() {
        orderBy(PlanetColumns.ORBITALPERIOD, false);
        return this;
    }

    public PlanetSelection diameter(String... value) {
        addEquals(PlanetColumns.DIAMETER, value);
        return this;
    }

    public PlanetSelection diameterNot(String... value) {
        addNotEquals(PlanetColumns.DIAMETER, value);
        return this;
    }

    public PlanetSelection diameterLike(String... value) {
        addLike(PlanetColumns.DIAMETER, value);
        return this;
    }

    public PlanetSelection diameterContains(String... value) {
        addContains(PlanetColumns.DIAMETER, value);
        return this;
    }

    public PlanetSelection diameterStartsWith(String... value) {
        addStartsWith(PlanetColumns.DIAMETER, value);
        return this;
    }

    public PlanetSelection diameterEndsWith(String... value) {
        addEndsWith(PlanetColumns.DIAMETER, value);
        return this;
    }

    public PlanetSelection orderByDiameter(boolean desc) {
        orderBy(PlanetColumns.DIAMETER, desc);
        return this;
    }

    public PlanetSelection orderByDiameter() {
        orderBy(PlanetColumns.DIAMETER, false);
        return this;
    }

    public PlanetSelection climate(String... value) {
        addEquals(PlanetColumns.CLIMATE, value);
        return this;
    }

    public PlanetSelection climateNot(String... value) {
        addNotEquals(PlanetColumns.CLIMATE, value);
        return this;
    }

    public PlanetSelection climateLike(String... value) {
        addLike(PlanetColumns.CLIMATE, value);
        return this;
    }

    public PlanetSelection climateContains(String... value) {
        addContains(PlanetColumns.CLIMATE, value);
        return this;
    }

    public PlanetSelection climateStartsWith(String... value) {
        addStartsWith(PlanetColumns.CLIMATE, value);
        return this;
    }

    public PlanetSelection climateEndsWith(String... value) {
        addEndsWith(PlanetColumns.CLIMATE, value);
        return this;
    }

    public PlanetSelection orderByClimate(boolean desc) {
        orderBy(PlanetColumns.CLIMATE, desc);
        return this;
    }

    public PlanetSelection orderByClimate() {
        orderBy(PlanetColumns.CLIMATE, false);
        return this;
    }

    public PlanetSelection gravity(String... value) {
        addEquals(PlanetColumns.GRAVITY, value);
        return this;
    }

    public PlanetSelection gravityNot(String... value) {
        addNotEquals(PlanetColumns.GRAVITY, value);
        return this;
    }

    public PlanetSelection gravityLike(String... value) {
        addLike(PlanetColumns.GRAVITY, value);
        return this;
    }

    public PlanetSelection gravityContains(String... value) {
        addContains(PlanetColumns.GRAVITY, value);
        return this;
    }

    public PlanetSelection gravityStartsWith(String... value) {
        addStartsWith(PlanetColumns.GRAVITY, value);
        return this;
    }

    public PlanetSelection gravityEndsWith(String... value) {
        addEndsWith(PlanetColumns.GRAVITY, value);
        return this;
    }

    public PlanetSelection orderByGravity(boolean desc) {
        orderBy(PlanetColumns.GRAVITY, desc);
        return this;
    }

    public PlanetSelection orderByGravity() {
        orderBy(PlanetColumns.GRAVITY, false);
        return this;
    }

    public PlanetSelection terrain(String... value) {
        addEquals(PlanetColumns.TERRAIN, value);
        return this;
    }

    public PlanetSelection terrainNot(String... value) {
        addNotEquals(PlanetColumns.TERRAIN, value);
        return this;
    }

    public PlanetSelection terrainLike(String... value) {
        addLike(PlanetColumns.TERRAIN, value);
        return this;
    }

    public PlanetSelection terrainContains(String... value) {
        addContains(PlanetColumns.TERRAIN, value);
        return this;
    }

    public PlanetSelection terrainStartsWith(String... value) {
        addStartsWith(PlanetColumns.TERRAIN, value);
        return this;
    }

    public PlanetSelection terrainEndsWith(String... value) {
        addEndsWith(PlanetColumns.TERRAIN, value);
        return this;
    }

    public PlanetSelection orderByTerrain(boolean desc) {
        orderBy(PlanetColumns.TERRAIN, desc);
        return this;
    }

    public PlanetSelection orderByTerrain() {
        orderBy(PlanetColumns.TERRAIN, false);
        return this;
    }

    public PlanetSelection surfacewater(String... value) {
        addEquals(PlanetColumns.SURFACEWATER, value);
        return this;
    }

    public PlanetSelection surfacewaterNot(String... value) {
        addNotEquals(PlanetColumns.SURFACEWATER, value);
        return this;
    }

    public PlanetSelection surfacewaterLike(String... value) {
        addLike(PlanetColumns.SURFACEWATER, value);
        return this;
    }

    public PlanetSelection surfacewaterContains(String... value) {
        addContains(PlanetColumns.SURFACEWATER, value);
        return this;
    }

    public PlanetSelection surfacewaterStartsWith(String... value) {
        addStartsWith(PlanetColumns.SURFACEWATER, value);
        return this;
    }

    public PlanetSelection surfacewaterEndsWith(String... value) {
        addEndsWith(PlanetColumns.SURFACEWATER, value);
        return this;
    }

    public PlanetSelection orderBySurfacewater(boolean desc) {
        orderBy(PlanetColumns.SURFACEWATER, desc);
        return this;
    }

    public PlanetSelection orderBySurfacewater() {
        orderBy(PlanetColumns.SURFACEWATER, false);
        return this;
    }

    public PlanetSelection population(String... value) {
        addEquals(PlanetColumns.POPULATION, value);
        return this;
    }

    public PlanetSelection populationNot(String... value) {
        addNotEquals(PlanetColumns.POPULATION, value);
        return this;
    }

    public PlanetSelection populationLike(String... value) {
        addLike(PlanetColumns.POPULATION, value);
        return this;
    }

    public PlanetSelection populationContains(String... value) {
        addContains(PlanetColumns.POPULATION, value);
        return this;
    }

    public PlanetSelection populationStartsWith(String... value) {
        addStartsWith(PlanetColumns.POPULATION, value);
        return this;
    }

    public PlanetSelection populationEndsWith(String... value) {
        addEndsWith(PlanetColumns.POPULATION, value);
        return this;
    }

    public PlanetSelection orderByPopulation(boolean desc) {
        orderBy(PlanetColumns.POPULATION, desc);
        return this;
    }

    public PlanetSelection orderByPopulation() {
        orderBy(PlanetColumns.POPULATION, false);
        return this;
    }
}
