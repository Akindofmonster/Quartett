package de.uni_ulm.mal.quartett;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //Remove title bar
    this.requestWindowFeature(Window.FEATURE_NO_TITLE);

    //Remove notification bar
    //this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    //set content view AFTER ABOVE sequence (to avoid crash)
    setContentView(R.layout.activity_main);
  }
}
