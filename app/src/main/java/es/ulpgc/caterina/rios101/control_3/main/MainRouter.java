package es.ulpgc.caterina.rios101.control_3.main;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.caterina.rios101.control_3.app.AppMediator;

public class MainRouter implements MainContract.Router {

  public static String TAG = MainRouter.class.getSimpleName();

  private AppMediator mediator;

  public MainRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MainActivity.class);
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
}
