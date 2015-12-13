package com.example.manuel.starwars.provider.starship;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.starwars.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code starship} table.
 */
public class StarshipCursor extends AbstractCursor implements StarshipModel {
    public StarshipCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(StarshipColumns._ID);
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
        String res = getStringOrNull(StarshipColumns.NAME);
        return res;
    }

    /**
     * Get the {@code model} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getModel() {
        String res = getStringOrNull(StarshipColumns.MODEL);
        return res;
    }

    /**
     * Get the {@code manufacturer} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getManufacturer() {
        String res = getStringOrNull(StarshipColumns.MANUFACTURER);
        return res;
    }

    /**
     * Get the {@code costincredits} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCostincredits() {
        String res = getStringOrNull(StarshipColumns.COSTINCREDITS);
        return res;
    }

    /**
     * Get the {@code length} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getLength() {
        String res = getStringOrNull(StarshipColumns.LENGTH);
        return res;
    }

    /**
     * Get the {@code maxatmospheringspeed} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMaxatmospheringspeed() {
        String res = getStringOrNull(StarshipColumns.MAXATMOSPHERINGSPEED);
        return res;
    }

    /**
     * Get the {@code crew} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCrew() {
        String res = getStringOrNull(StarshipColumns.CREW);
        return res;
    }

    /**
     * Get the {@code passengers} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getPassengers() {
        String res = getStringOrNull(StarshipColumns.PASSENGERS);
        return res;
    }

    /**
     * Get the {@code cargocapacity} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCargocapacity() {
        String res = getStringOrNull(StarshipColumns.CARGOCAPACITY);
        return res;
    }

    /**
     * Get the {@code consumables} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getConsumables() {
        String res = getStringOrNull(StarshipColumns.CONSUMABLES);
        return res;
    }

    /**
     * Get the {@code hyperdriverating} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getHyperdriverating() {
        String res = getStringOrNull(StarshipColumns.HYPERDRIVERATING);
        return res;
    }

    /**
     * Get the {@code mglt} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMglt() {
        String res = getStringOrNull(StarshipColumns.MGLT);
        return res;
    }

    /**
     * Get the {@code starshipclass} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getStarshipclass() {
        String res = getStringOrNull(StarshipColumns.STARSHIPCLASS);
        return res;
    }
}
