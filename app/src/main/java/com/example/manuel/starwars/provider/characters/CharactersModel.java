package com.example.manuel.starwars.provider.characters;

import com.example.manuel.starwars.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code characters} table.
 */
public interface CharactersModel extends BaseModel {

    /**
     * Get the {@code name} value.
     * Can be {@code null}.
     */
    @Nullable
    String getName();

    /**
     * Get the {@code height} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHeight();

    /**
     * Get the {@code mass} value.
     * Can be {@code null}.
     */
    @Nullable
    String getMass();

    /**
     * Get the {@code hair} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHair();

    /**
     * Get the {@code skin} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSkin();

    /**
     * Get the {@code eyes} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEyes();

    /**
     * Get the {@code birth} value.
     * Can be {@code null}.
     */
    @Nullable
    String getBirth();

    /**
     * Get the {@code gender} value.
     * Can be {@code null}.
     */
    @Nullable
    String getGender();
}
