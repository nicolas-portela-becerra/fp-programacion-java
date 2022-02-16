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
		double temp [] [] = new double [matriz.length][matriz[0].length];
		
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length; j++) {
				temp [i][j] = this.matriz[i][j] * escalar;
			}
		}
		resultado = new Matriz(temp);
		return resultado;
	}
	
	//Determinante
    public double Determinante() {
    	 
        double det = 0;
        double matriz [][] = this.matriz;
        if (matriz.length == 1) {
            return matriz[0][0];
 
        } else {
            for (int j = 0; j < matriz.length; j++) {
                det = det + matriz[0][j] * Cofactor(matriz, 0, j);
            }
        }
 
        return det;
    }
    
    //Subamtricez para el determinante
    public double Cofactor(double matriz[][], int fila, int columna) {
 
        double submatriz[][];
        int n = matriz.length - 1;
 
        submatriz = new double[n][n];
        int x = 0;
        int y = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i != fila && j != columna) {
                    submatriz[x][y] = matriz[i][j];
                    y++;
                    if (y >= n) {
                        x++;
                        y = 0;
                    }
                }
            }
        }
        Matriz matriz_submatriz = new Matriz(submatriz);
        return Math.pow(-1.0, fila + columna) * matriz_submatriz.Determinante();
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
	