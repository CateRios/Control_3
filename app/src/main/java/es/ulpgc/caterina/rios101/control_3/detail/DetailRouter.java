package es.ulpgc.caterina.rios101.control_3.detail;

import android.util.Log;
import android.content.Intent;
import android.content.Context;

import es.ulpgc.caterina.rios101.control_3.app.AppMediator;
import es.ulpgc.caterina.rios101.control_3.app.DetailToMainActivityState;
import es.ulpgc.caterina.rios101.control_3.app.MainToDetailState;
import es.ulpgc.caterina.rios101.control_3.main.MainActivity;

public class DetailRouter implements DetailContract.Router {

  public static String TAG = DetailRouter.class.getSimpleName();

  private AppMediator mediator;

  public DetailRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToNextScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, MainActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToNextScreen(DetailState state) {
    mediator.setDetailState(state);
  }

  @Override
  public DetailState getDataFromPreviousScreen() {
    DetailState state = mediator.getDetailState();
    return state;
  }

  //Recuperar estado de Main
  @Override
  public MainToDetailState getDataFromMainScreen(){
    MainToDetailState state = mediator.getMainToDetailState();
    return state;
  }

  //Pasar estado a Main
  @Override
  public void passDataToMainScreen(DetailToMainActivityState state){
    mediator.setDetailToMainActivityState(state);
  }
}
