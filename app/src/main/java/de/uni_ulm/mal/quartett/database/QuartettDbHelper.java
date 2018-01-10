package de.uni_ulm.mal.quartett.database;

/**
 * Created by olive on 08.01.2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class QuartettDbHelper extends SQLiteOpenHelper {

  private static final String LOG_TAG = QuartettDbHelper.class.getSimpleName();

  public static final String DB_NAME = "quartett.db";
  public static final int DB_VERSION = 1;

  public static final String TABLE_SETTINGS = "Einstellungen";
  public static final String TABLE_GAME = "Spiel";
  public static final String TABLE_CATEGORY = "Kategorie";
  public static final String TABLE_GAMEMODE = "Spielmodus";
  public static final String TABLE_CARD = "Karte";
  public static final String TABLE_ATTRIBUTE = "Attribut";
  public static final String TABLE_CARD_ATTRIBUTE = "Karten_Attribut";

  public static final String[] columnsSettings = {
          "musik_lautstärke", "sfx_lautstärke", "benachrichtigung", "vibration", "bald_endend_meldung"
  };
  public static final String[] columnsGamemode = {
          "id", "name", "rundenanzahl", "kartenanzahl", "siegbedingung", "rundendauer", "reihenfolge", "kategorie"
  };
  public static final String[] columnsCategory = {
          "id", "name", "minAttribute", "maxAttribute"
  };
  public static final String[] columnsGame = {
          "id", "unentschieden_runden", "gewonnene_runden", "verlorene_runden",
          "eigene_kartenanzahl", "gegner_kartenanzahl", "startzeit_runde", "ki", "spielmodus"
  };
  public static final String[] columnsCard = {
          "id", "kategorie", "name", "bild"
  };
  public static final String[] columnsAttribute = {
          "id", "wert", "karten_attribut", "karte"
  };
  public static final String[] columnsCardAttribute = {
          "id", "name", "größer", "einheit", "position"
  };

  public String SQL_CREATE;

  public static final String SQL_DROP1 = "DROP TABLE IF EXISTS " + TABLE_ATTRIBUTE;
  public static final String SQL_DROP2 = "DROP TABLE IF EXISTS " + TABLE_GAME;
  public static final String SQL_DROP3 = "DROP TABLE IF EXISTS " + TABLE_GAMEMODE;
  public static final String SQL_DROP4 = "DROP TABLE IF EXISTS " + TABLE_CARD;
  public static final String SQL_DROP5 = "DROP TABLE IF EXISTS " + TABLE_CARD_ATTRIBUTE;
  public static final String SQL_DROP6 = "DROP TABLE IF EXISTS " + TABLE_CATEGORY;
  public static final String SQL_DROP7 = "DROP TABLE IF EXISTS " + TABLE_SETTINGS;


  public QuartettDbHelper(Context context) {
    super(context, DB_NAME, null, DB_VERSION);
    Log.d(LOG_TAG, "DbHelper hat die Datenbank: " + getDatabaseName() + " erzeugt.");
  }

  //Wird nur aufgerufen, wenn die Datenbank neu erstellt wir
  @Override
  public void onCreate(SQLiteDatabase db) {
    //TODO Create sql script file
    //TODO import sql script in SQL_CREATE
    try {
      Log.d(LOG_TAG, "Die Tabelle wird mit SQL-Befehl: " + SQL_CREATE + " angelegt.");
      db.execSQL(SQL_CREATE);
    } catch (Exception ex) {
      Log.e(LOG_TAG, "Fehler beim Anlegen der Tabelle: " + ex.getMessage());
    }
  }

  // Die onUpgrade-Methode wird aufgerufen, sobald die neue Versionsnummer höher
  // als die alte Versionsnummer ist und somit ein Upgrade notwendig wird
  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    Log.d(LOG_TAG, "Die Tabelle mit Versionsnummer " + oldVersion + " wird entfernt.");
    db.execSQL(SQL_DROP1);
    db.execSQL(SQL_DROP2);
    db.execSQL(SQL_DROP3);
    db.execSQL(SQL_DROP4);
    db.execSQL(SQL_DROP5);
    db.execSQL(SQL_DROP6);
    db.execSQL(SQL_DROP7);
    onCreate(db);
  }
}