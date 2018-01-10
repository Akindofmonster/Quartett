package de.uni_ulm.mal.quartett.data;

import android.support.annotation.NonNull;

import java.util.ArrayList;

/**
 * Created by olive on 07.01.2018.
 */

public class Attribute implements Comparable<Attribute> {

  private int id;
  private String name;
  private int value;
  private boolean bigger;
  private int position;
  private String unit;

  public Attribute(int id, String name, int value, boolean bigger, int position, String unit) {
    this.id = id;
    this.name = name;
    this.value = value;
    this.bigger = bigger;
    this.position = position;
    this.unit = unit;
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

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public boolean isBigger() {
    return bigger;
  }

  public void setBigger(boolean bigger) {
    this.bigger = bigger;
  }

  public int getPosition() {
    return position;
  }

  public void setPosition(int position) {
    this.position = position;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Override
  public int compareTo(@NonNull Attribute attribute) {
    if (this.position <= attribute.position) {
      return 1;
    } else {
      return -1;
    }
  }

  public static void bubblesrt(ArrayList<Attribute> list) {
    Attribute temp;
    if (list.size() > 1) // check if the number of orders is larger than 1
    {
      for (int x = 0; x < list.size(); x++) // bubble sort outer loop
      {
        for (int i = 0; i < list.size() - i; i++) {
          if (list.get(i).compareTo(list.get(i + 1)) > 0) {
            temp = list.get(i);
            list.set(i, list.get(i + 1));
            list.set(i + 1, temp);
          }
        }
      }
    }

  }
}
