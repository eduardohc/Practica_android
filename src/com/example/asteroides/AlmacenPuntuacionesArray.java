package com.example.asteroides;

import java.util.Vector;

public class AlmacenPuntuacionesArray implements AlmacenPuntuaciones{
	
	private Vector<String> puntuaciones;
	
	public AlmacenPuntuacionesArray() {
		// TODO Auto-generated constructor stub
		puntuaciones = new Vector<String>(); //crea el objeto vector con valores string
		puntuaciones.add("12300 Eduardo Hernandez");
		puntuaciones.add("7753 Marco Mejia");
		puntuaciones.add("3400 Mildred Alpirez");
	}

	@Override
	public void guardarPuntuaciones(int puntos, String nombre, long fecha) {
		// 
		puntuaciones.add(0, puntos + " " + nombre);
	}

	@Override
	public Vector<String> listaPuntuaciones(int cantidad) {
		// TODO Auto-generated method stub
		return puntuaciones;
	}
	
}
