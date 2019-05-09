package es.ulpgc.caterina.rios101.control_3.main;

import java.lang.ref.WeakReference;

import android.support.v4.app.FragmentActivity;

import es.ulpgc.caterina.rios101.control_3.app.AppMediator;

public class MainScreen {

  public static void configure(MainContract.View view) {

    WeakReference<FragmentActivity> context =
            new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    MainState state = mediator.getMainState();

    MainContract.Router router = new MainRouter(mediator);
    MainContract.Presenter presenter = new MainPresenter(state);
    MainContract.Model model = new MainModel();
    presenter.injectModel(model);
    presenter.injectRouter(router);
    presenter.injectView(new WeakReference<>(view));

    view.injectPresenter(presenter);

  }
}
