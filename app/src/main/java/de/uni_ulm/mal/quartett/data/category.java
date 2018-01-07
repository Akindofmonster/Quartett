package de.uni_ulm.mal.quartett.data;

/**
 * Created by olive on 07.01.2018.
 */

public class category {

  private int id;
  private String name;

  public category(int id, String name) {
    this.id = id;
    this.name = name;
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
}
