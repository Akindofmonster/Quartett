package de.uni_ulm.mal.quartett.data;

/**
 * Created by olive on 07.01.2018.
 */

public class setting {

  private int music_volume;
  private int sound_volume;
  private boolean notification;
  private boolean vibration;
  private boolean soon_ending_message;

  public setting(int music_volume, int sound_volume, boolean notification, boolean vibration, boolean soon_ending_message) {
    this.music_volume = music_volume;
    this.sound_volume = sound_volume;
    this.notification = notification;
    this.vibration = vibration;
    this.soon_ending_message = soon_ending_message;
  }

  public boolean isNotification() {
    return notification;
  }

  public void setNotification(boolean notification) {
    this.notification = notification;
  }

  public int getMusic_volume() {
    return music_volume;
  }

  public void setMusic_volume(int music_volume) {
    this.music_volume = music_volume;
  }

  public int getSound_volume() {
    return sound_volume;
  }

  public void setSound_volume(int sound_volume) {
    this.sound_volume = sound_volume;
  }

  public boolean isVibration() {
    return vibration;
  }

  public void setVibration(boolean vibration) {
    this.vibration = vibration;
  }

  public boolean isSoon_ending_message() {
    return soon_ending_message;
  }

  public void setSoon_ending_message(boolean soon_ending_message) {
    this.soon_ending_message = soon_ending_message;
  }
}
