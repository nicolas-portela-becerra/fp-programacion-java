package com.liceolapaz.des.npb;

public class Yen extends Moneda {
	//Definir valor de los Yenes
	private final double TASA_YENES = 0.0077;
	
	public Yen(double cantidad) {
		super();
		this.cantidad = cantidad;
	}
	
	//��M�todo que convierte los euros en la moneda nueva?? ��O hay que hacer otro m�todo??��Hay que hacer un m�todo para mostrar la conversion??
	@Override
	protected double cantidadEnEuros() {
		return this.cantidad * TASA_YENES;
	}

}
