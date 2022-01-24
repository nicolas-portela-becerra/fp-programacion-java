package com.liceolapaz.des.npb;

public class Imaginarios extends Numero {
	private int numeroReal;
	private int numeroImaginario;
	
	
	public Imaginarios(int numeroReal, int numeroImaginario) {
		super();
		this.numeroReal = numeroReal;
		this.numeroImaginario = numeroImaginario;
	}

	@Override
	protected Numero sumar(Numero operando) {
		if(operando instanceof Imaginarios) {
			Imaginarios op = (Imaginarios)operando;
			Numero resultado = null;
			int parteReal = this.numeroReal + op.numeroReal;
			int parteImaginaria = this.numeroImaginario + op.numeroImaginario;
			resultado = new Imaginarios(parteReal, parteImaginaria);
			return resultado;
		}
		return null;
	}

	@Override
	protected Numero restar(Numero operando) {
		if(operando instanceof Imaginarios) {
			Imaginarios op = (Imaginarios)operando;
			Numero resultado = null;
			int parteReal = this.numeroReal - op.numeroReal;
			int parteImaginaria = this.numeroImaginario - op.numeroImaginario;
			resultado = new Imaginarios(parteReal, parteImaginaria);
			return resultado;
		}
		return null;
	}

	@Override
	protected Numero multiplicar(Numero operando) {
		if(operando instanceof Imaginarios) {
			Imaginarios op = (Imaginarios)operando;
			Numero resultado = null;
			int parteReal = this.numeroReal * op.numeroReal - this.numeroImaginario * op.numeroImaginario;
			int parteImaginaria = this.numeroReal * op.numeroReal + this.numeroImaginario * op.numeroImaginario;
			resultado = new Imaginarios(parteReal, parteImaginaria);
			return resultado;
		}
		return null;
	}

	@Override
	protected Numero dividir(Numero operando) {
		if(operando instanceof Imaginarios) {
			Imaginarios op = (Imaginarios)operando;
			Numero resultado = null;
			int parteReal = (this.numeroReal * op.numeroReal + this.numeroImaginario * op.numeroImaginario) / ((int)Math.pow(op.numeroReal, 2) + (int)Math.pow(op.numeroImaginario, 2));
			int parteImaginaria = (this.numeroImaginario * op.numeroReal - this.numeroReal * op.numeroImaginario) / ((int)Math.pow(op.numeroReal, 2) + (int)Math.pow(op.numeroImaginario, 2));
			resultado = new Imaginarios(parteReal, parteImaginaria);
			return resultado;
		}
		return null;
	}

	@Override
	protected String mostrar() {
		return this.numeroReal + " + " + this.numeroImaginario + "i";
	}

}
