package com.example.manuel.starwars.provider.movies;


import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.manuel.starwars.provider.base.AbstractSelection;

/**
 * Selection for the {@code movies} table.
 */
public class MoviesSelection extends AbstractSelection<MoviesSelection> {
    @Override
    protected Uri baseUri() {
        return MoviesColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MoviesCursor} object, which is positioned before the first entry, or null.
     */
    public MoviesCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MoviesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public MoviesCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code MoviesCursor} object, which is positioned before the first entry, or null.
     */
    public MoviesCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new MoviesCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public MoviesCursor query(Context context) {
        return query(context, null);
    }


    public MoviesSelection id(long... value) {
        addEquals("movies." + MoviesColumns._ID, toObjectArray(value));
        return this;
    }

    public MoviesSelection idNot(long... value) {
        addNotEquals("movies." + MoviesColumns._ID, toObjectArray(value));
        return this;
    }

    public MoviesSelection orderById(boolean desc) {
        orderBy("movies." + MoviesColumns._ID, desc);
        return this;
    }

    public MoviesSelection orderById() {
        return orderById(false);
    }

    public MoviesSelection title(String... value) {
        addEquals(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleNot(String... value) {
        addNotEquals(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleLike(String... value) {
        addLike(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleContains(String... value) {
        addContains(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleStartsWith(String... value) {
        addStartsWith(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection titleEndsWith(String... value) {
        addEndsWith(MoviesColumns.TITLE, value);
        return this;
    }

    public MoviesSelection orderByTitle(boolean desc) {
        orderBy(MoviesColumns.TITLE, desc);
        return this;
    }

    public MoviesSelection orderByTitle() {
        orderBy(MoviesColumns.TITLE, false);
        return this;
    }

    public MoviesSelection popularity(String... value) {
        addEquals(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityNot(String... value) {
        addNotEquals(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityLike(String... value) {
        addLike(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityContains(String... value) {
        addContains(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityStartsWith(String... value) {
        addStartsWith(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection popularityEndsWith(String... value) {
        addEndsWith(MoviesColumns.POPULARITY, value);
        return this;
    }

    public MoviesSelection orderByPopularity(boolean desc) {
        orderBy(MoviesColumns.POPULARITY, desc);
        return this;
    }

    public MoviesSelection orderByPopularity() {
        orderBy(MoviesColumns.POPULARITY, false);
        return this;
    }

    public MoviesSelection overview(String... value) {
        addEquals(MoviesColumns.OVERVIEW, value);
        return this;
    }

    public MoviesSelection overviewNot(String... value) {
        addNotEquals(MoviesColumns.OVERVIEW, value);
        return this;
    }

    public MoviesSelection overviewLike(String... value) {
        addLike(MoviesColumns.OVERVIEW, value);
        return this;
    }

    public MoviesSelection overviewContains(String... value) {
        addContains(MoviesColumns.OVERVIEW, value);
        return this;
    }

    public MoviesSelection overviewStartsWith(String... value) {
        addStartsWith(MoviesColumns.OVERVIEW, value);
        return this;
    }

    public MoviesSelection overviewEndsWith(String... value) {
        addEndsWith(MoviesColumns.OVERVIEW, value);
        return this;
    }

    public MoviesSelection orderByOverview(boolean desc) {
        orderBy(MoviesColumns.OVERVIEW, desc);
        return this;
    }

    public MoviesSelection orderByOverview() {
        orderBy(MoviesColumns.OVERVIEW, false);
        return this;
    }

    public MoviesSelection posterpath(String... value) {
        addEquals(MoviesColumns.POSTERPATH, value);
        return this;
    }

    public MoviesSelection posterpathNot(String... value) {
        addNotEquals(MoviesColumns.POSTERPATH, value);
        return this;
    }

    public MoviesSelection posterpathLike(String... value) {
        addLike(MoviesColumns.POSTERPATH, value);
        return this;
    }

    public MoviesSelection posterpathContains(String... value) {
        addContains(MoviesColumns.POSTERPATH, value);
        return this;
    }

    public MoviesSelection posterpathStartsWith(String... value) {
        addStartsWith(MoviesColumns.POSTERPATH, value);
        return this;
    }

    public MoviesSelection posterpathEndsWith(String... value) {
        addEndsWith(MoviesColumns.POSTERPATH, value);
        return this;
    }

    public MoviesSelection orderByPosterpath(boolean desc) {
        orderBy(MoviesColumns.POSTERPATH, desc);
        return this;
    }

    public MoviesSelection orderByPosterpath() {
        orderBy(MoviesColumns.POSTERPATH, false);
        return this;
    }
}
