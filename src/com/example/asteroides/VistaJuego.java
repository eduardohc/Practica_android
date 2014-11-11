package com.example.asteroides;

import java.util.Vector;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;

public class VistaJuego extends View{
	
	///// NAVE /////
	
	private Grafico nave;
	private int giroNave;
	private float aceleracionNave;
	// Incremento estandar de giro y aceleracion
	private static final int PASO_GIRO_NAVE = 5;
	private static final float PASO_ACELERACION_NAVE = 0.5f;
	
	///// Asteroides /////
	private Vector<Grafico> Asteroides; //Vector con los Asteroides
	private int numAsteroides = 5; //Numero inicial de Asteroides
	private int numFragmentos = 3; //Fragmentos en que se divide
	
	public VistaJuego(Context context, AttributeSet attrs) {
		super(context, attrs);
		Drawable drawableNave, drawableAsteroide, drawableMisil;
		drawableAsteroide = context.getResources().getDrawable(R.drawable.asteroide1);
		drawableNave = context.getResources().getDrawable(R.drawable.nave);
		
		nave = new Grafico(this, drawableNave);
		
		Asteroides = new Vector<Grafico>();
		
		for(int i = 0; i < numAsteroides; i++){
			Grafico asteroide = new Grafico(this, drawableAsteroide);
			asteroide.setIncY(Math.random() * 4 - 2);
			asteroide.setIncX(Math.random() * 4 - 2);
			asteroide.setAngulo((int)(Math.random() * 360));
			asteroide.setRotacion((int)(Math.random() * 8 - 4));
			Asteroides.add(asteroide);
		}
	}

	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		// TODO Auto-generated method stub
		super.onSizeChanged(w, h, oldw, oldh);
		
		nave.setPosX(w / 2);
		nave.setPosY(h / 2);
		
		//Una vez que comencemos nuestro ancho y alto
		for(Grafico asteroide : Asteroides){
			do{
				asteroide.setPosX(Math.random()*(w-asteroide.getAncho()));
			    asteroide.setPosY(Math.random()*(h-asteroide.getAlto()));
			} while(asteroide.distancia(nave) < (w+h)/5);
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		
		nave.dibujaGrafico(canvas);
		
		for (Grafico asteroide: Asteroides) {
            asteroide.dibujaGrafico(canvas);
        }
	}
	
}
