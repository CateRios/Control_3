package es.ulpgc.caterina.rios101.control_3.app;

import android.app.Application;

import es.ulpgc.caterina.rios101.control_3.main.MainState;

public class AppMediator extends Application {

  MainState mainState = new MainState();

  public MainState getMainState() {
    return mainState;
  }

  public void setMainState(MainState mainState) {
    this.mainState = mainState;
  }


}
