package com.liceolapaz.des.npb;


public class prueba {

	public static void main(String[] args) {
	
	}

	static void obtenerCofactor(double matriz [] [], double temp [] [], int p, int q, int n) {
		int i = 0, j = 0;
		
		for(int fila = 0; fila < n; fila++) {
			for(int columna = 0; columna < n; columna++) {
				if(fila != p && columna != q) {
					temp[i][j++] = matriz [fila][columna];
					if(j == n - 1) {
						j = 0;
						i++;
					}
				}
			}
		}
	}//Termina obtenerCofactor
	
	static double determinanteMatriz(double matriz [] [], int n) {
		int determinante = 0;
		if(n == 1) {
			return matriz [0][0];
		}
		double temp [][] = new double [n][n];
		int multiplicador = 1;
		for(int f = 0; f < n; f++) {
			obtenerCofactor(matriz, temp, 0, f, n);
			determinante += multiplicador * matriz[0][f] * determinanteMatriz(temp, n - 1);
			multiplicador = -multiplicador;
		}
		return determinante;
	}
}
