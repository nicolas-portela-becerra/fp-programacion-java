package com.liceolapaz.des.npb;

public class Dolar extends Moneda {
	
	//Definir valor de los dolares
	private final double TASA_DOLARES = 0.88;
	
	public Dolar(double cantidad) {
		super();
		this.cantidad = cantidad;
	}
	
	//��M�todo que convierte los euros en la moneda nueva?? ��O hay que hacer otro m�todo??��Hay que hacer un m�todo para mostrar la conversion??
	@Override
	protected double cantidadEnEuros() {
		return this.cantidad * TASA_DOLARES;
	}

}

