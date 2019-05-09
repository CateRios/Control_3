package es.ulpgc.caterina.rios101.control_3.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import es.ulpgc.caterina.rios101.control_3.R;

public class MainActivity
        extends AppCompatActivity implements MainContract.View {

  public static String TAG = MainActivity.class.getSimpleName();

  private MainContract.Presenter presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    // do the setup
    MainScreen.configure(this);
  }

  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchData();
  }

  @Override
  public void injectPresenter(MainContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayData(MainViewModel viewModel) {
    //Log.e(TAG, "displayData()");

    // deal with the data
    ((TextView) findViewById(R.id.data)).setText(viewModel.data);
  }
}
