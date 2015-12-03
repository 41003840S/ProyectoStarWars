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

public class CharacterSQLiteOpenHelper extends SQLiteOpenHelper {
    private static final String TAG = CharacterSQLiteOpenHelper.class.getSimpleName();

    public static final String DATABASE_FILE_NAME = "character.db";
    private static final int DATABASE_VERSION = 1;
    private static CharacterSQLiteOpenHelper sInstance;
    private final Context mContext;
    private final CharacterSQLiteOpenHelperCallbacks mOpenHelperCallbacks;

    // @formatter:off
    public static final String SQL_CREATE_TABLE_CHARACTERS = "CREATE TABLE IF NOT EXISTS "
            + CharactersColumns.TABLE_NAME + " ( "
            + CharactersColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + CharactersColumns.NAME + " TEXT, "
            + CharactersColumns.HEIGHT + " TEXT, "
            + CharactersColumns.MASS + " TEXT, "
            + CharactersColumns.HAIR + " TEXT, "
            + CharactersColumns.SKIN + " TEXT, "
            + CharactersColumns.EYES + " TEXT, "
            + CharactersColumns.BIRTH + " TEXT, "
            + CharactersColumns.GENDER + " TEXT "
            + " );";

    // @formatter:on

    public static CharacterSQLiteOpenHelper getInstance(Context context) {
        // Use the application context, which will ensure that you
        // don't accidentally leak an Activity's context.
        // See this article for more information: http://bit.ly/6LRzfx
        if (sInstance == null) {
            sInstance = newInstance(context.getApplicationContext());
        }
        return sInstance;
    }

    private static CharacterSQLiteOpenHelper newInstance(Context context) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return newInstancePreHoneycomb(context);
        }
        return newInstancePostHoneycomb(context);
    }


    /*
     * Pre Honeycomb.
     */
    private static CharacterSQLiteOpenHelper newInstancePreHoneycomb(Context context) {
        return new CharacterSQLiteOpenHelper(context);
    }

    private CharacterSQLiteOpenHelper(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
        mContext = context;
        mOpenHelperCallbacks = new CharacterSQLiteOpenHelperCallbacks();
    }


    /*
     * Post Honeycomb.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private static CharacterSQLiteOpenHelper newInstancePostHoneycomb(Context context) {
        return new CharacterSQLiteOpenHelper(context, new DefaultDatabaseErrorHandler());
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private CharacterSQLiteOpenHelper(Context context, DatabaseErrorHandler errorHandler) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION, errorHandler);
        mContext = context;
        mOpenHelperCallbacks = new CharacterSQLiteOpenHelperCallbacks();
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        if (BuildConfig.DEBUG) Log.d(TAG, "onCreate");
        mOpenHelperCallbacks.onPreCreate(mContext, db);
        db.execSQL(SQL_CREATE_TABLE_CHARACTERS);
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
