package es.ulpgc.caterina.rios101.control_3.detail;

import java.lang.ref.WeakReference;

import es.ulpgc.caterina.rios101.control_3.app.DetailToMainActivityState;
import es.ulpgc.caterina.rios101.control_3.app.MainToDetailState;

interface DetailContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayData(DetailViewModel viewModel);
  }

  interface Presenter {
    void injectView(WeakReference<View> view);

    void injectModel(Model model);

    void injectRouter(Router router);

    void fetchData();

    void onCountButtonPressed();

    void updateClicks();

    void goToMainScreen();

    void saveState();
  }

  interface Model {
    String fetchData();

    void updateCount();

    void updateClicks();

    int getContador();

    int getContadorDeClicks();

    void setContador(int contador);

    void setContadorDeClicks(int contadorDeClicks);
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(DetailState state);

    DetailState getDataFromPreviousScreen();

    MainToDetailState getDataFromMainScreen();

    void passDataToMainScreen(DetailToMainActivityState state);

    void passContadorToNextScreen(MainToDetailState mainToDetailState);
  }
}

