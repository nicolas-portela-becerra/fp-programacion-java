package com.liceolapaz.des.npb;

public abstract class Moneda {
	
	//Cantidad de euros que vamos a convertir a las diferentes monedas
	protected double cantidad;
	
	//��M�todo que devuelve la cantidad tras la conversi�n??
	protected abstract double cantidadEnEuros();
}