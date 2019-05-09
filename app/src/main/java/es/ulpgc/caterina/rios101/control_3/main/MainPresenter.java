package es.ulpgc.caterina.rios101.control_3.main;

import android.util.Log;

import java.lang.ref.WeakReference;

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
      viewModel.data = state.data;
    }

    if (viewModel.data == null) {
      // call the model
      String data = model.fetchData();

      // set initial state
      viewModel.data = data;
    }

    // update the view
    view.get().displayData(viewModel);

  }


}
