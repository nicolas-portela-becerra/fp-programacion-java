package com.liceolapaz.des.npb;

import java.util.Scanner;
import java.util.Arrays;

public class Principal {

	public static void main(String[] args) {
		
		while(true) {
			
			mostrarMenu();
			int opcion = pedirOpcion();
			
			switch(opcion) {
				case 0:
					System.exit(0);
				break;
				
				case 1:
					int filas_matriz = pedirFilasMatriz();
					int columnas_matriz = pedirColumnasMatriz();
					double matriz_double [] [] = new double [filas_matriz] [columnas_matriz];
					hacerMatriz(matriz_double, filas_matriz, columnas_matriz);
					Matriz matriz = new Matriz(matriz_double);
					System.out.println(matriz.toString()); 
					
					double operando_double [] [] = new double [filas_matriz] [columnas_matriz]; 
					hacerOperando(operando_double, filas_matriz, columnas_matriz);
					Matriz operando = new Matriz(operando_double); 
					System.out.println(operando.toString());
					
					matriz.sumarMatriz(operando_double);
					
					System.out.println(matriz.toString()); 
					
					
				break;
				
				case 2:
					menuMultiplicacion();
					opcion = pedirOpcion();
					if(opcion == 1) {
						//Multiplicacion de matrices
					}
					else if(opcion == 2) {
						//Multiplicacion con un numero
					}
					else {
						System.out.println("Opción no válida");
						break;
					}
				break;
				
				case 3:
					
				break;
				
				case 4:
					
				break;
				
				case 5:
					
				break;
			}
		}
		


	}

	private static double[][] hacerOperando(double[][] operando_double, int filas_matriz, int columnas_matriz) {
		for(int i = 0; i < filas_matriz; i++) {
			for(int j = 0; j < columnas_matriz; j++) {
				System.out.print("Escsibre la posición [" + i + "]" + "["+ j + "]" + " del operando: ");
				double numero = rellenarMatriz();
				operando_double [i] [j] = numero; 
			}
		}
		return operando_double;
	}

	private static double[][] hacerMatriz(double[][] matriz, int filas_matriz, int columnas_matriz) {
		for(int i = 0; i < filas_matriz; i++) {
			for(int j = 0; j < columnas_matriz; j++) {
				System.out.print("Escsibre la posición [" + i + "]" + "["+ j + "]" + " de la matriz: ");
				double numero = rellenarMatriz();
				matriz [i] [j] = numero; 
			}
		}
		return matriz;
	}

	private static Double rellenarMatriz() {
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}
	
	private static int pedirColumnasMatriz() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introdude el numero de columnas de la matriz: ");
		return sc.nextInt();
	}

	private static int pedirFilasMatriz() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introdude el numero de filas de la matriz: ");
		return sc.nextInt();
	}

	private static void menuMultiplicacion() {
		System.out.println("TIPOS DE MULTIPLICACION \n"
							+ "1. Multiplicacion de matrices"
							+ "2. Multiplicacion con un numero");
		
	}

	private static int pedirOpcion() {
		System.out.print("Elige una opción: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextInt();
	}

	private static void mostrarMenu() {
		System.out.println("\nMIS MATRICES \n"
							+ "1. Sumar \n"
							+ "2. Multiplicar \n"
							+ "3. Determinante \n"
							+ "4. Invertir \n"
							+ "5. Traspuesta \n"
							+ "0. Salir");
	}
}
