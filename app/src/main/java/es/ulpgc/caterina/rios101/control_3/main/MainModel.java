package es.ulpgc.caterina.rios101.control_3.main;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.caterina.rios101.control_3.app.ContadorItem;

public class MainModel implements MainContract.Model {

  public static String TAG = MainModel.class.getSimpleName();

  private final List<ContadorItem> contadorItemList = new ArrayList<>();


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
}
