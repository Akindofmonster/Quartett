package de.uni_ulm.mal.quartett.data;

/**
 * Created by olive on 07.01.2018.
 */

public class game {

  private int id;
  private int drawRounds;
  private int winRounds;
  private int lostRounds;
  private int numberOfCards;
  private int enemyNumberOfCards;
  private int startTimeRound;
  private boolean ki;
  private int gamemode;

  public game(int id, int drawRounds, int winRounds, int lostRounds, int numberOfCards, int enemyNumberOfCards, int startTimeRound, boolean ki, int gamemode) {
    this.id = id;
    this.drawRounds = drawRounds;
    this.winRounds = winRounds;
    this.lostRounds = lostRounds;
    this.numberOfCards = numberOfCards;
    this.enemyNumberOfCards = enemyNumberOfCards;
    this.startTimeRound = startTimeRound;
    this.ki = ki;
    this.gamemode = gamemode;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getDrawRounds() {
    return drawRounds;
  }

  public void setDrawRounds(int drawRounds) {
    this.drawRounds = drawRounds;
  }

  public int getWinRounds() {
    return winRounds;
  }

  public void setWinRounds(int winRounds) {
    this.winRounds = winRounds;
  }

  public int getLostRounds() {
    return lostRounds;
  }

  public void setLostRounds(int lostRounds) {
    this.lostRounds = lostRounds;
  }

  public int getNumberOfCards() {
    return numberOfCards;
  }

  public void setNumberOfCards(int numberOfCards) {
    this.numberOfCards = numberOfCards;
  }

  public int getEnemyNumberOfCards() {
    return enemyNumberOfCards;
  }

  public void setEnemyNumberOfCards(int enemyNumberOfCards) {
    this.enemyNumberOfCards = enemyNumberOfCards;
  }

  public int getStartTimeRound() {
    return startTimeRound;
  }

  public void setStartTimeRound(int startTimeRound) {
    this.startTimeRound = startTimeRound;
  }

  public boolean isKi() {
    return ki;
  }

  public void setKi(boolean ki) {
    this.ki = ki;
  }

  public int getGamemode() {
    return gamemode;
  }

  public void setGamemode(int gamemode) {
    this.gamemode = gamemode;
  }


}
