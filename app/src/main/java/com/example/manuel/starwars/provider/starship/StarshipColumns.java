package com.example.manuel.starwars.provider.starship;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.manuel.starwars.provider.StarWarsProvider;
import com.example.manuel.starwars.provider.characters.CharactersColumns;
import com.example.manuel.starwars.provider.movies.MoviesColumns;
import com.example.manuel.starwars.provider.planet.PlanetColumns;
import com.example.manuel.starwars.provider.starship.StarshipColumns;

/**
 * Columns for the {@code starship} table.
 */
public class StarshipColumns implements BaseColumns {
    public static final String TABLE_NAME = "starship";
    public static final Uri CONTENT_URI = Uri.parse(StarWarsProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NAME = "name";

    public static final String MODEL = "model";

    public static final String MANUFACTURER = "manufacturer";

    public static final String COSTINCREDITS = "costInCredits";

    public static final String LENGTH = "length";

    public static final String MAXATMOSPHERINGSPEED = "maxAtmospheringSpeed";

    public static final String CREW = "crew";

    public static final String PASSENGERS = "passengers";

    public static final String CARGOCAPACITY = "cargoCapacity";

    public static final String CONSUMABLES = "consumables";

    public static final String HYPERDRIVERATING = "hyperdriveRating";

    public static final String MGLT = "mglt";

    public static final String STARSHIPCLASS = "starshipClass";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            MODEL,
            MANUFACTURER,
            COSTINCREDITS,
            LENGTH,
            MAXATMOSPHERINGSPEED,
            CREW,
            PASSENGERS,
            CARGOCAPACITY,
            CONSUMABLES,
            HYPERDRIVERATING,
            MGLT,
            STARSHIPCLASS
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(MODEL) || c.contains("." + MODEL)) return true;
            if (c.equals(MANUFACTURER) || c.contains("." + MANUFACTURER)) return true;
            if (c.equals(COSTINCREDITS) || c.contains("." + COSTINCREDITS)) return true;
            if (c.equals(LENGTH) || c.contains("." + LENGTH)) return true;
            if (c.equals(MAXATMOSPHERINGSPEED) || c.contains("." + MAXATMOSPHERINGSPEED)) return true;
            if (c.equals(CREW) || c.contains("." + CREW)) return true;
            if (c.equals(PASSENGERS) || c.contains("." + PASSENGERS)) return true;
            if (c.equals(CARGOCAPACITY) || c.contains("." + CARGOCAPACITY)) return true;
            if (c.equals(CONSUMABLES) || c.contains("." + CONSUMABLES)) return true;
            if (c.equals(HYPERDRIVERATING) || c.contains("." + HYPERDRIVERATING)) return true;
            if (c.equals(MGLT) || c.contains("." + MGLT)) return true;
            if (c.equals(STARSHIPCLASS) || c.contains("." + STARSHIPCLASS)) return true;
        }
        return false;
    }

}
