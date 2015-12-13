package com.example.manuel.starwars.provider.movies;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.manuel.starwars.provider.StarWarsProvider;
import com.example.manuel.starwars.provider.characters.CharactersColumns;
import com.example.manuel.starwars.provider.movies.MoviesColumns;
import com.example.manuel.starwars.provider.planet.PlanetColumns;
import com.example.manuel.starwars.provider.starship.StarshipColumns;

/**
 * Columns for the {@code movies} table.
 */
public class MoviesColumns implements BaseColumns {
    public static final String TABLE_NAME = "movies";
    public static final Uri CONTENT_URI = Uri.parse(StarWarsProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String TITLE = "title";

    public static final String POPULARITY = "popularity";

    public static final String OVERVIEW = "overview";

    public static final String POSTERPATH = "posterPath";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            TITLE,
            POPULARITY,
            OVERVIEW,
            POSTERPATH
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(TITLE) || c.contains("." + TITLE)) return true;
            if (c.equals(POPULARITY) || c.contains("." + POPULARITY)) return true;
            if (c.equals(OVERVIEW) || c.contains("." + OVERVIEW)) return true;
            if (c.equals(POSTERPATH) || c.contains("." + POSTERPATH)) return true;
        }
        return false;
    }

}
