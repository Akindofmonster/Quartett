package de.uni_ulm.mal.quartett.data;

import java.util.List;
import java.util.jar.Attributes;

/**
 * Created by olive on 07.01.2018.
 */

public class Category {

  private int id;
  private String name;
  private List<Integer> minAttribute;
  private List<Integer> maxAttribute;

  public Category(int id, String name, List<Integer> minAttribute, List<Integer> maxAttribute) {
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

  public void setMinAttribute(List<Integer> minAttribute) {
    this.minAttribute = minAttribute;
  }

  public List<Integer> getMaxAttribute() {
    return maxAttribute;
  }

  public void setMaxAttribute(List<Integer> maxAttribute) {
    this.maxAttribute = maxAttribute;
  }
}
