package es.ulpgc.caterina.rios101.control_3.main;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class MainModel implements MainContract.Model {

  public static String TAG = MainModel.class.getSimpleName();

  public MainModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }
}
