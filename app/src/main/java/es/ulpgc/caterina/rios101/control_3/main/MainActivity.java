package es.ulpgc.caterina.rios101.control_3.main;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.caterina.rios101.control_3.R;

public class MainActivity
        extends AppCompatActivity implements MainContract.View {

  public static String TAG = MainActivity.class.getSimpleName();

  private MainContract.Presenter presenter;
  private ListView listView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //Show the title in the action bar
    /**
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setTitle("Master");
      actionBar.setDisplayHomeAsUpEnabled(true);
    }**/

    //ListView
    listView = findViewById(R.id.contador_list);

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
    //ListView
    listView.setAdapter(new ContadorListAdapter(this,
            viewModel.contadorItemList, new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        //Ir al detalle
      }
    }));
  }

  //Añadir un contador
  public void onAddButtonPressed(View view) {
    presenter.onAddButtonPressed();
  }
}
