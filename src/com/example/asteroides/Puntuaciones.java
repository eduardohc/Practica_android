package com.example.asteroides;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class Puntuaciones extends ListActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.puntuaciones);
		
		/*
		 * Sentencia que trae los datos almacenados de la clase AlmacenPuntuacionesArray
		 * 
		 * setListAdapter(new ArrayAdapter<String> (this, android.R.layout.simple_list_item_1,
				MainActivity.almacen.listaPuntuaciones(10)));*/
		
		/*
		 * Personalizacion de listView para que cada elemento del Layout sea definido por nosotros
		 * 
		
		setListAdapter(
				new ArrayAdapter<String>(this, R.layout.elemento_lista, R.id.titulo,
						MainActivity.almacen.listaPuntuaciones(10)));*/
		
		setListAdapter(
				new MiAdaptador(this, MainActivity.almacen.listaPuntuaciones(10)));
		
		
		
	}
	
	//metodo que es invocado cada vez que se pulsa sobre un elemento de la lista
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		Object o = getListAdapter().getItem(position);
		Toast.makeText(this,  "Seleccion: " + Integer.toString(position) + " - " 
				+ o.toString(), Toast.LENGTH_LONG).show();
	}	
}
