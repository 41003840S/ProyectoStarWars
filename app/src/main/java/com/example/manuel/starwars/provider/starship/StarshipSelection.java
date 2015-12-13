package com.example.manuel.starwars.provider.starship;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.manuel.starwars.provider.base.AbstractSelection;

/**
 * Selection for the {@code starship} table.
 */
public class StarshipSelection extends AbstractSelection<StarshipSelection> {
    @Override
    protected Uri baseUri() {
        return StarshipColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code StarshipCursor} object, which is positioned before the first entry, or null.
     */
    public StarshipCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new StarshipCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public StarshipCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code StarshipCursor} object, which is positioned before the first entry, or null.
     */
    public StarshipCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new StarshipCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public StarshipCursor query(Context context) {
        return query(context, null);
    }


    public StarshipSelection id(long... value) {
        addEquals("starship." + StarshipColumns._ID, toObjectArray(value));
        return this;
    }

    public StarshipSelection idNot(long... value) {
        addNotEquals("starship." + StarshipColumns._ID, toObjectArray(value));
        return this;
    }

    public StarshipSelection orderById(boolean desc) {
        orderBy("starship." + StarshipColumns._ID, desc);
        return this;
    }

    public StarshipSelection orderById() {
        return orderById(false);
    }

    public StarshipSelection name(String... value) {
        addEquals(StarshipColumns.NAME, value);
        return this;
    }

    public StarshipSelection nameNot(String... value) {
        addNotEquals(StarshipColumns.NAME, value);
        return this;
    }

    public StarshipSelection nameLike(String... value) {
        addLike(StarshipColumns.NAME, value);
        return this;
    }

    public StarshipSelection nameContains(String... value) {
        addContains(StarshipColumns.NAME, value);
        return this;
    }

    public StarshipSelection nameStartsWith(String... value) {
        addStartsWith(StarshipColumns.NAME, value);
        return this;
    }

    public StarshipSelection nameEndsWith(String... value) {
        addEndsWith(StarshipColumns.NAME, value);
        return this;
    }

    public StarshipSelection orderByName(boolean desc) {
        orderBy(StarshipColumns.NAME, desc);
        return this;
    }

    public StarshipSelection orderByName() {
        orderBy(StarshipColumns.NAME, false);
        return this;
    }

    public StarshipSelection model(String... value) {
        addEquals(StarshipColumns.MODEL, value);
        return this;
    }

    public StarshipSelection modelNot(String... value) {
        addNotEquals(StarshipColumns.MODEL, value);
        return this;
    }

    public StarshipSelection modelLike(String... value) {
        addLike(StarshipColumns.MODEL, value);
        return this;
    }

    public StarshipSelection modelContains(String... value) {
        addContains(StarshipColumns.MODEL, value);
        return this;
    }

    public StarshipSelection modelStartsWith(String... value) {
        addStartsWith(StarshipColumns.MODEL, value);
        return this;
    }

    public StarshipSelection modelEndsWith(String... value) {
        addEndsWith(StarshipColumns.MODEL, value);
        return this;
    }

    public StarshipSelection orderByModel(boolean desc) {
        orderBy(StarshipColumns.MODEL, desc);
        return this;
    }

    public StarshipSelection orderByModel() {
        orderBy(StarshipColumns.MODEL, false);
        return this;
    }

    public StarshipSelection manufacturer(String... value) {
        addEquals(StarshipColumns.MANUFACTURER, value);
        return this;
    }

    public StarshipSelection manufacturerNot(String... value) {
        addNotEquals(StarshipColumns.MANUFACTURER, value);
        return this;
    }

    public StarshipSelection manufacturerLike(String... value) {
        addLike(StarshipColumns.MANUFACTURER, value);
        return this;
    }

    public StarshipSelection manufacturerContains(String... value) {
        addContains(StarshipColumns.MANUFACTURER, value);
        return this;
    }

    public StarshipSelection manufacturerStartsWith(String... value) {
        addStartsWith(StarshipColumns.MANUFACTURER, value);
        return this;
    }

    public StarshipSelection manufacturerEndsWith(String... value) {
        addEndsWith(StarshipColumns.MANUFACTURER, value);
        return this;
    }

    public StarshipSelection orderByManufacturer(boolean desc) {
        orderBy(StarshipColumns.MANUFACTURER, desc);
        return this;
    }

    public StarshipSelection orderByManufacturer() {
        orderBy(StarshipColumns.MANUFACTURER, false);
        return this;
    }

    public StarshipSelection costincredits(String... value) {
        addEquals(StarshipColumns.COSTINCREDITS, value);
        return this;
    }

    public StarshipSelection costincreditsNot(String... value) {
        addNotEquals(StarshipColumns.COSTINCREDITS, value);
        return this;
    }

    public StarshipSelection costincreditsLike(String... value) {
        addLike(StarshipColumns.COSTINCREDITS, value);
        return this;
    }

    public StarshipSelection costincreditsContains(String... value) {
        addContains(StarshipColumns.COSTINCREDITS, value);
        return this;
    }

    public StarshipSelection costincreditsStartsWith(String... value) {
        addStartsWith(StarshipColumns.COSTINCREDITS, value);
        return this;
    }

    public StarshipSelection costincreditsEndsWith(String... value) {
        addEndsWith(StarshipColumns.COSTINCREDITS, value);
        return this;
    }

    public StarshipSelection orderByCostincredits(boolean desc) {
        orderBy(StarshipColumns.COSTINCREDITS, desc);
        return this;
    }

    public StarshipSelection orderByCostincredits() {
        orderBy(StarshipColumns.COSTINCREDITS, false);
        return this;
    }

    public StarshipSelection length(String... value) {
        addEquals(StarshipColumns.LENGTH, value);
        return this;
    }

    public StarshipSelection lengthNot(String... value) {
        addNotEquals(StarshipColumns.LENGTH, value);
        return this;
    }

    public StarshipSelection lengthLike(String... value) {
        addLike(StarshipColumns.LENGTH, value);
        return this;
    }

    public StarshipSelection lengthContains(String... value) {
        addContains(StarshipColumns.LENGTH, value);
        return this;
    }

    public StarshipSelection lengthStartsWith(String... value) {
        addStartsWith(StarshipColumns.LENGTH, value);
        return this;
    }

    public StarshipSelection lengthEndsWith(String... value) {
        addEndsWith(StarshipColumns.LENGTH, value);
        return this;
    }

    public StarshipSelection orderByLength(boolean desc) {
        orderBy(StarshipColumns.LENGTH, desc);
        return this;
    }

    public StarshipSelection orderByLength() {
        orderBy(StarshipColumns.LENGTH, false);
        return this;
    }

    public StarshipSelection maxatmospheringspeed(String... value) {
        addEquals(StarshipColumns.MAXATMOSPHERINGSPEED, value);
        return this;
    }

    public StarshipSelection maxatmospheringspeedNot(String... value) {
        addNotEquals(StarshipColumns.MAXATMOSPHERINGSPEED, value);
        return this;
    }

    public StarshipSelection maxatmospheringspeedLike(String... value) {
        addLike(StarshipColumns.MAXATMOSPHERINGSPEED, value);
        return this;
    }

    public StarshipSelection maxatmospheringspeedContains(String... value) {
        addContains(StarshipColumns.MAXATMOSPHERINGSPEED, value);
        return this;
    }

    public StarshipSelection maxatmospheringspeedStartsWith(String... value) {
        addStartsWith(StarshipColumns.MAXATMOSPHERINGSPEED, value);
        return this;
    }

    public StarshipSelection maxatmospheringspeedEndsWith(String... value) {
        addEndsWith(StarshipColumns.MAXATMOSPHERINGSPEED, value);
        return this;
    }

    public StarshipSelection orderByMaxatmospheringspeed(boolean desc) {
        orderBy(StarshipColumns.MAXATMOSPHERINGSPEED, desc);
        return this;
    }

    public StarshipSelection orderByMaxatmospheringspeed() {
        orderBy(StarshipColumns.MAXATMOSPHERINGSPEED, false);
        return this;
    }

    public StarshipSelection crew(String... value) {
        addEquals(StarshipColumns.CREW, value);
        return this;
    }

    public StarshipSelection crewNot(String... value) {
        addNotEquals(StarshipColumns.CREW, value);
        return this;
    }

    public StarshipSelection crewLike(String... value) {
        addLike(StarshipColumns.CREW, value);
        return this;
    }

    public StarshipSelection crewContains(String... value) {
        addContains(StarshipColumns.CREW, value);
        return this;
    }

    public StarshipSelection crewStartsWith(String... value) {
        addStartsWith(StarshipColumns.CREW, value);
        return this;
    }

    public StarshipSelection crewEndsWith(String... value) {
        addEndsWith(StarshipColumns.CREW, value);
        return this;
    }

    public StarshipSelection orderByCrew(boolean desc) {
        orderBy(StarshipColumns.CREW, desc);
        return this;
    }

    public StarshipSelection orderByCrew() {
        orderBy(StarshipColumns.CREW, false);
        return this;
    }

    public StarshipSelection passengers(String... value) {
        addEquals(StarshipColumns.PASSENGERS, value);
        return this;
    }

    public StarshipSelection passengersNot(String... value) {
        addNotEquals(StarshipColumns.PASSENGERS, value);
        return this;
    }

    public StarshipSelection passengersLike(String... value) {
        addLike(StarshipColumns.PASSENGERS, value);
        return this;
    }

    public StarshipSelection passengersContains(String... value) {
        addContains(StarshipColumns.PASSENGERS, value);
        return this;
    }

    public StarshipSelection passengersStartsWith(String... value) {
        addStartsWith(StarshipColumns.PASSENGERS, value);
        return this;
    }

    public StarshipSelection passengersEndsWith(String... value) {
        addEndsWith(StarshipColumns.PASSENGERS, value);
        return this;
    }

    public StarshipSelection orderByPassengers(boolean desc) {
        orderBy(StarshipColumns.PASSENGERS, desc);
        return this;
    }

    public StarshipSelection orderByPassengers() {
        orderBy(StarshipColumns.PASSENGERS, false);
        return this;
    }

    public StarshipSelection cargocapacity(String... value) {
        addEquals(StarshipColumns.CARGOCAPACITY, value);
        return this;
    }

    public StarshipSelection cargocapacityNot(String... value) {
        addNotEquals(StarshipColumns.CARGOCAPACITY, value);
        return this;
    }

    public StarshipSelection cargocapacityLike(String... value) {
        addLike(StarshipColumns.CARGOCAPACITY, value);
        return this;
    }

    public StarshipSelection cargocapacityContains(String... value) {
        addContains(StarshipColumns.CARGOCAPACITY, value);
        return this;
    }

    public StarshipSelection cargocapacityStartsWith(String... value) {
        addStartsWith(StarshipColumns.CARGOCAPACITY, value);
        return this;
    }

    public StarshipSelection cargocapacityEndsWith(String... value) {
        addEndsWith(StarshipColumns.CARGOCAPACITY, value);
        return this;
    }

    public StarshipSelection orderByCargocapacity(boolean desc) {
        orderBy(StarshipColumns.CARGOCAPACITY, desc);
        return this;
    }

    public StarshipSelection orderByCargocapacity() {
        orderBy(StarshipColumns.CARGOCAPACITY, false);
        return this;
    }

    public StarshipSelection consumables(String... value) {
        addEquals(StarshipColumns.CONSUMABLES, value);
        return this;
    }

    public StarshipSelection consumablesNot(String... value) {
        addNotEquals(StarshipColumns.CONSUMABLES, value);
        return this;
    }

    public StarshipSelection consumablesLike(String... value) {
        addLike(StarshipColumns.CONSUMABLES, value);
        return this;
    }

    public StarshipSelection consumablesContains(String... value) {
        addContains(StarshipColumns.CONSUMABLES, value);
        return this;
    }

    public StarshipSelection consumablesStartsWith(String... value) {
        addStartsWith(StarshipColumns.CONSUMABLES, value);
        return this;
    }

    public StarshipSelection consumablesEndsWith(String... value) {
        addEndsWith(StarshipColumns.CONSUMABLES, value);
        return this;
    }

    public StarshipSelection orderByConsumables(boolean desc) {
        orderBy(StarshipColumns.CONSUMABLES, desc);
        return this;
    }

    public StarshipSelection orderByConsumables() {
        orderBy(StarshipColumns.CONSUMABLES, false);
        return this;
    }

    public StarshipSelection hyperdriverating(String... value) {
        addEquals(StarshipColumns.HYPERDRIVERATING, value);
        return this;
    }

    public StarshipSelection hyperdriveratingNot(String... value) {
        addNotEquals(StarshipColumns.HYPERDRIVERATING, value);
        return this;
    }

    public StarshipSelection hyperdriveratingLike(String... value) {
        addLike(StarshipColumns.HYPERDRIVERATING, value);
        return this;
    }

    public StarshipSelection hyperdriveratingContains(String... value) {
        addContains(StarshipColumns.HYPERDRIVERATING, value);
        return this;
    }

    public StarshipSelection hyperdriveratingStartsWith(String... value) {
        addStartsWith(StarshipColumns.HYPERDRIVERATING, value);
        return this;
    }

    public StarshipSelection hyperdriveratingEndsWith(String... value) {
        addEndsWith(StarshipColumns.HYPERDRIVERATING, value);
        return this;
    }

    public StarshipSelection orderByHyperdriverating(boolean desc) {
        orderBy(StarshipColumns.HYPERDRIVERATING, desc);
        return this;
    }

    public StarshipSelection orderByHyperdriverating() {
        orderBy(StarshipColumns.HYPERDRIVERATING, false);
        return this;
    }

    public StarshipSelection mglt(String... value) {
        addEquals(StarshipColumns.MGLT, value);
        return this;
    }

    public StarshipSelection mgltNot(String... value) {
        addNotEquals(StarshipColumns.MGLT, value);
        return this;
    }

    public StarshipSelection mgltLike(String... value) {
        addLike(StarshipColumns.MGLT, value);
        return this;
    }

    public StarshipSelection mgltContains(String... value) {
        addContains(StarshipColumns.MGLT, value);
        return this;
    }

    public StarshipSelection mgltStartsWith(String... value) {
        addStartsWith(StarshipColumns.MGLT, value);
        return this;
    }

    public StarshipSelection mgltEndsWith(String... value) {
        addEndsWith(StarshipColumns.MGLT, value);
        return this;
    }

    public StarshipSelection orderByMglt(boolean desc) {
        orderBy(StarshipColumns.MGLT, desc);
        return this;
    }

    public StarshipSelection orderByMglt() {
        orderBy(StarshipColumns.MGLT, false);
        return this;
    }

    public StarshipSelection starshipclass(String... value) {
        addEquals(StarshipColumns.STARSHIPCLASS, value);
        return this;
    }

    public StarshipSelection starshipclassNot(String... value) {
        addNotEquals(StarshipColumns.STARSHIPCLASS, value);
        return this;
    }

    public StarshipSelection starshipclassLike(String... value) {
        addLike(StarshipColumns.STARSHIPCLASS, value);
        return this;
    }

    public StarshipSelection starshipclassContains(String... value) {
        addContains(StarshipColumns.STARSHIPCLASS, value);
        return this;
    }

    public StarshipSelection starshipclassStartsWith(String... value) {
        addStartsWith(StarshipColumns.STARSHIPCLASS, value);
        return this;
    }

    public StarshipSelection starshipclassEndsWith(String... value) {
        addEndsWith(StarshipColumns.STARSHIPCLASS, value);
        return this;
    }

    public StarshipSelection orderByStarshipclass(boolean desc) {
        orderBy(StarshipColumns.STARSHIPCLASS, desc);
        return this;
    }

    public StarshipSelection orderByStarshipclass() {
        orderBy(StarshipColumns.STARSHIPCLASS, false);
        return this;
    }
}
