package com.liceolapaz.des.npb;

public class Entero extends Numero {
	
	private int valor;

	public Entero(int valor) {
		super();
		this.valor = valor;
	}

	@Override
	protected Numero sumar(Numero operando) {
		if(operando instanceof Entero) {
			Entero op = (Entero)operando;
			Numero resultado = null;
			resultado = new Entero(this.valor + op.valor);
			return resultado;
		}
		else {
			System.out.println("El operando no es un numero entero");
		}
		return null;
	}

	@Override
	protected Numero restar(Numero operando) {
		if(operando instanceof Entero) {
			Entero op = (Entero)operando;
			Numero resultado = null;
			resultado = new Entero(this.valor - op.valor);
			return resultado;
		}
		else {
			System.out.println("El operando no es un numero entero");
		}
		return null;
	}

	@Override
	protected Numero multiplicar(Numero operando) {
		if(operando instanceof Entero) {
			Entero op = (Entero)operando;
			Numero resultado = null;
			resultado = new Entero(this.valor * op.valor);
			return resultado;
		}
		else {
			System.out.println("El operando no es un numero entero");
		}
		return null;
	}

	@Override
	protected Numero dividir(Numero operando) {
		if(operando instanceof Entero) {
			Entero op = (Entero)operando;
			Numero resultado = null;
			if(op.valor == 0) {
				System.out.println("Error, no se puede dividir entre 0");
				return null;
			}
			resultado = new Entero(this.valor / op.valor);
			return resultado;
		}
		else {
			System.out.println("El operando no es un numero entero");
		}
		return null;
	}

	@Override
	protected String mostrar() {
		String texto = "";
		texto += this.valor;
		return texto;
	}

}
