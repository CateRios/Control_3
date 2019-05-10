package es.ulpgc.caterina.rios101.control_3.main;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.caterina.rios101.control_3.app.ContadorItem;
import es.ulpgc.caterina.rios101.control_3.app.DetailToMainActivityState;
import es.ulpgc.caterina.rios101.control_3.app.MainToDetailState;

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

    //Recuperar estado de Detail
    DetailToMainActivityState detailToMainActivityState = router.getDataFromDetailScreen();
    if(detailToMainActivityState != null){
      ContadorItem item = detailToMainActivityState.item;
      model.setContadorDeClicks(detailToMainActivityState.contadorClicks);
    }

    if (viewModel.contadorItemList == null) {
      // call the model
      List<ContadorItem> data = model.fetchData();

      viewModel.contadorItemList = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }

  //Añadir un contador
  @Override
  public void onAddButtonPressed(){
    //call the model
    model.addContador(new ContadorItem(1, 0));
    //update the view
    List<ContadorItem> data = model.fetchData();
    viewModel.contadorItemList = data;
    view.get().displayData(viewModel);
    }

    //Actualizar número de clicks
  @Override
    public void updateClicks(){
      model.updateClicks();
    }

    //Ir al detalle
    @Override
  public void goToDetail(ContadorItem item){
      MainToDetailState mainToDetailState = new MainToDetailState();
      mainToDetailState.item = item;
      mainToDetailState.contadorClicks = model.getContadorDeClicks();
    router.passDataToDetailScreen(mainToDetailState);
    router.navigateToNextScreen();
    }

}
