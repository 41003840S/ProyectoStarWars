package com.example.manuel.starwars.provider.characters;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.manuel.starwars.provider.StarWarsProvider;
import com.example.manuel.starwars.provider.characters.CharactersColumns;
import com.example.manuel.starwars.provider.movies.MoviesColumns;
import com.example.manuel.starwars.provider.planet.PlanetColumns;
import com.example.manuel.starwars.provider.starship.StarshipColumns;

/**
 * Columns for the {@code characters} table.
 */
public class CharactersColumns implements BaseColumns {
    public static final String TABLE_NAME = "characters";
    public static final Uri CONTENT_URI = Uri.parse(StarWarsProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NAME = "name";

    public static final String HEIGHT = "height";

    public static final String MASS = "mass";

    public static final String HAIRCOLOR = "hairColor";

    public static final String SKINCOLOR = "skinColor";

    public static final String EYECOLOR = "eyeColor";

    public static final String BIRTHYEAR = "birthYear";

    public static final String GENDER = "gender";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            HEIGHT,
            MASS,
            HAIRCOLOR,
            SKINCOLOR,
            EYECOLOR,
            BIRTHYEAR,
            GENDER
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(HEIGHT) || c.contains("." + HEIGHT)) return true;
            if (c.equals(MASS) || c.contains("." + MASS)) return true;
            if (c.equals(HAIRCOLOR) || c.contains("." + HAIRCOLOR)) return true;
            if (c.equals(SKINCOLOR) || c.contains("." + SKINCOLOR)) return true;
            if (c.equals(EYECOLOR) || c.contains("." + EYECOLOR)) return true;
            if (c.equals(BIRTHYEAR) || c.contains("." + BIRTHYEAR)) return true;
            if (c.equals(GENDER) || c.contains("." + GENDER)) return true;
        }
        return false;
    }

}
