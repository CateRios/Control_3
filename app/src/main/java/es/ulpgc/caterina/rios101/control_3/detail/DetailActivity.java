package es.ulpgc.caterina.rios101.control_3.detail;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import es.ulpgc.caterina.rios101.control_3.R;

public class DetailActivity
        extends AppCompatActivity implements DetailContract.View {

  public static String TAG = DetailActivity.class.getSimpleName();

  private DetailContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_detail);

    // do the setup
    DetailScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void onPause(){
    super.onPause();
    presenter.saveState();
  }

  @Override
  public void injectPresenter(DetailContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(DetailViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.contador)).setText("" + viewModel.contador);
    ((TextView) findViewById(R.id.clicks)).setText("" + viewModel.contadorDeClicks);

  }

  //Contar
  public void onCountButtonPressed(View view) {
    presenter.onCountButtonPressed();
    presenter.updateClicks();
  }

  //Volver a Main
  @Override
  public void onBackPressed(){
    super.onBackPressed();
    presenter.goToMainScreen();
  }
}
