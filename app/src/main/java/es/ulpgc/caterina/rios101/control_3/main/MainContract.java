package es.ulpgc.caterina.rios101.control_3.main;

import java.lang.ref.WeakReference;

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
  }

  interface Model {
    String fetchData();
  }

  interface Router {
    void navigateToNextScreen();

    void passDataToNextScreen(MainState state);

    MainState getDataFromPreviousScreen();
  }
}