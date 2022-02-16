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
					double matriz_suma [] [] = new double [filas_matriz] [columnas_matriz];
					hacerMatriz(matriz_suma, filas_matriz, columnas_matriz);
					Matriz matriz = new Matriz(matriz_suma);
					System.out.println("Matriz");
					System.out.println(matriz.toString()); 
					
					double operando_suma [] [] = new double [filas_matriz] [columnas_matriz]; 
					hacerOperando(operando_suma, filas_matriz, columnas_matriz);
					Matriz operando = new Matriz(operando_suma);
					System.out.println("Operando");
					System.out.println(operando.toString());
					
					Matriz resultado_suma;
					resultado_suma = matriz.sumarMatriz(operando);
					
					System.out.println("Resultado");
					System.out.println(resultado_suma.toString());
					
					
				break;
				
				case 2:
					menuMultiplicacion();
					opcion = pedirOpcion();
					//Multiplicacion de matrices
					if(opcion == 1) {
						//Pedir filas de la matriz
						filas_matriz = pedirFilasMatriz();
						//Pedir columnas de la matriz
						columnas_matriz = pedirColumnasMatriz();
						//Dar las dimensiones de la matriz
						double matriz_multiplicacion [] [] = new double [filas_matriz] [columnas_matriz];
						//Rellenar la matriz
						hacerMatriz(matriz_multiplicacion, filas_matriz, columnas_matriz);
						//Hacer que la matriz sea un objeto de tipo Matriz
						matriz = new Matriz(matriz_multiplicacion);
						
//						System.out.println("Matriz");
//						System.out.println(matriz.toString()); 
						
						//Pedir filas de la matriz operando
						int filas_operando = pedirFilasOperando();
						//Pedir columnas de la matriz operando
						int columnas_operando = pedirColumnasOperando();
						//Dar dimensiones a la matriz operando
						double operando_multiplicacion [] [] = new double [filas_operando] [columnas_operando]; 
						//Rellenar la matriz operando
						hacerOperando(operando_multiplicacion, filas_operando, columnas_operando);
						//Hacer que operando sea de un obajeto de tipo Matriz
						operando = new Matriz(operando_multiplicacion);
						
//						System.out.println("Operando");
//						System.out.println(operando.toString());
						
						//Utilizar el metodo multiplicarMatriz sobre un objeto de tipo Matriz
						Matriz resultado_multiplicacion;
						resultado_multiplicacion = matriz.multiplicarMatriz(operando);
						//Imprimir el resultado
						System.out.println("Resultado\n" + resultado_multiplicacion.toString());
					}
					//Multiplicacion con un numero
					else if(opcion == 2) {
						//Dar dimensiones a la matriz
						filas_matriz = pedirFilasMatriz();
						columnas_matriz = pedirColumnasMatriz();
						//Crear la matriz
						double matriz_multiplicacion [] [] = new double [filas_matriz] [columnas_matriz];
						hacerMatriz(matriz_multiplicacion, filas_matriz, columnas_matriz);
						matriz = new Matriz(matriz_multiplicacion);
						
//						System.out.println("Matriz");
//						System.out.println(matriz.toString());
						
						//Pedir el numero por el que vamosa multiplicar la matriz
						double escalar = pedirEscalar();
						//Utilizar el método multiplicarEscalar sobre un objeto de tipo Matriz pasando un numero como parámetro para la multiplicaión
						Matriz resultado_multiplicacion = matriz.multiplicarEscalar(escalar);
						//Imprimir el resultado
						System.out.println("Resultado\n" + resultado_multiplicacion.toString());
					}
					else {
						System.out.println("Opción no válida");
						break;
					}
				break;
				
				case 3:
					//Determinante de una matriz de tamaño nxn
					do {
						//Pedir las diemsiones de la matriz hasta que sean iguales, porque solo se puede hallar el determiante de matrices cuadradas
						filas_matriz = pedirFilasMatriz();
						columnas_matriz = pedirColumnasMatriz();
						if(filas_matriz != columnas_matriz) {
							System.out.println("Filas columnas han de tener el mismo valor.");
						}
					}
					while(filas_matriz != columnas_matriz);
					
					//Inicializar el array para crear la Matriz que vamos a determinar
					double matriz_determinante [] [] = new double [filas_matriz][columnas_matriz];
					hacerMatriz(matriz_determinante, filas_matriz, columnas_matriz);
					//Instanciar el objeto de tipo matriz con el que vamos a trabajar pasando como parámetro el array creado antes
					Matriz matrizDeterminante = new Matriz(matriz_determinante);
					//Almacenar el resultado del determinante
					double resultado = matrizDeterminante.Determinante();
					//Imprimir el resultado
					System.out.println("El determinante de la matriz es: " + resultado + "\n");
				break;
				
				case 4:
					
				break;
				
				case 5:
					//Pedir dimensiones de la matriz
					filas_matriz = pedirFilasMatriz();
					columnas_matriz = pedirColumnasMatriz();
					//Instanciar el array bidimensional que conformará la matriz
					double matriz_traspuesta [] [] = new double [filas_matriz] [columnas_matriz];
					//Rellenar el array bidimensional pasando como parámetros el array y sus dimensiones (para que sean usadas como contadores)
					hacerMatriz(matriz_traspuesta, filas_matriz, columnas_matriz);
					
					//Instancio la matriz con que va a ser traspuesta con el array creado antes
					Matriz matrizTraspuesta = new Matriz(matriz_traspuesta);
					//Creo una variable resultado para almacenar el la matriz traspuesta y llamo al método para trasponer la matriz
					Matriz resultado_traspuesta = matrizTraspuesta.Traspuesta();
					//Imprimir el resultado
					System.out.println("\nMatriz traspuesta\n" + resultado_traspuesta.toString());					
				break;
			}
		}
		


	}

	private static double pedirEscalar() {
		System.out.print("Escribe el numero por el que quieres multiplicar la matriz: ");
		double escalar = leerDouble();
		return escalar;
	}

	private static double[][] hacerOperando(double[][] operando_double, int filas_matriz, int columnas_matriz) {
		for(int i = 0; i < filas_matriz; i++) {
			for(int j = 0; j < columnas_matriz; j++) {
				System.out.print("Escsibre la posición [" + i + "]" + "["+ j + "]" + " del operando: ");
				double numero = leerDouble();
				operando_double [i] [j] = numero; 
			}
		}
		return operando_double;
	}

	private static double[][] hacerMatriz(double[][] matriz, int filas_matriz, int columnas_matriz) {
		for(int i = 0; i < filas_matriz; i++) {
			for(int j = 0; j < columnas_matriz; j++) {
				System.out.print("Escsibre la posición [" + i + "]" + "["+ j + "]" + " de la matriz: ");
				double numero = leerDouble();
				matriz [i] [j] = numero; 
			}
		}
		return matriz;
	}

	private static Double leerDouble() {
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}
	
	private static int pedirColumnasOperando() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introdude el numero de columnas del operando: ");
		return sc.nextInt();
	}

	private static int pedirFilasOperando() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Introdude el numero de filas del operando: ");
		return sc.nextInt();
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
							+ "1. Multiplicacion de matrices\n"
							+ "2. Multiplicacion con un numero");
		
	}

	private static int pedirOpcion() {
		System.out.print("Elige una opción: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextInt();
	}

	private static void mostrarMenu() {
		System.out.println("MIS MATRICES \n"
							+ "1. Sumar \n"
							+ "2. Multiplicar \n"
							+ "3. Determinante \n"
							+ "4. Invertir \n"
							+ "5. Traspuesta \n"
							+ "0. Salir");
	}
}
