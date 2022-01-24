package com.liceolapaz.des.npb;

public class Libra extends Moneda {
	//Definir valor de los Libras
	private final double TASA_LIBRAS = 1.20;
	
	public Libra(double cantidad) {
		super();
		this.cantidad = cantidad;
	}
	
	//��M�todo que convierte los euros en la moneda nueva?? ��O hay que hacer otro m�todo??��Hay que hacer un m�todo para mostrar la conversion??
	@Override
	protected double cantidadEnEuros() {
		return this.cantidad * TASA_LIBRAS;
	}

}
