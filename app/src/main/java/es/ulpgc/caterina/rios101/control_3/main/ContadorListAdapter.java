package es.ulpgc.caterina.rios101.control_3.main;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.caterina.rios101.control_3.R;
import es.ulpgc.caterina.rios101.control_3.app.ContadorItem;

public class ContadorListAdapter extends ArrayAdapter<ContadorItem> {

  private final List<ContadorItem> contadorItemList;
  private final View.OnClickListener clickListener;

  public ContadorListAdapter(Context contex, List<ContadorItem> contadorItemList, View.OnClickListener clickListener){
    super(contex, 0, contadorItemList);
    this.contadorItemList = contadorItemList;
    this.clickListener = clickListener;
  }

  @Override
  public int getCount(){
    return contadorItemList.size();
  }

  @Override
  public ContadorItem getItem(int position){
    return contadorItemList.get(position);
  }

  @Override
  public long getItemId(int position){
    return getItem(position).id;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    View itemView = convertView;

    if (itemView == null) {
      itemView = LayoutInflater
              .from(parent.getContext())
              .inflate(R.layout.activity_main_list_content, parent, false);
    }

    itemView.setTag(contadorItemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView contentView = itemView.findViewById(R.id.contador_item);
    contentView.setText("" + contadorItemList.get(position).contador);

    return itemView;
  }

}
