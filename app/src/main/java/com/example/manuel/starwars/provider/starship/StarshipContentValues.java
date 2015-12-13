package com.example.manuel.starwars.provider.starship;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.starwars.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code starship} table.
 */
public class StarshipContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return StarshipColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable StarshipSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable StarshipSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public StarshipContentValues putName(@Nullable String value) {
        mContentValues.put(StarshipColumns.NAME, value);
        return this;
    }

    public StarshipContentValues putNameNull() {
        mContentValues.putNull(StarshipColumns.NAME);
        return this;
    }

    public StarshipContentValues putModel(@Nullable String value) {
        mContentValues.put(StarshipColumns.MODEL, value);
        return this;
    }

    public StarshipContentValues putModelNull() {
        mContentValues.putNull(StarshipColumns.MODEL);
        return this;
    }

    public StarshipContentValues putManufacturer(@Nullable String value) {
        mContentValues.put(StarshipColumns.MANUFACTURER, value);
        return this;
    }

    public StarshipContentValues putManufacturerNull() {
        mContentValues.putNull(StarshipColumns.MANUFACTURER);
        return this;
    }

    public StarshipContentValues putCostincredits(@Nullable String value) {
        mContentValues.put(StarshipColumns.COSTINCREDITS, value);
        return this;
    }

    public StarshipContentValues putCostincreditsNull() {
        mContentValues.putNull(StarshipColumns.COSTINCREDITS);
        return this;
    }

    public StarshipContentValues putLength(@Nullable String value) {
        mContentValues.put(StarshipColumns.LENGTH, value);
        return this;
    }

    public StarshipContentValues putLengthNull() {
        mContentValues.putNull(StarshipColumns.LENGTH);
        return this;
    }

    public StarshipContentValues putMaxatmospheringspeed(@Nullable String value) {
        mContentValues.put(StarshipColumns.MAXATMOSPHERINGSPEED, value);
        return this;
    }

    public StarshipContentValues putMaxatmospheringspeedNull() {
        mContentValues.putNull(StarshipColumns.MAXATMOSPHERINGSPEED);
        return this;
    }

    public StarshipContentValues putCrew(@Nullable String value) {
        mContentValues.put(StarshipColumns.CREW, value);
        return this;
    }

    public StarshipContentValues putCrewNull() {
        mContentValues.putNull(StarshipColumns.CREW);
        return this;
    }

    public StarshipContentValues putPassengers(@Nullable String value) {
        mContentValues.put(StarshipColumns.PASSENGERS, value);
        return this;
    }

    public StarshipContentValues putPassengersNull() {
        mContentValues.putNull(StarshipColumns.PASSENGERS);
        return this;
    }

    public StarshipContentValues putCargocapacity(@Nullable String value) {
        mContentValues.put(StarshipColumns.CARGOCAPACITY, value);
        return this;
    }

    public StarshipContentValues putCargocapacityNull() {
        mContentValues.putNull(StarshipColumns.CARGOCAPACITY);
        return this;
    }

    public StarshipContentValues putConsumables(@Nullable String value) {
        mContentValues.put(StarshipColumns.CONSUMABLES, value);
        return this;
    }

    public StarshipContentValues putConsumablesNull() {
        mContentValues.putNull(StarshipColumns.CONSUMABLES);
        return this;
    }

    public StarshipContentValues putHyperdriverating(@Nullable String value) {
        mContentValues.put(StarshipColumns.HYPERDRIVERATING, value);
        return this;
    }

    public StarshipContentValues putHyperdriveratingNull() {
        mContentValues.putNull(StarshipColumns.HYPERDRIVERATING);
        return this;
    }

    public StarshipContentValues putMglt(@Nullable String value) {
        mContentValues.put(StarshipColumns.MGLT, value);
        return this;
    }

    public StarshipContentValues putMgltNull() {
        mContentValues.putNull(StarshipColumns.MGLT);
        return this;
    }

    public StarshipContentValues putStarshipclass(@Nullable String value) {
        mContentValues.put(StarshipColumns.STARSHIPCLASS, value);
        return this;
    }

    public StarshipContentValues putStarshipclassNull() {
        mContentValues.putNull(StarshipColumns.STARSHIPCLASS);
        return this;
    }
}
