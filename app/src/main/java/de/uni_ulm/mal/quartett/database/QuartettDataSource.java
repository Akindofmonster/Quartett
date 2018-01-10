package de.uni_ulm.mal.quartett.database;

/**
 * Created by olive on 08.01.2018.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import de.uni_ulm.mal.quartett.MainActivity;
import de.uni_ulm.mal.quartett.data.Attribute;
import de.uni_ulm.mal.quartett.data.Card;
import de.uni_ulm.mal.quartett.data.Category;
import de.uni_ulm.mal.quartett.data.Game;
import de.uni_ulm.mal.quartett.data.GameMode;
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

  public ArrayList<Card> getAllCards(Category category) {
    return null;
  }

  public ArrayList<Category> getAllCategorys() {
    return null;
  }

  public Settings getSettings() {
    return null;
  }

  public ArrayList<GameMode> getAllGameModes() {
    return null;
  }

  public ArrayList<Game> getAllGames() {
    return null;
  }

  public Card getCard(int id) {
    return null;
  }

  public Category getCategory(int id) {
    return null;
  }

  public GameMode getGameMode(int id) {
    return null;
  }

  public Game getGame(int id) {
    return null;
  }

  /*public Game createGame(Game game) {
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

  public void deleteGame(Game game) {
    long id = game.getId();

    database.delete(QuartettDbHelper.TABLE_GAME,
            QuartettDbHelper.columnsGame[0] + "=" + id,
            null);
  }

  /*public void updateGame(Game game) {

    ContentValues values = new ContentValues();
    values.put(QuartettDbHelper.columnsGame[0], game.getId());
    values.put(QuartettDbHelper.columnsGame[1], game.getDrawRounds());
    values.put(QuartettDbHelper.columnsGame[2], game.getWinRounds());
    values.put(QuartettDbHelper.columnsGame[3], game.getLostRounds());
    values.put(QuartettDbHelper.columnsGame[4], game.getNumberOfCards());
    values.put(QuartettDbHelper.columnsGame[5], game.getEnemyNumberOfCards());
    values.put(QuartettDbHelper.columnsGame[6], game.getStartTimeRound());
    values.put(QuartettDbHelper.columnsGame[7], game.isKi() ? 1 : 0);
    values.put(QuartettDbHelper.columnsGame[8], game.getGameMode().getId());

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


  public void updateSettings(Settings settings) {

    ContentValues values = new ContentValues();
    values.put(QuartettDbHelper.columnsSettings[0], settings.getMusic_volume());
    values.put(QuartettDbHelper.columnsSettings[1], settings.getSound_volume());
    values.put(QuartettDbHelper.columnsSettings[2], settings.isNotification() ? 1 : 0);
    values.put(QuartettDbHelper.columnsSettings[3], settings.isVibration() ? 1 : 0);
    values.put(QuartettDbHelper.columnsSettings[4], settings.isSoon_ending_message() ? 1 : 0);

    database.update(QuartettDbHelper.TABLE_SETTINGS,
            values,
            null,
            null);
  }

  //region Delete and update
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
  //endregion

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

  private GameMode cursorToGamemode(Cursor cursor) {
    int idID = cursor.getColumnIndex(QuartettDbHelper.columnsGamemode[0]);
    int idName = cursor.getColumnIndex(QuartettDbHelper.columnsGamemode[1]);
    int idRoundCount = cursor.getColumnIndex(QuartettDbHelper.columnsGamemode[2]);
    int idCardCount = cursor.getColumnIndex(QuartettDbHelper.columnsGamemode[3]);
    int idWinCondition = cursor.getColumnIndex(QuartettDbHelper.columnsGamemode[4]);
    int idRoundLength = cursor.getColumnIndex(QuartettDbHelper.columnsGamemode[5]);
    int idOrder = cursor.getColumnIndex(QuartettDbHelper.columnsGamemode[6]);
    int idCategoryID = cursor.getColumnIndex(QuartettDbHelper.columnsGamemode[7]);

    int id = cursor.getInt(idID);
    String name = cursor.getString(idName);
    int roundCount = cursor.getInt(idRoundCount);
    int cardCount = cursor.getInt(idCardCount);
    String winCondition = cursor.getString(idWinCondition);
    int roundLength = cursor.getInt(idRoundLength);
    String order = cursor.getString(idOrder);
    int categoryID = cursor.getInt(idCategoryID);

    Cursor cursor2 = database.query(QuartettDbHelper.TABLE_CATEGORY,
            QuartettDbHelper.columnsCategory, QuartettDbHelper.columnsCategory[0] + "=" + categoryID,
            null, null, null, null);

    cursor2.moveToFirst();
    Category category = cursorToCategory(cursor2);

    GameMode gameMode = new GameMode(id, name, roundCount, cardCount, winCondition, roundLength, order, category);

    return gameMode;
  }

  private Game cursorToGame(Cursor cursor) {
    int idID = cursor.getColumnIndex(QuartettDbHelper.columnsGame[0]);
    int idDrawRounds = cursor.getColumnIndex(QuartettDbHelper.columnsGame[1]);
    int idWinRounds = cursor.getColumnIndex(QuartettDbHelper.columnsGame[2]);
    int idLostRounds = cursor.getColumnIndex(QuartettDbHelper.columnsGame[3]);
    int idNumberOfCards = cursor.getColumnIndex(QuartettDbHelper.columnsGame[4]);
    int idEnemyNumberOfCards = cursor.getColumnIndex(QuartettDbHelper.columnsGame[5]);
    int idStartTimeRound = cursor.getColumnIndex(QuartettDbHelper.columnsGame[6]);
    int idKi = cursor.getColumnIndex(QuartettDbHelper.columnsGame[7]);
    int idGameModeID = cursor.getColumnIndex(QuartettDbHelper.columnsGame[8]);

    int id = cursor.getInt(idID);
    int drawRounds = cursor.getInt(idDrawRounds);
    int winRounds = cursor.getInt(idWinRounds);
    int lostRounds = cursor.getInt(idLostRounds);
    int numberOfCards = cursor.getInt(idNumberOfCards);
    int enemyNumberOfCards = cursor.getInt(idEnemyNumberOfCards);
    int startTimeRound = cursor.getInt(idStartTimeRound);
    boolean ki = cursor.getInt(idKi) != 0;
    int gamemodeID = cursor.getInt(idGameModeID);

    Cursor cursor2 = database.query(QuartettDbHelper.TABLE_GAMEMODE,
            QuartettDbHelper.columnsGamemode, QuartettDbHelper.columnsGamemode[0] + "=" + gamemodeID,
            null, null, null, null);

    cursor2.moveToFirst();
    GameMode gameMode = cursorToGamemode(cursor2);

    Game game = new Game(id, drawRounds, winRounds, lostRounds, numberOfCards, enemyNumberOfCards, startTimeRound, ki, gameMode);

    return game;
  }

  private Attribute cursorToAttribute(Cursor cursor) {
    int idID = cursor.getColumnIndex(QuartettDbHelper.columnsAttribute[0]);
    int idValue = cursor.getColumnIndex(QuartettDbHelper.columnsAttribute[1]);
    int idCardAttributeID = cursor.getColumnIndex(QuartettDbHelper.columnsAttribute[2]);
    //int idCardID = cursor.getColumnIndex(QuartettDbHelper.columnsAttribute[3]);

    int id = cursor.getInt(idID);
    int value = cursor.getInt(idValue);
    int cardAttributeID = cursor.getInt(idCardAttributeID);


    //Getting Attribute Values from the Card-Attribute table
    Cursor cursor2 = database.query(QuartettDbHelper.TABLE_CARD_ATTRIBUTE,
            QuartettDbHelper.columnsCardAttribute, QuartettDbHelper.columnsCardAttribute[0] + "=" + cardAttributeID,
            null, null, null, null);

    cursor2.moveToFirst();

    //int idID = cursor2.getColumnIndex(QuartettDbHelper.columnsCardAttribute[0]);
    int idName = cursor2.getColumnIndex(QuartettDbHelper.columnsCardAttribute[1]);
    int idBigger = cursor2.getColumnIndex(QuartettDbHelper.columnsCardAttribute[2]);
    int idUnit = cursor2.getColumnIndex(QuartettDbHelper.columnsCardAttribute[3]);
    int idPosition = cursor2.getColumnIndex(QuartettDbHelper.columnsCardAttribute[4]);

    String name = cursor.getString(idName);
    boolean bigger = cursor.getInt(idBigger) != 0;
    String unit = cursor.getString(idUnit);
    int position = cursor.getInt(idPosition);

    Attribute attribute = new Attribute(id, name, value, bigger, position, unit);

    return attribute;
  }

  private Card cursorTo(Cursor cursor) {
    int idID = cursor.getColumnIndex(QuartettDbHelper.columnsCard[0]);
    int idCategoryID = cursor.getColumnIndex(QuartettDbHelper.columnsCard[1]);
    int idName = cursor.getColumnIndex(QuartettDbHelper.columnsCard[2]);
    int idPicture = cursor.getColumnIndex(QuartettDbHelper.columnsCard[3]);

    int id = cursor.getInt(idID);
    int categoryID = cursor.getInt(idCategoryID);
    String name = cursor.getString(idName);
    String picture = cursor.getString(idPicture);

    //Getting Category
    Cursor cursor2 = database.query(QuartettDbHelper.TABLE_CATEGORY,
            QuartettDbHelper.columnsCategory, QuartettDbHelper.columnsCategory[0] + "=" + categoryID,
            null, null, null, null);

    cursor2.moveToFirst();
    Category category = cursorToCategory(cursor2);


    //Getting Attributes
    Cursor cursor3 = database.query(QuartettDbHelper.TABLE_ATTRIBUTE,
            QuartettDbHelper.columnsAttribute, QuartettDbHelper.columnsAttribute[3] + "=" + id,
            null, null, null, null);

    cursor3.moveToFirst();

    ArrayList<Attribute> attributes = new ArrayList<>();
    Attribute attribute;

    while (!cursor.isAfterLast()) {
      attribute = cursorToAttribute(cursor3);
      attributes.add(attribute);
      cursor.moveToNext();
    }

    Attribute.bubblesrt(attributes);

    Card card = new Card(id, name, picture, category, attributes);

    return card;
  }



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