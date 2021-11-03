package com.liceolapaz.net.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		while (true) {
			//Mostrar menú
			mostrarMenu();
			//Elegir la opción
			int opcion = leerOpciones();
			switch(opcion) { 
				default: {
						System.out.println("No es una opción válida");
						break;
					}
				case 0: {
					System.exit(0);
					break;
				}
				case 1: {
					//Introducir los operandos
					double operando1 = leerOperando1();
					double operando2 = leerOperando2();
					double resultado = operando1 + operando2;
					//Mostrar el resultado de la operación
					System.out.println("El resultado de la suma es: " + resultado);
					break;
				}
				case 2: {
					//Introducir los operandos
					double operando1 = leerOperando1();
					double operando2 = leerOperando2();
					double resultado = operando1 - operando2;
					//Mostrar el resultado de la operación
					System.out.println("El resultado de la resta es: " + resultado);
					break;
				}
				case 3: {
					//Introducir los operandos
					double operando1 = leerOperando1();
					double operando2 = leerOperando2();
					double resultado = operando1 * operando2;
					//Mostrar el resultado de la operación
					System.out.println("El resultado del producto es: " + resultado);
					break;
				}
				case 4: {
					//Introducir los operandos
					double operando1 = leerOperando1();
					double operando2 = leerOperando2();
					double resultado = operando1 / operando2;
					//Mostrar el resultado de la operación
					System.out.println("El resultado de la división es: " + resultado);
					break;
				}
			}
		}
		}
		

	private static double leerOperando2() {
		System.out.print("Introduce el segundo operando: ");
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}
	
	private static double leerOperando1() {
		System.out.print("Introduce el primer operando: ");
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static int leerOpciones() {
		System.out.print("Elige una de las opciones: ");
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void mostrarMenu() {
		System.out.println("CALCULADORA \n"
				+ "1. Suma \n"
				+ "2. Resta \n"
				+ "3. Producto \n"
				+ "4. División \n"
				+ "0. Salir");		
	}

}
