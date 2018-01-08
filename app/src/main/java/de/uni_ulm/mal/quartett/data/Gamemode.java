package de.uni_ulm.mal.quartett.data;

/**
 * Created by olive on 07.01.2018.
 */

public class Gamemode {

  private int id;
  private String name;
  private int roundCount;
  private int cardCount;
  private String winCondition;
  private int roundLength;
  private String order;
  private Category category;

  public Gamemode(int id, String name, int roundCount, int cardCount, String winCondition, int roundLength, String order, Category category) {
    this.id = id;
    this.name = name;
    this.roundCount = roundCount;
    this.cardCount = cardCount;
    this.winCondition = winCondition;
    this.roundLength = roundLength;
    this.order = order;
    this.category = category;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRoundCount() {
    return roundCount;
  }

  public void setRoundCount(int roundCount) {
    this.roundCount = roundCount;
  }

  public int getCardCount() {
    return cardCount;
  }

  public void setCardCount(int cardCount) {
    this.cardCount = cardCount;
  }

  public String getWinCondition() {
    return winCondition;
  }

  public void setWinCondition(String winCondition) {
    this.winCondition = winCondition;
  }

  public int getRoundLength() {
    return roundLength;
  }

  public void setRoundLength(int roundLength) {
    this.roundLength = roundLength;
  }

  public String getOrder() {
    return order;
  }

  public void setOrder(String order) {
    this.order = order;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }


}
