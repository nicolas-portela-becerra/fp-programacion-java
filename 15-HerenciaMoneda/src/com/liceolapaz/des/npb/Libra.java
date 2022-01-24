package com.liceolapaz.des.npb;

public class Libra extends Moneda {
	//Definir valor de los Libras
	private final double TASA_LIBRAS = 1.20;
	
	public Libra(double cantidad) {
		super();
		this.cantidad = cantidad;
	}
	
	//¿¿Método que convierte los euros en la moneda nueva?? ¿¿O hay que hacer otro método??¿¿Hay que hacer un método para mostrar la conversion??
	@Override
	protected double cantidadEnEuros() {
		return this.cantidad * TASA_LIBRAS;
	}

}
