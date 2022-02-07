package com.liceolapaz.des.npb;

import java.util.Arrays;

public class Matriz {

	private double matriz [] [];

	public Matriz(double [][] matriz) {
		super();
		this.matriz = matriz;
	}

	@Override
	public String toString() {
		String matriz_str = " ";
		
		for(int i = 0; i < this.matriz.length; i++) {
			matriz_str += "(";
			for(int j = 0; j < this.matriz[i].length; j++) {
				
				matriz_str += this.matriz[i][j] + " ";
			}
			matriz_str += ")";
		}
		return matriz_str;
	}

	public Matriz sumarMatriz(double operando [] []) {
		double resultado;
		double aux [] [] = new double [matriz.length] [matriz[0].length];
		
		for(int i = 0; i < this.matriz.length; i++) {
			for(int j = 0; j < this.matriz[i].length; j++) {
				resultado = this.matriz[i] [j] + operando [i] [j];
				aux [i] [j] = resultado;
				
			}
		}
		Matriz retorno = new Matriz(aux);
		
		return retorno;
	}

}	
	