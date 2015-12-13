package com.example.manuel.starwars.provider;

import android.annotation.TargetApi;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.DefaultDatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.util.Log;

import com.example.manuel.starwars.BuildConfig;
import com.example.manuel.starwars.provider.characters.CharactersColumns;
import com.example.manuel.starwars.provider.movies.MoviesColumns;
import com.example.manuel.starwars.provider.planet.PlanetColumns;
import com.example.manuel.starwars.provider.starship.StarshipColumns;

public class StarWarsSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = StarWarsSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "starwars.db";
    private static final int DATABASE_VERSION = 1;
    private static StarWarsSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final StarWarsSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_CHARACTERS = "CREATE TABLE IF NOT EXISTS "
            + CharactersColumns.TABLE_NAME + " ( "
            + CharactersColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CharactersColumns.NAME + " TEXT, "
            + CharactersColumns.HEIGHT + " TEXT, "
            + CharactersColumns.MASS + " TEXT, "
            + CharactersColumns.HAIRCOLOR + " TEXT, "
            + CharactersColumns.SKINCOLOR + " TEXT, "
            + CharactersColumns.EYECOLOR + " TEXT, "
            + CharactersColumns.BIRTHYEAR + " TEXT, "
            + CharactersColumns.GENDER + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_MOVIES = "CREATE TABLE IF NOT EXISTS "
            + MoviesColumns.TABLE_NAME + " ( "
            + MoviesColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + MoviesColumns.TITLE + " TEXT, "
            + MoviesColumns.POPULARITY + " TEXT, "
            + MoviesColumns.OVERVIEW + " TEXT, "
            + MoviesColumns.POSTERPATH + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_PLANET = "CREATE TABLE IF NOT EXISTS "
            + PlanetColumns.TABLE_NAME + " ( "
            + PlanetColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + PlanetColumns.NAME + " TEXT, "
            + PlanetColumns.ROTATIONPERIOD + " TEXT, "
            + PlanetColumns.ORBITALPERIOD + " TEXT, "
            + PlanetColumns.DIAMETER + " TEXT, "
            + PlanetColumns.CLIMATE + " TEXT, "
            + PlanetColumns.GRAVITY + " TEXT, "
            + PlanetColumns.TERRAIN + " TEXT, "
            + PlanetColumns.SURFACEWATER + " TEXT, "
            + PlanetColumns.POPULATION + " TEXT "
            + " );";

    public static final String SQL_CREATE_TABLE_STARSHIP = "CREATE TABLE IF NOT EXISTS "
            + StarshipColumns.TABLE_NAME + " ( "
            + StarshipColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + StarshipColumns.NAME + " TEXT, "
            + StarshipColumns.MODEL + " TEXT, "
            + StarshipColumns.MANUFACTURER + " TEXT, "
            + StarshipColumns.COSTINCREDITS + " TEXT, "
            + StarshipColumns.LENGTH + " TEXT, "
            + StarshipColumns.MAXATMOSPHERINGSPEED + " TEXT, "
            + StarshipColumns.CREW + " TEXT, "
            + StarshipColumns.PASSENGERS + " TEXT, "
            + StarshipColumns.CARGOCAPACITY + " TEXT, "
            + StarshipColumns.CONSUMABLES + " TEXT, "
            + StarshipColumns.HYPERDRIVERATING + " TEXT, "
            + StarshipColumns.MGLT + " TEXT, "
            + StarshipColumns.STARSHIPCLASS + " TEXT "
            + " );";

    // @formatter:on

    public static StarWarsSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static StarWarsSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static StarWarsSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new StarWarsSQLiteOpenHelper(context);
    }

    private StarWarsSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new StarWarsSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static StarWarsSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new StarWarsSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private StarWarsSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new StarWarsSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_CHARACTERS);
        db.execSQL(SQL_CREATE_TABLE_MOVIES);
        db.execSQL(SQL_CREATE_TABLE_PLANET);
        db.execSQL(SQL_CREATE_TABLE_STARSHIP);
        mOpenHelperCallbacks.onPostCreate(mContext, db);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            setForeignKeyConstraintsEnabled(db);
        }
        mOpenHelperCallbacks.onOpen(mContext, db);
    }

    private void setForeignKeyConstraintsEnabled(SQLiteDatabase db) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            setForeignKeyConstraintsEnabledPreJellyBean(db);
        } else {
            setForeignKeyConstraintsEnabledPostJellyBean(db);
        }
    }

    private void setForeignKeyConstraintsEnabledPreJellyBean(SQLiteDatabase db) {
        db.execSQL("PRAGMA foreign_keys=ON;");
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void setForeignKeyConstraintsEnabledPostJellyBean(SQLiteDatabase db) {
        db.setForeignKeyConstraintsEnabled(true);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        mOpenHelperCallbacks.onUpgrade(mContext, db, oldVersion, newVersion);
    }
}
