package de.uni_ulm.mal.quartett.data;

/**
 * Created by olive on 07.01.2018.
 */

public class Attribute {

  private int id;
  private String name;
  private int bigger_smaller;
  private int value;

  public Attribute(int id, String name, int bigger_smaller, int value) {
    this.id = id;
    this.name = name;
    this.bigger_smaller = bigger_smaller;
    this.value = value;
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

  public int getBigger_smaller() {
    return bigger_smaller;
  }

  public void setBigger_smaller(int bigger_smaller) {
    this.bigger_smaller = bigger_smaller;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
