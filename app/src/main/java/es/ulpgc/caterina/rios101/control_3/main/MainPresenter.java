package es.ulpgc.caterina.rios101.control_3.main;

import android.util.Log;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.caterina.rios101.control_3.app.ContadorItem;

public class MainPresenter implements MainContract.Presenter {

  public static String TAG = MainPresenter.class.getSimpleName();

  private WeakReference<MainContract.View> view;
  private MainViewModel viewModel;
  private MainContract.Model model;
  private MainContract.Router router;

  public MainPresenter(MainState state) {
    viewModel = state;
  }

  @Override
  public void injectView(WeakReference<MainContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(MainContract.Model model) {
    this.model = model;
  }

  @Override
  public void injectRouter(MainContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchData() {
    // Log.e(TAG, "fetchData()");

    // set passed state
    MainState state = router.getDataFromPreviousScreen();
    if (state != null) {
     //recuperar lista?
    }

    if (viewModel.contadorItemList == null) {
      // call the model
      List<ContadorItem> data = model.fetchData();

      viewModel.contadorItemList = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  //Aañadir un contador
  @Override
  public void onAddButtonPressed(){
    //call the model
    model.addContador(new ContadorItem(1, 0));
    //update the view
    List<ContadorItem> data = model.fetchData();
    viewModel.contadorItemList = data;
    view.get().displayData(viewModel);
    //update clicks
    //model.updateClicks();
    }

    //Ir al detalle
    @Override
  public void goToDetail(){
    router.navigateToNextScreen();
    }

}
