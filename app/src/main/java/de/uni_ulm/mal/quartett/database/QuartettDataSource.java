package de.uni_ulm.mal.quartett.database;

/**
 * Created by olive on 08.01.2018.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.util.Log;
import android.content.ContentValues;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import de.uni_ulm.mal.quartett.MainActivity;
import de.uni_ulm.mal.quartett.data.Category;
import de.uni_ulm.mal.quartett.data.Gamemode;
import de.uni_ulm.mal.quartett.data.Settings;


public class QuartettDataSource {

  private static final String LOG_TAG = MainActivity.class.getSimpleName();

  private SQLiteDatabase database;
  private QuartettDbHelper dbHelper;


  public QuartettDataSource(Context context) {
    Log.d(LOG_TAG, "Unsere DataSource erzeugt jetzt den dbHelper.");
    dbHelper = new QuartettDbHelper(context);
  }

  public void open() {
    Log.d(LOG_TAG, "Eine Referenz auf die Datenbank wird jetzt angefragt.");
    database = dbHelper.getWritableDatabase();
    Log.d(LOG_TAG, "Datenbank-Referenz erhalten. Pfad zur Datenbank: " + database.getPath());
  }

  public void close() {
    dbHelper.close();
    Log.d(LOG_TAG, "Datenbank mit Hilfe des DbHelpers geschlossen.");
  }

  /*public ShoppingMemo createShoppingMemo(String product, int quantity) {
    ContentValues values = new ContentValues();
    values.put(QuartettDbHelper.COLUMN_PRODUCT, product);
    values.put(QuartettDbHelper.COLUMN_QUANTITY, quantity);

    long insertId = database.insert(QuartettDbHelper.TABLE_SHOPPING_LIST, null, values);

    Cursor cursor = database.query(QuartettDbHelper.TABLE_SHOPPING_LIST,
            columns, QuartettDbHelper.COLUMN_ID + "=" + insertId,
            null, null, null, null);

    cursor.moveToFirst();
    ShoppingMemo shoppingMemo = cursorToShoppingMemo(cursor);
    cursor.close();

    return shoppingMemo;
  }*/

  /*public void deleteShoppingMemo(ShoppingMemo shoppingMemo) {
    long id = shoppingMemo.getId();

    database.delete(QuartettDbHelper.TABLE_SHOPPING_LIST,
            QuartettDbHelper.COLUMN_ID + "=" + id,
            null);

    Log.d(LOG_TAG, "Eintrag gelöscht! ID: " + id + " Inhalt: " + shoppingMemo.toString());
  }*/

  /*public ShoppingMemo updateShoppingMemo(long id, String newProduct, int newQuantity, boolean newChecked) {
    int intValueChecked = (newChecked) ? 1 : 0;

    ContentValues values = new ContentValues();
    values.put(QuartettDbHelper.COLUMN_PRODUCT, newProduct);
    values.put(QuartettDbHelper.COLUMN_QUANTITY, newQuantity);
    values.put(QuartettDbHelper.COLUMN_CHECKED, intValueChecked);

    database.update(QuartettDbHelper.TABLE_SHOPPING_LIST,
            values,
            QuartettDbHelper.COLUMN_ID + "=" + id,
            null);

    Cursor cursor = database.query(QuartettDbHelper.TABLE_SHOPPING_LIST,
            columns, QuartettDbHelper.COLUMN_ID + "=" + id,
            null, null, null, null);

    cursor.moveToFirst();
    ShoppingMemo shoppingMemo = cursorToShoppingMemo(cursor);
    cursor.close();

    return shoppingMemo;
  }*/

  /*private ShoppingMemo cursorToShoppingMemo(Cursor cursor) {
    int idIndex = cursor.getColumnIndex(QuartettDbHelper.COLUMN_ID);
    int idProduct = cursor.getColumnIndex(QuartettDbHelper.COLUMN_PRODUCT);
    int idQuantity = cursor.getColumnIndex(QuartettDbHelper.COLUMN_QUANTITY);
    int idChecked = cursor.getColumnIndex(QuartettDbHelper.COLUMN_CHECKED);

    String product = cursor.getString(idProduct);
    int quantity = cursor.getInt(idQuantity);
    long id = cursor.getLong(idIndex);
    int intValueChecked = cursor.getInt(idChecked);

    boolean isChecked = (intValueChecked != 0);

    ShoppingMemo shoppingMemo = new ShoppingMemo(product, quantity, id, isChecked);

    return shoppingMemo;
  }*/

  private Settings cursorToSetting(Cursor cursor) {
    int idMusikVolume = cursor.getColumnIndex(QuartettDbHelper.columnsSettings[0]);
    int idSfxVolume = cursor.getColumnIndex(QuartettDbHelper.columnsSettings[1]);
    int idNotification = cursor.getColumnIndex(QuartettDbHelper.columnsSettings[2]);
    int idVibration = cursor.getColumnIndex(QuartettDbHelper.columnsSettings[3]);
    int idSoonEnding = cursor.getColumnIndex(QuartettDbHelper.columnsSettings[4]);

    int musikVolume = cursor.getInt(idMusikVolume);
    int sfxVolume = cursor.getInt(idSfxVolume);
    boolean notification = cursor.getInt(idNotification) != 0;
    boolean vibration = cursor.getInt(idVibration) != 0;
    boolean soonEnding = cursor.getInt(idSoonEnding) != 0;

    Settings setting = new Settings(musikVolume, sfxVolume, notification, vibration, soonEnding);

    return setting;
  }

  private Category cursorToCategory(Cursor cursor) {
    int idID = cursor.getColumnIndex(QuartettDbHelper.columnsCategory[0]);
    int idName = cursor.getColumnIndex(QuartettDbHelper.columnsCategory[1]);
    int idNotification = cursor.getColumnIndex(QuartettDbHelper.columnsCategory[2]);
    int idVibration = cursor.getColumnIndex(QuartettDbHelper.columnsCategory[3]);

    int id = cursor.getInt(idID);
    String name = cursor.getString(idName);
    String minAttributeString = cursor.getString(idNotification);
    String maxAttributeString = cursor.getString(idVibration);

    String[] tempMin = minAttributeString.split(",");
    String[] tempMax = maxAttributeString.split(",");

    ArrayList<Integer> minAttribute = new ArrayList<>();
    ArrayList<Integer> maxAttribute = new ArrayList<>();

    for (String s : tempMin) {
      minAttribute.add(Integer.parseInt(s));
    }

    for (String s : tempMax) {
      maxAttribute.add(Integer.parseInt(s));
    }

    Category category = new Category(id, name, minAttribute, maxAttribute);

    return category;
  }

  /*private Gamemode cursorTo(Cursor cursor) {
    int idID = cursor.getColumnIndex(QuartettDbHelper.columns[]);
    int idName = cursor.getColumnIndex(QuartettDbHelper.columns[]);
    int idRoundCount = cursor.getColumnIndex(QuartettDbHelper.columns[]);
    int idCartCount = cursor.getColumnIndex(QuartettDbHelper.columns[]);
    int idWinCondition = cursor.getColumnIndex(QuartettDbHelper.columns[]);
    int id = cursor.getColumnIndex(QuartettDbHelper.columns[]);
    int id = cursor.getColumnIndex(QuartettDbHelper.columns[]);
    int id = cursor.getColumnIndex(QuartettDbHelper.columns[]);

    int = cursor.getInt(id);

    Gamemode setting = new Gamemode();

    return setting;
  }

  private Settings cursorTo(Cursor cursor) {
    int id = cursor.getColumnIndex(QuartettDbHelper.columns[]);

    int = cursor.getInt(id);

    Settings setting = new Settings(musikVolume, sfxVolume, notification, vibration, soonEnding);

    return setting;
  }

  private Settings cursorTo(Cursor cursor) {
    int id = cursor.getColumnIndex(QuartettDbHelper.columns[]);

    int = cursor.getInt(id);

    Settings setting = new Settings(musikVolume, sfxVolume, notification, vibration, soonEnding);

    return setting;
  }*/



  /*public List<ShoppingMemo> getAllShoppingMemos() {
    List<ShoppingMemo> shoppingMemoList = new ArrayList<>();

    Cursor cursor = database.query(QuartettDbHelper.TABLE_SHOPPING_LIST,
            columns, null, null, null, null, null);

    cursor.moveToFirst();
    ShoppingMemo shoppingMemo;

    while (!cursor.isAfterLast()) {
      shoppingMemo = cursorToShoppingMemo(cursor);
      shoppingMemoList.add(shoppingMemo);
      Log.d(LOG_TAG, "ID: " + shoppingMemo.getId() + ", Inhalt: " + shoppingMemo.toString());
      cursor.moveToNext();
    }

    cursor.close();

    return shoppingMemoList;
  }*/


}