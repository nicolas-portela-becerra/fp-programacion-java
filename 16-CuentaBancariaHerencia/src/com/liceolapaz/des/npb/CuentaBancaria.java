package com.liceolapaz.des.npb;

public abstract class CuentaBancaria {
	
	protected double saldo;

	protected abstract void ingresarDinero(double cantidad);
	protected abstract void retirarDinero(double cantidad);
	protected abstract double consultarSaldo();
}
