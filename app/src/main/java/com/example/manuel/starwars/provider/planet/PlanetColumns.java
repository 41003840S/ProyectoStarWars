package com.example.manuel.starwars.provider.planet;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.manuel.starwars.provider.StarWarsProvider;


/**
 * Columns for the {@code planet} table.
 */
public class PlanetColumns implements BaseColumns {
    public static final String TABLE_NAME = "planet";
    public static final Uri CONTENT_URI = Uri.parse(StarWarsProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NAME = "name";

    public static final String ROTATIONPERIOD = "rotationPeriod";

    public static final String ORBITALPERIOD = "orbitalPeriod";

    public static final String DIAMETER = "diameter";

    public static final String CLIMATE = "climate";

    public static final String GRAVITY = "gravity";

    public static final String TERRAIN = "terrain";

    public static final String SURFACEWATER = "surfaceWater";

    public static final String POPULATION = "population";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            ROTATIONPERIOD,
            ORBITALPERIOD,
            DIAMETER,
            CLIMATE,
            GRAVITY,
            TERRAIN,
            SURFACEWATER,
            POPULATION
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(ROTATIONPERIOD) || c.contains("." + ROTATIONPERIOD)) return true;
            if (c.equals(ORBITALPERIOD) || c.contains("." + ORBITALPERIOD)) return true;
            if (c.equals(DIAMETER) || c.contains("." + DIAMETER)) return true;
            if (c.equals(CLIMATE) || c.contains("." + CLIMATE)) return true;
            if (c.equals(GRAVITY) || c.contains("." + GRAVITY)) return true;
            if (c.equals(TERRAIN) || c.contains("." + TERRAIN)) return true;
            if (c.equals(SURFACEWATER) || c.contains("." + SURFACEWATER)) return true;
            if (c.equals(POPULATION) || c.contains("." + POPULATION)) return true;
        }
        return false;
    }

}
