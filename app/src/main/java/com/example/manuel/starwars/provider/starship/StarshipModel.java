package com.example.manuel.starwars.provider.starship;

import com.example.manuel.starwars.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code starship} table.
 */
public interface StarshipModel extends BaseModel {

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Get the {@code model} value.
     * Can be {@code null}.
     */
    @Nullable
    String getModel();

    /**
     * Get the {@code manufacturer} value.
     * Can be {@code null}.
     */
    @Nullable
    String getManufacturer();

    /**
     * Get the {@code costincredits} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCostincredits();

    /**
     * Get the {@code length} value.
     * Can be {@code null}.
     */
    @Nullable
    String getLength();

    /**
     * Get the {@code maxatmospheringspeed} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMaxatmospheringspeed();

    /**
     * Get the {@code crew} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCrew();

    /**
     * Get the {@code passengers} value.
     * Can be {@code null}.
     */
    @Nullable
    String getPassengers();

    /**
     * Get the {@code cargocapacity} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCargocapacity();

    /**
     * Get the {@code consumables} value.
     * Can be {@code null}.
     */
    @Nullable
    String getConsumables();

    /**
     * Get the {@code hyperdriverating} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHyperdriverating();

    /**
     * Get the {@code mglt} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMglt();

    /**
     * Get the {@code starshipclass} value.
     * Can be {@code null}.
     */
    @Nullable
    String getStarshipclass();
}
