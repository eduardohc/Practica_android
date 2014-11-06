package com.example.asteroides;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	public static AlmacenPuntuacionesArray almacen = new AlmacenPuntuacionesArray();
	Button about;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}
	
	public void lanzarAcercaDe(View view){
		Intent acercaDe = new Intent(this, AcercaDe.class);
		startActivity(acercaDe);
	}
	
	public void lanzarPreferencias(View view){
		Intent pref = new Intent(this, Preferencias.class);
		startActivity(pref);
	}
	
	public void lanzarPuntuaciones(View view){
		Intent pref = new Intent(this, Puntuaciones.class);
		startActivity(pref);
	}
	
	public void lanzarSalir(View view){
		Intent salir = new Intent(this, Salir.class);
		finish();
	}
	
	//metodos para crear el menu
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		super.onOptionsItemSelected(item);
		
		switch(item.getItemId()){
		case R.id.acerdaDe:
			lanzarAcercaDe(null); //se manda llamar la pestaña acercaDe
			break;
		case R.id.bConfig:
			lanzarPreferencias(null);
			break;
		//case R.id.bJugar:
			
		}
		
		
		return true; 
	} //termina metodos para crear menú
	
	public void mostrarPreferencias(View view){
		
		//crea un objeto sharedpreferences con los valores por defecto
		SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
		
		String s = "música " + pref.getBoolean("musica", true) +
				", gráficos: " + pref.getString("graficos", "?");
		Toast.makeText(this, s, Toast.LENGTH_SHORT).show(); //Visualia el resultado del string s
		
	}
	
}
