package com.example.asteroides;

import com.example.asteroides.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener{

	Button about;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		inicializate();
		
		about.setOnClickListener(this);
		
	}
	
	public void inicializate(){
		about = (Button) findViewById(R.id.bAbout);
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		switch(v.getId()){
		case R.id.bJugar:
			
			break;
		case R.id.bConfig:
			
			break;
			
		case R.id.bAbout: 
			lanzarAcercaDe(v);
			break;
		case R.id.bSalir:
			
			break;
		}
	}
	
	public void lanzarAcercaDe(View view){
		Intent acercaDe = new Intent(this, AcercaDe.class);
		startActivity(acercaDe);
	}
}
