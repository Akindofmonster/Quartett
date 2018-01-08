package de.uni_ulm.mal.quartett.data;

import java.util.List;

/**
 * Created by olive on 07.01.2018.
 */

public class Card {

  private int id;
  private String name;
  private String picturePath;
  private Category category;
  private List<Attribute> attributes;

  public Card(int id, String name, String picturePath, Category category, List<Attribute> attributes) {
    this.id = id;
    this.name = name;
    this.picturePath = picturePath;
    this.category = category;
    this.attributes = attributes;
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

  public String getPicturePath() {
    return picturePath;
  }

  public void setPicturePath(String picturePath) {
    this.picturePath = picturePath;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  public List<Attribute> getAttributes() {
    return attributes;
  }

  public void setAttributes(List<Attribute> attributes) {
    this.attributes = attributes;
  }

}
