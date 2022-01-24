package com.liceolapaz.des.npb;

public class CuentaPremium extends CuentaBancaria {
	
	public CuentaPremium() {
		super();
	}
	
	@Override
	protected void ingresarDinero(double cantidad) {
		while(cantidad < 0) {
			System.out.println("La cantidad introducida no puede ser menor que 0.");
		}
		
		saldo += cantidad;
	}

	@Override
	protected void retirarDinero(double cantidad) {
		saldo -= cantidad;
		
		System.out.println("El saldo de la cuenta es: " + saldo);

	}

	@Override
	protected double consultarSaldo() {
		return saldo;
	}
}
