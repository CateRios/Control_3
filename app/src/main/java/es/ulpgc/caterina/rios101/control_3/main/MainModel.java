package es.ulpgc.caterina.rios101.control_3.main;

import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.caterina.rios101.control_3.app.ContadorItem;

public class MainModel implements MainContract.Model {

  public static String TAG = MainModel.class.getSimpleName();

  private final List<ContadorItem> contadorItemList = new ArrayList<>();
  private int contadorDeClicks = 0;


  public MainModel() {

  }

  @Override
  public List<ContadorItem> fetchData() {
    return contadorItemList;
  }

  //Añadir contador
  public void addContador(ContadorItem contadorItem){
    contadorItemList.add(contadorItem);
  }

  //Crear contador
  public ContadorItem createContador(int position){
    return new ContadorItem(position, 0);
  }

  //Actualizar clicks
  @Override
  public void updateClicks(){
    contadorDeClicks = contadorDeClicks +1;
  }

  @Override
  public void setContadorDeClicks(int contadorDeClicks){
    this.contadorDeClicks = contadorDeClicks;
  }

  @Override
  public int getContadorDeClicks(){
    return contadorDeClicks;
  }
}
