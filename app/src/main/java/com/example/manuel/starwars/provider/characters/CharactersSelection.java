package com.example.manuel.starwars.provider.characters;

import java.util.Date;

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

    public CharactersSelection hair(String... value) {
        addEquals(CharactersColumns.HAIR, value);
        return this;
    }

    public CharactersSelection hairNot(String... value) {
        addNotEquals(CharactersColumns.HAIR, value);
        return this;
    }

    public CharactersSelection hairLike(String... value) {
        addLike(CharactersColumns.HAIR, value);
        return this;
    }

    public CharactersSelection hairContains(String... value) {
        addContains(CharactersColumns.HAIR, value);
        return this;
    }

    public CharactersSelection hairStartsWith(String... value) {
        addStartsWith(CharactersColumns.HAIR, value);
        return this;
    }

    public CharactersSelection hairEndsWith(String... value) {
        addEndsWith(CharactersColumns.HAIR, value);
        return this;
    }

    public CharactersSelection orderByHair(boolean desc) {
        orderBy(CharactersColumns.HAIR, desc);
        return this;
    }

    public CharactersSelection orderByHair() {
        orderBy(CharactersColumns.HAIR, false);
        return this;
    }

    public CharactersSelection skin(String... value) {
        addEquals(CharactersColumns.SKIN, value);
        return this;
    }

    public CharactersSelection skinNot(String... value) {
        addNotEquals(CharactersColumns.SKIN, value);
        return this;
    }

    public CharactersSelection skinLike(String... value) {
        addLike(CharactersColumns.SKIN, value);
        return this;
    }

    public CharactersSelection skinContains(String... value) {
        addContains(CharactersColumns.SKIN, value);
        return this;
    }

    public CharactersSelection skinStartsWith(String... value) {
        addStartsWith(CharactersColumns.SKIN, value);
        return this;
    }

    public CharactersSelection skinEndsWith(String... value) {
        addEndsWith(CharactersColumns.SKIN, value);
        return this;
    }

    public CharactersSelection orderBySkin(boolean desc) {
        orderBy(CharactersColumns.SKIN, desc);
        return this;
    }

    public CharactersSelection orderBySkin() {
        orderBy(CharactersColumns.SKIN, false);
        return this;
    }

    public CharactersSelection eyes(String... value) {
        addEquals(CharactersColumns.EYES, value);
        return this;
    }

    public CharactersSelection eyesNot(String... value) {
        addNotEquals(CharactersColumns.EYES, value);
        return this;
    }

    public CharactersSelection eyesLike(String... value) {
        addLike(CharactersColumns.EYES, value);
        return this;
    }

    public CharactersSelection eyesContains(String... value) {
        addContains(CharactersColumns.EYES, value);
        return this;
    }

    public CharactersSelection eyesStartsWith(String... value) {
        addStartsWith(CharactersColumns.EYES, value);
        return this;
    }

    public CharactersSelection eyesEndsWith(String... value) {
        addEndsWith(CharactersColumns.EYES, value);
        return this;
    }

    public CharactersSelection orderByEyes(boolean desc) {
        orderBy(CharactersColumns.EYES, desc);
        return this;
    }

    public CharactersSelection orderByEyes() {
        orderBy(CharactersColumns.EYES, false);
        return this;
    }

    public CharactersSelection birth(String... value) {
        addEquals(CharactersColumns.BIRTH, value);
        return this;
    }

    public CharactersSelection birthNot(String... value) {
        addNotEquals(CharactersColumns.BIRTH, value);
        return this;
    }

    public CharactersSelection birthLike(String... value) {
        addLike(CharactersColumns.BIRTH, value);
        return this;
    }

    public CharactersSelection birthContains(String... value) {
        addContains(CharactersColumns.BIRTH, value);
        return this;
    }

    public CharactersSelection birthStartsWith(String... value) {
        addStartsWith(CharactersColumns.BIRTH, value);
        return this;
    }

    public CharactersSelection birthEndsWith(String... value) {
        addEndsWith(CharactersColumns.BIRTH, value);
        return this;
    }

    public CharactersSelection orderByBirth(boolean desc) {
        orderBy(CharactersColumns.BIRTH, desc);
        return this;
    }

    public CharactersSelection orderByBirth() {
        orderBy(CharactersColumns.BIRTH, false);
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
