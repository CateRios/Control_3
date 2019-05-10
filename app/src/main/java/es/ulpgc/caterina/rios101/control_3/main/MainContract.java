package es.ulpgc.caterina.rios101.control_3.main;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.caterina.rios101.control_3.app.ContadorItem;
import es.ulpgc.caterina.rios101.control_3.app.MainToDetailState;

interface MainContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(MainViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onAddButtonPressed();

    void goToDetail(ContadorItem item);

    void updateClicks();
  }

  interface Model {
    List<ContadorItem> fetchData();

    void addContador(ContadorItem item);

    void updateClicks();

    int getContadorDeClicks();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MainState state);

    MainState getDataFromPreviousScreen();

    void passDataToDetailScreen(MainToDetailState mainToDetailState);
  }
}
