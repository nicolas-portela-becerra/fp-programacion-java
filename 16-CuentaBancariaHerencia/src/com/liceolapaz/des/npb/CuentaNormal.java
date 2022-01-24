package com.liceolapaz.des.npb;

public class CuentaNormal extends CuentaBancaria {

	public CuentaNormal() {
		super();
	}

	@Override
	protected void ingresarDinero(double cantidad) {
		
		while(cantidad < 0) {
			System.out.println("La cantidad introducida no puede ser menor que 0.");
		}
		
		saldo += cantidad;
		
		System.out.println("El saldo de la cuenta es: " + saldo);
	}
	
	@Override
	protected void retirarDinero(double cantidad) {
		
		double aux = saldo;
		
		saldo -= cantidad;
		
		if(saldo < 0) {
			System.out.println("La cuenta normal no puede quedar en negativo");
			saldo = aux;
		}
		
		else {
			System.out.println("La cantidad restante en la cuenta es: " + saldo);
		}
	}

	@Override
	protected double consultarSaldo() {
		return saldo;
	}
}
