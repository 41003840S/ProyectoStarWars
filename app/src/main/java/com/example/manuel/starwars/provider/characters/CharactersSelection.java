package com.example.manuel.starwars.provider.characters;


import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.manuel.starwars.provider.base.AbstractSelection;

/**
 * Selection for the {@code characters} table.
 */
public class CharactersSelection extends AbstractSelection<CharactersSelection> {
    @Override
    protected Uri baseUri() {
        return CharactersColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code CharactersCursor} object, which is positioned before the first entry, or null.
     */
    public CharactersCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new CharactersCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public CharactersCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code CharactersCursor} object, which is positioned before the first entry, or null.
     */
    public CharactersCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new CharactersCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public CharactersCursor query(Context context) {
        return query(context, null);
    }


    public CharactersSelection id(long... value) {
        addEquals("characters." + CharactersColumns._ID, toObjectArray(value));
        return this;
    }

    public CharactersSelection idNot(long... value) {
        addNotEquals("characters." + CharactersColumns._ID, toObjectArray(value));
        return this;
    }

    public CharactersSelection orderById(boolean desc) {
        orderBy("characters." + CharactersColumns._ID, desc);
        return this;
    }

    public CharactersSelection orderById() {
        return orderById(false);
    }

    public CharactersSelection name(String... value) {
        addEquals(CharactersColumns.NAME, value);
        return this;
    }

    public CharactersSelection nameNot(String... value) {
        addNotEquals(CharactersColumns.NAME, value);
        return this;
    }

    public CharactersSelection nameLike(String... value) {
        addLike(CharactersColumns.NAME, value);
        return this;
    }

    public CharactersSelection nameContains(String... value) {
        addContains(CharactersColumns.NAME, value);
        return this;
    }

    public CharactersSelection nameStartsWith(String... value) {
        addStartsWith(CharactersColumns.NAME, value);
        return this;
    }

    public CharactersSelection nameEndsWith(String... value) {
        addEndsWith(CharactersColumns.NAME, value);
        return this;
    }

    public CharactersSelection orderByName(boolean desc) {
        orderBy(CharactersColumns.NAME, desc);
        return this;
    }

    public CharactersSelection orderByName() {
        orderBy(CharactersColumns.NAME, false);
        return this;
    }

    public CharactersSelection height(String... value) {
        addEquals(CharactersColumns.HEIGHT, value);
        return this;
    }

    public CharactersSelection heightNot(String... value) {
        addNotEquals(CharactersColumns.HEIGHT, value);
        return this;
    }

    public CharactersSelection heightLike(String... value) {
        addLike(CharactersColumns.HEIGHT, value);
        return this;
    }

    public CharactersSelection heightContains(String... value) {
        addContains(CharactersColumns.HEIGHT, value);
        return this;
    }

    public CharactersSelection heightStartsWith(String... value) {
        addStartsWith(CharactersColumns.HEIGHT, value);
        return this;
    }

    public CharactersSelection heightEndsWith(String... value) {
        addEndsWith(CharactersColumns.HEIGHT, value);
        return this;
    }

    public CharactersSelection orderByHeight(boolean desc) {
        orderBy(CharactersColumns.HEIGHT, desc);
        return this;
    }

    public CharactersSelection orderByHeight() {
        orderBy(CharactersColumns.HEIGHT, false);
        return this;
    }

    public CharactersSelection mass(String... value) {
        addEquals(CharactersColumns.MASS, value);
        return this;
    }

    public CharactersSelection massNot(String... value) {
        addNotEquals(CharactersColumns.MASS, value);
        return this;
    }

    public CharactersSelection massLike(String... value) {
        addLike(CharactersColumns.MASS, value);
        return this;
    }

    public CharactersSelection massContains(String... value) {
        addContains(CharactersColumns.MASS, value);
        return this;
    }

    public CharactersSelection massStartsWith(String... value) {
        addStartsWith(CharactersColumns.MASS, value);
        return this;
    }

    public CharactersSelection massEndsWith(String... value) {
        addEndsWith(CharactersColumns.MASS, value);
        return this;
    }

    public CharactersSelection orderByMass(boolean desc) {
        orderBy(CharactersColumns.MASS, desc);
        return this;
    }

    public CharactersSelection orderByMass() {
        orderBy(CharactersColumns.MASS, false);
        return this;
    }

    public CharactersSelection haircolor(String... value) {
        addEquals(CharactersColumns.HAIRCOLOR, value);
        return this;
    }

    public CharactersSelection haircolorNot(String... value) {
        addNotEquals(CharactersColumns.HAIRCOLOR, value);
        return this;
    }

    public CharactersSelection haircolorLike(String... value) {
        addLike(CharactersColumns.HAIRCOLOR, value);
        return this;
    }

    public CharactersSelection haircolorContains(String... value) {
        addContains(CharactersColumns.HAIRCOLOR, value);
        return this;
    }

    public CharactersSelection haircolorStartsWith(String... value) {
        addStartsWith(CharactersColumns.HAIRCOLOR, value);
        return this;
    }

    public CharactersSelection haircolorEndsWith(String... value) {
        addEndsWith(CharactersColumns.HAIRCOLOR, value);
        return this;
    }

    public CharactersSelection orderByHaircolor(boolean desc) {
        orderBy(CharactersColumns.HAIRCOLOR, desc);
        return this;
    }

    public CharactersSelection orderByHaircolor() {
        orderBy(CharactersColumns.HAIRCOLOR, false);
        return this;
    }

    public CharactersSelection skincolor(String... value) {
        addEquals(CharactersColumns.SKINCOLOR, value);
        return this;
    }

    public CharactersSelection skincolorNot(String... value) {
        addNotEquals(CharactersColumns.SKINCOLOR, value);
        return this;
    }

    public CharactersSelection skincolorLike(String... value) {
        addLike(CharactersColumns.SKINCOLOR, value);
        return this;
    }

    public CharactersSelection skincolorContains(String... value) {
        addContains(CharactersColumns.SKINCOLOR, value);
        return this;
    }

    public CharactersSelection skincolorStartsWith(String... value) {
        addStartsWith(CharactersColumns.SKINCOLOR, value);
        return this;
    }

    public CharactersSelection skincolorEndsWith(String... value) {
        addEndsWith(CharactersColumns.SKINCOLOR, value);
        return this;
    }

    public CharactersSelection orderBySkincolor(boolean desc) {
        orderBy(CharactersColumns.SKINCOLOR, desc);
        return this;
    }

    public CharactersSelection orderBySkincolor() {
        orderBy(CharactersColumns.SKINCOLOR, false);
        return this;
    }

    public CharactersSelection eyecolor(String... value) {
        addEquals(CharactersColumns.EYECOLOR, value);
        return this;
    }

    public CharactersSelection eyecolorNot(String... value) {
        addNotEquals(CharactersColumns.EYECOLOR, value);
        return this;
    }

    public CharactersSelection eyecolorLike(String... value) {
        addLike(CharactersColumns.EYECOLOR, value);
        return this;
    }

    public CharactersSelection eyecolorContains(String... value) {
        addContains(CharactersColumns.EYECOLOR, value);
        return this;
    }

    public CharactersSelection eyecolorStartsWith(String... value) {
        addStartsWith(CharactersColumns.EYECOLOR, value);
        return this;
    }

    public CharactersSelection eyecolorEndsWith(String... value) {
        addEndsWith(CharactersColumns.EYECOLOR, value);
        return this;
    }

    public CharactersSelection orderByEyecolor(boolean desc) {
        orderBy(CharactersColumns.EYECOLOR, desc);
        return this;
    }

    public CharactersSelection orderByEyecolor() {
        orderBy(CharactersColumns.EYECOLOR, false);
        return this;
    }

    public CharactersSelection birthyear(String... value) {
        addEquals(CharactersColumns.BIRTHYEAR, value);
        return this;
    }

    public CharactersSelection birthyearNot(String... value) {
        addNotEquals(CharactersColumns.BIRTHYEAR, value);
        return this;
    }

    public CharactersSelection birthyearLike(String... value) {
        addLike(CharactersColumns.BIRTHYEAR, value);
        return this;
    }

    public CharactersSelection birthyearContains(String... value) {
        addContains(CharactersColumns.BIRTHYEAR, value);
        return this;
    }

    public CharactersSelection birthyearStartsWith(String... value) {
        addStartsWith(CharactersColumns.BIRTHYEAR, value);
        return this;
    }

    public CharactersSelection birthyearEndsWith(String... value) {
        addEndsWith(CharactersColumns.BIRTHYEAR, value);
        return this;
    }

    public CharactersSelection orderByBirthyear(boolean desc) {
        orderBy(CharactersColumns.BIRTHYEAR, desc);
        return this;
    }

    public CharactersSelection orderByBirthyear() {
        orderBy(CharactersColumns.BIRTHYEAR, false);
        return this;
    }

    public CharactersSelection gender(String... value) {
        addEquals(CharactersColumns.GENDER, value);
        return this;
    }

    public CharactersSelection genderNot(String... value) {
        addNotEquals(CharactersColumns.GENDER, value);
        return this;
    }

    public CharactersSelection genderLike(String... value) {
        addLike(CharactersColumns.GENDER, value);
        return this;
    }

    public CharactersSelection genderContains(String... value) {
        addContains(CharactersColumns.GENDER, value);
        return this;
    }

    public CharactersSelection genderStartsWith(String... value) {
        addStartsWith(CharactersColumns.GENDER, value);
        return this;
    }

    public CharactersSelection genderEndsWith(String... value) {
        addEndsWith(CharactersColumns.GENDER, value);
        return this;
    }

    public CharactersSelection orderByGender(boolean desc) {
        orderBy(CharactersColumns.GENDER, desc);
        return this;
    }

    public CharactersSelection orderByGender() {
        orderBy(CharactersColumns.GENDER, false);
        return this;
    }
}
