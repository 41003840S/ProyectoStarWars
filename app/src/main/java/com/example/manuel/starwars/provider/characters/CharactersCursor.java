package com.example.manuel.starwars.provider.characters;



import android.database.Cursor;
import android.support.annotation.Nullable;

import com.example.manuel.starwars.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code characters} table.
 */
public class CharactersCursor extends AbstractCursor implements CharactersModel {
    public CharactersCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(CharactersColumns._ID);
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
        String res = getStringOrNull(CharactersColumns.NAME);
        return res;
    }

    /**
     * Get the {@code height} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getHeight() {
        String res = getStringOrNull(CharactersColumns.HEIGHT);
        return res;
    }

    /**
     * Get the {@code mass} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getMass() {
        String res = getStringOrNull(CharactersColumns.MASS);
        return res;
    }

    /**
     * Get the {@code haircolor} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getHaircolor() {
        String res = getStringOrNull(CharactersColumns.HAIRCOLOR);
        return res;
    }

    /**
     * Get the {@code skincolor} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getSkincolor() {
        String res = getStringOrNull(CharactersColumns.SKINCOLOR);
        return res;
    }

    /**
     * Get the {@code eyecolor} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getEyecolor() {
        String res = getStringOrNull(CharactersColumns.EYECOLOR);
        return res;
    }

    /**
     * Get the {@code birthyear} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getBirthyear() {
        String res = getStringOrNull(CharactersColumns.BIRTHYEAR);
        return res;
    }

    /**
     * Get the {@code gender} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getGender() {
        String res = getStringOrNull(CharactersColumns.GENDER);
        return res;
    }
}
