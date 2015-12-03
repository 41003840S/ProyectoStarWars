package com.example.manuel.starwars.provider.characters;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.manuel.starwars.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code characters} table.
 */
public class CharactersContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return CharactersColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable CharactersSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable CharactersSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public CharactersContentValues putName(@Nullable String value) {
        mContentValues.put(CharactersColumns.NAME, value);
        return this;
    }

    public CharactersContentValues putNameNull() {
        mContentValues.putNull(CharactersColumns.NAME);
        return this;
    }

    public CharactersContentValues putHeight(@Nullable String value) {
        mContentValues.put(CharactersColumns.HEIGHT, value);
        return this;
    }

    public CharactersContentValues putHeightNull() {
        mContentValues.putNull(CharactersColumns.HEIGHT);
        return this;
    }

    public CharactersContentValues putMass(@Nullable String value) {
        mContentValues.put(CharactersColumns.MASS, value);
        return this;
    }

    public CharactersContentValues putMassNull() {
        mContentValues.putNull(CharactersColumns.MASS);
        return this;
    }

    public CharactersContentValues putHair(@Nullable String value) {
        mContentValues.put(CharactersColumns.HAIR, value);
        return this;
    }

    public CharactersContentValues putHairNull() {
        mContentValues.putNull(CharactersColumns.HAIR);
        return this;
    }

    public CharactersContentValues putSkin(@Nullable String value) {
        mContentValues.put(CharactersColumns.SKIN, value);
        return this;
    }

    public CharactersContentValues putSkinNull() {
        mContentValues.putNull(CharactersColumns.SKIN);
        return this;
    }

    public CharactersContentValues putEyes(@Nullable String value) {
        mContentValues.put(CharactersColumns.EYES, value);
        return this;
    }

    public CharactersContentValues putEyesNull() {
        mContentValues.putNull(CharactersColumns.EYES);
        return this;
    }

    public CharactersContentValues putBirth(@Nullable String value) {
        mContentValues.put(CharactersColumns.BIRTH, value);
        return this;
    }

    public CharactersContentValues putBirthNull() {
        mContentValues.putNull(CharactersColumns.BIRTH);
        return this;
    }

    public CharactersContentValues putGender(@Nullable String value) {
        mContentValues.put(CharactersColumns.GENDER, value);
        return this;
    }

    public CharactersContentValues putGenderNull() {
        mContentValues.putNull(CharactersColumns.GENDER);
        return this;
    }
}
