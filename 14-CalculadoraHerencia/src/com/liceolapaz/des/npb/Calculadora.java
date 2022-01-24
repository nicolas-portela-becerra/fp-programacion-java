package com.liceolapaz.des.npb;

import java.util.*;

public class Calculadora {

	public static void main(String[] args) {
		do {
			escribirMenu();
			pedirOpcion();
			int opcionMenu = leerEntero();
			if(opcionMenu == 0) {
				System.exit(0);
			}
			else if(opcionMenu >= 1 && opcionMenu <= 4) {
				escirbirSubmenu();
				pedirOpcion();
				int opcionSubmenu = leerEntero();
				Numero operando1 = null;
				Numero operando2 = null;
				Numero resultado = null;
				switch(opcionSubmenu) {
					case 1:
						pedirValor1();
						int valor1 = leerEntero();
						pedirValor2();
						int valor2 = leerEntero();
						operando1 = new Entero(valor1);
						operando2 = new Entero(valor2);
						resultado = realizarOperacion(opcionMenu, operando1, operando2);
						if(resultado == null) {
							System.out.println("Error");
						}
						else {
							System.out.println("EL resultado es " + resultado.mostrar());
						}
						
					break;
					
					case 2:
						pedirNumerador1();
						int numerador1 = leerEntero();
						pedirDenominador1();
						int denominador1 = leerEntero();
						pedirNumerador2();
						int numerador2 = leerEntero();
						pedirDenominador2();
						int denominador2 = leerEntero();
						operando1 = new Racional(numerador1, denominador1);
						operando2 = new Racional(numerador2, denominador2);
						resultado = realizarOperacion(opcionMenu, operando1, operando2);
						if(resultado == null) {
							System.out.println("Error");
						}
						else {
							System.out.println("EL resultado es " + resultado.mostrar());
						}
					break;
					
					case 3:
						pedirReal();
						int real1 = leerEntero();
						pedirImaginario();
						int imaginario1 = leerEntero();
						pedirReal();
						int real2 = leerEntero();
						pedirImaginario();
						int imaginario2 = leerEntero();
						operando1 = new Imaginarios(real1, imaginario1);
						operando2 = new Imaginarios(real2, imaginario2);
						resultado = realizarOperacion(opcionMenu, operando1, operando2);
						if(resultado == null) {
							System.out.println("Error");
						}
						else {
							System.out.println("EL resultado es " + resultado.mostrar());
						}
					break;
					
					
					default:
						System.out.println("Opción no válida");
					break;
				}
			}
			else {
				System.out.println("Opción no válida");
			}

		}while(true);

	}

	private static void pedirImaginario() {
		System.out.print("Introduce un número imaginario: ");
		
	}

	private static void pedirReal() {
		System.out.print("Introduce un número real: ");
		
	}

	private static void pedirDenominador2() {
		System.out.print("Escribe el denominador del segundo operando: ");		
	}

	private static void pedirNumerador2() {
		System.out.print("Escribe el numerador del segundo operando: ");		
	}

	private static void pedirDenominador1() {
		System.out.print("Escribe el denominador del primer operando: ");
		
	}

	private static void pedirNumerador1() {
		System.out.print("Escribe el numerador del primer operando: ");
		
	}

	private static Numero realizarOperacion(int opcionMenu, Numero operando1, Numero operando2) {
		switch(opcionMenu) {
			case 1:
				return operando1.sumar(operando2);
			
			case 2:
				return operando1.restar(operando2);
			
			case 3:
				return operando1.multiplicar(operando2);
			
			case 4:
				return operando1.dividir(operando2);
			default:
				return null;
		}
	}

	private static void pedirValor2() {
		System.out.print("Introdue el valor del segundo operando: ");
		
	}

	private static void pedirValor1() {
		System.out.print("Introduce el valor del primer operando: ");
		
	}

	private static void escirbirSubmenu() {
		System.out.println("Tipo de números:"
				+ "\n1.Enteros"
				+ "\n2.Racionales"
				+ "\n3.Complejos");
		
	}

	private static int leerEntero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Elija una opción: ");
		
	}

	private static void escribirMenu() {
		System.out.println("CALCULADORA \n"
				+ "1. Suma \n"
				+ "2. Resta \n"
				+ "3. Producto \n"
				+ "4. División \n"
				+ "0. Salir");
	}

}
