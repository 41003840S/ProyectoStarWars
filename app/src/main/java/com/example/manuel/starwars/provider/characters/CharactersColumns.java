package com.example.manuel.starwars.provider.characters;

import android.net.Uri;
import android.provider.BaseColumns;

import com.example.manuel.starwars.provider.CharacterProvider;
import com.example.manuel.starwars.provider.characters.CharactersColumns;

/**
 * Columns for the {@code characters} table.
 */
public class CharactersColumns implements BaseColumns {
    public static final String TABLE_NAME = "characters";
    public static final Uri CONTENT_URI = Uri.parse(CharacterProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String NAME = "name";

    public static final String HEIGHT = "height";

    public static final String MASS = "mass";

    public static final String HAIR = "hair";

    public static final String SKIN = "skin";

    public static final String EYES = "eyes";

    public static final String BIRTH = "birth";

    public static final String GENDER = "gender";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            NAME,
            HEIGHT,
            MASS,
            HAIR,
            SKIN,
            EYES,
            BIRTH,
            GENDER
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(NAME) || c.contains("." + NAME)) return true;
            if (c.equals(HEIGHT) || c.contains("." + HEIGHT)) return true;
            if (c.equals(MASS) || c.contains("." + MASS)) return true;
            if (c.equals(HAIR) || c.contains("." + HAIR)) return true;
            if (c.equals(SKIN) || c.contains("." + SKIN)) return true;
            if (c.equals(EYES) || c.contains("." + EYES)) return true;
            if (c.equals(BIRTH) || c.contains("." + BIRTH)) return true;
            if (c.equals(GENDER) || c.contains("." + GENDER)) return true;
        }
        return false;
    }

}
