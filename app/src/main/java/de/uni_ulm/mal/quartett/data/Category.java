package de.uni_ulm.mal.quartett.data;

import java.util.ArrayList;
import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by olive on 07.01.2018.
 */

public class Category {

  private int id;
  private String name;
  private ArrayList<Integer> minAttribute;
  private ArrayList<Integer> maxAttribute;

  public Category(int id, String name, ArrayList<Integer> minAttribute, ArrayList<Integer> maxAttribute) {
    this.id = id;
    this.name = name;
    this.minAttribute = minAttribute;
    this.maxAttribute = maxAttribute;
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

  public List<Integer> getMinAttribute() {
    return minAttribute;
  }

  public void setMinAttribute(ArrayList<Integer> minAttribute) {
    this.minAttribute = minAttribute;
  }

  public List<Integer> getMaxAttribute() {
    return maxAttribute;
  }

  public void setMaxAttribute(ArrayList<Integer> maxAttribute) {
    this.maxAttribute = maxAttribute;
  }
}
