package com.example.manuel.starwars.provider.characters;

import com.example.manuel.starwars.provider.base.BaseModel;

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
     * Get the {@code haircolor} value.
     * Can be {@code null}.
     */
    @Nullable
    String getHaircolor();

    /**
     * Get the {@code skincolor} value.
     * Can be {@code null}.
     */
    @Nullable
    String getSkincolor();

    /**
     * Get the {@code eyecolor} value.
     * Can be {@code null}.
     */
    @Nullable
    String getEyecolor();

    /**
     * Get the {@code birthyear} value.
     * Can be {@code null}.
     */
    @Nullable
    String getBirthyear();

    /**
     * Get the {@code gender} value.
     * Can be {@code null}.
     */
    @Nullable
    String getGender();
}
