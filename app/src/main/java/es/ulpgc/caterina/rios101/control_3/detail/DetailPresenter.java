package es.ulpgc.caterina.rios101.control_3.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.caterina.rios101.control_3.app.ContadorItem;
import es.ulpgc.caterina.rios101.control_3.app.DetailToMainActivityState;
import es.ulpgc.caterina.rios101.control_3.app.MainToDetailState;
import es.ulpgc.caterina.rios101.control_3.main.MainState;

public class DetailPresenter implements DetailContract.Presenter {

  public static String TAG = DetailPresenter.class.getSimpleName();

  private WeakReference<DetailContract.View> view;
  private DetailViewModel viewModel;
  private DetailContract.Model model;
  private DetailContract.Router router;

  public DetailPresenter(DetailState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<DetailContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(DetailContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(DetailContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    MainToDetailState state = router.getDataFromMainScreen();
    if (state != null) {
      ContadorItem data = state.item;
      viewModel.contador = data.contador;
    }

    //recuperar estado
    DetailState detailState = router.getDataFromPreviousScreen();
    if(detailState != null){
      model.setContador(detailState.contador);
      model.setContadorDeClicks(detailState.contadorDeClicks);
      viewModel.contador = detailState.contador;
      viewModel.contadorDeClicks = detailState.contadorDeClicks;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  //Contar
  @Override
  public void onCountButtonPressed(){
    //call the model
    model.updateCount();
    int data = model.getContador();
    viewModel.contador = data;
    // update the view
    view.get().displayData(viewModel);
  }

  @Override
  public void updateClicks(){
    //call the model
    model.updateClicks();
    int data = model.getContadorDeClicks();
    viewModel.contadorDeClicks = data;
    // update the view
    view.get().displayData(viewModel);
  }

  @Override
  public void goToMainScreen(){
    DetailToMainActivityState state = new DetailToMainActivityState();
    state.item = new ContadorItem(1, model.getContador());
    state.contadorClicks = model.getContadorDeClicks();
    router.passDataToMainScreen(state);
    router.navigateToNextScreen();
  }

  @Override
  public void saveState(){
   DetailState detailState = new DetailState();
   MainToDetailState mainToDetailState = new MainToDetailState();
   mainToDetailState.item = new ContadorItem(1, model.getContador());
   detailState.contador = model.getContador();
   detailState.contadorDeClicks = model.getContadorDeClicks();
   router.passDataToNextScreen(detailState);
   router.passContadorToNextScreen(mainToDetailState);
  }


}
