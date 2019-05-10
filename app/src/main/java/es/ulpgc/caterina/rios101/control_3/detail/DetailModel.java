package es.ulpgc.caterina.rios101.control_3.detail;

import android.util.Log;

import java.lang.ref.WeakReference;

import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.FragmentActivity;

public class DetailModel implements DetailContract.Model {

  public static String TAG = DetailModel.class.getSimpleName();

  private  int contador;
  private int contadorDeClicks;

  public DetailModel() {

  }

  @Override
  public String fetchData() {
    // Log.e(TAG, "fetchData()");
    return "Hello";
  }

  //Contar
  @Override
  public void updateCount(){
    contador = contador + 1;
  }

  //Actuzalizar los clicks
  @Override
  public void updateClicks(){
    contadorDeClicks = contadorDeClicks + 1;
  }

  public int getContador() {
    return contador;
  }

  public int getContadorDeClicks() {
    return contadorDeClicks;
  }

  @Override
  public void setContador(int contador) {
    this.contador = contador;
  }

  @Override
  public void setContadorDeClicks(int contadorDeClicks) {
    this.contadorDeClicks = contadorDeClicks;
  }

}
