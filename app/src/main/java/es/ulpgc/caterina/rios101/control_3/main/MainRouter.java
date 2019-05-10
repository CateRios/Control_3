package es.ulpgc.caterina.rios101.control_3.main;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.caterina.rios101.control_3.app.AppMediator;
import es.ulpgc.caterina.rios101.control_3.app.DetailToMainActivityState;
import es.ulpgc.caterina.rios101.control_3.app.MainToDetailState;
import es.ulpgc.caterina.rios101.control_3.detail.DetailActivity;

public class MainRouter implements MainContract.Router {

  public static String TAG = MainRouter.class.getSimpleName();

  private AppMediator mediator;

  public MainRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, DetailActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(MainState state) {
    mediator.setMainState(state);
  }

  @Override
  public MainState getDataFromPreviousScreen() {
    MainState state = mediator.getMainState();
    return state;
  }

  //Go to detail
  @Override
  public void passDataToDetailScreen(MainToDetailState mainToDetailState){
    mediator.setMainToDetailState(mainToDetailState);
  }

  //Recuperar estado de Detail
  @Override
  public DetailToMainActivityState getDataFromDetailScreen(){
    DetailToMainActivityState state = mediator.getDetailToMainActivityState();
    return state;
  }
}
