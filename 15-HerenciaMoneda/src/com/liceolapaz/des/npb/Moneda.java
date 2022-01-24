package com.liceolapaz.des.npb;

public abstract class Moneda {
	
	//Cantidad de euros que vamos a convertir a las diferentes monedas
	protected double cantidad;
	
	//¿¿Método que devuelve la cantidad tras la conversión??
	protected abstract double cantidadEnEuros();
}