package es.ulpgc.caterina.rios101.control_3.app;

import android.app.Application;

import es.ulpgc.caterina.rios101.control_3.detail.DetailState;
import es.ulpgc.caterina.rios101.control_3.main.MainState;

public class AppMediator extends Application {

  MainState mainState = new MainState();

  DetailState detailState = new DetailState();

  MainToDetailState mainToDetailState = new MainToDetailState();

  DetailToMainActivityState detailToMainActivityState = new DetailToMainActivityState();

  public MainState getMainState() {
    return mainState;
  }

  public void setMainState(MainState mainState) {
    this.mainState = mainState;
  }

  public DetailState getDetailState() {
    return detailState;
  }

  public void setDetailState(DetailState detailState) {
    this.detailState = detailState;
  }

  public MainToDetailState getMainToDetailState() {
    return mainToDetailState;
  }

  public void setMainToDetailState(MainToDetailState mainToDetailState) {
    this.mainToDetailState = mainToDetailState;
  }

  public DetailToMainActivityState getDetailToMainActivityState() {
    return detailToMainActivityState;
  }

  public void setDetailToMainActivityState(DetailToMainActivityState detailToMainActivityState) {
    this.detailToMainActivityState = detailToMainActivityState;
  }


}
