package com.liceolapaz.des.npb;

public class Matriz {

	private double matriz [] [];
	
	//Constructor de la clase
	public Matriz(double [][] matriz) {
		super();
		this.matriz = matriz;
	}

	//Mostrar la matriz
	public String toString() {
		String matriz_str = "";
		
		for(int i = 0; i < this.matriz.length; i++) {
			matriz_str += "( ";
			for(int j = 0; j < this.matriz[i].length; j++) {
				
				matriz_str += this.matriz[i][j] + " ";
			}
			matriz_str += ")\n";
		}
		return matriz_str;
	}
	
	//Sumar matriz con otra matriz
	public Matriz sumarMatriz(Matriz operando) {
		Matriz resultado;
		double help [] [] = new double [matriz.length][matriz[0].length];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				help [i][j] = this.matriz[i][j] + operando.getMatriz(i,j);
			}
		}
		resultado = new Matriz(help);
		return resultado;
	}
	
	//Multiplicar matriz con otra matriz
	public Matriz multiplicarMatriz(Matriz operando) {
		//El numero de columnas de la primera matriz(matriz[0].length) y el numero de columnas de la segunda matriz(operando.matriz.length)
		//Condición para poder realizar la multiplicacion
		if(matriz[0].length == operando.matriz.length) {
			Matriz resultado;
			//La matriz resultante de la multiplicacion tiene de dimensiones las filas de la primera matriz y las columnas de la segunda
			double matriz_multiplicada [] [] = new double [matriz.length][operando.matriz[0].length];					
			
			//Bucles para acceder a las posiciones necesarias para la multiplicacion
			for(int i = 0; i < matriz.length; i++) {
				for(int j = 0; j < operando.matriz[0].length; j++) {
					for(int k = 0; k < matriz[0].length; k++) {
						//Aqui es donde se hace la multiplicacion
						matriz_multiplicada [i][j] += matriz[i][k] * operando.getMatriz(k, j);
					}
				}
			}
			resultado = new Matriz(matriz_multiplicada);
			return resultado;
		}
		return null;
	}
	
	//Multiplicar matriz con un numero
	public Matriz multiplicarEscalar(double escalar) {
		Matriz resultado;
		double help [] [] = new double [matriz.length][matriz[0].length];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				help [i][j] = this.matriz[i][j] * escalar;
			}
		}
		resultado = new Matriz(help);
		
		
		return resultado;
	}
	
	//Hacer submatrices
	public Matriz SubMatriz(Matriz matriz) {
		
		
		return null;
	}
	
	//Hacer el determinante
	public double Determinante() {
		if(this.matriz.length == 1) {
			return this.matriz[0][0];
		}
		else if(this.matriz.length == 2) {
			return (this.matriz[0][0] * this.matriz[1][1]) - (this.matriz[0][1] * this.matriz[1][0]);
		}
		else if (this.matriz.length == 3) {
			double mitad1, mitad2, resultado;
			
			mitad1 = (this.matriz[0][0] * this.matriz[1][1] * this.matriz[2][2]) + (this.matriz[0][2] * this.matriz[1][0] * this.matriz[2][1]) + (this.matriz[0][1] * this.matriz[1][2] * this.matriz[2][0]);
			mitad2 = (this.matriz[0][2] * this.matriz[1][1] * this.matriz[2][0]) + (this.matriz[0][0] * this.matriz[1][2] * this.matriz[2][1]) + (this.matriz[0][1] * this.matriz[1][0] * this.matriz[2][2]);
			
			resultado = mitad1 - mitad2;
			return resultado;
		}
		
		return 0;
	}
	
	//Hacer la traspuesta
	public Matriz Traspuesta() {
		double traspuesta [] [] = new double [this.matriz[0].length] [this.matriz.length];
		
		for(int i = 0; i < this.matriz.length; i++) {
			for(int j = 0; j < this.matriz[0].length; j++) {
				traspuesta[j][i] = this.matriz[i][j];
			}
		}
		Matriz resultado = new Matriz(traspuesta);
		return resultado;
	}
	
	//Metodo GETTER para sacar las posiciones de la matriz operando
	public double getMatriz(int i, int j) {
		return matriz [i][j];
	}

//	public void setMatriz(double[][] matriz) {
//		this.matriz = matriz;
//	}

}	
	