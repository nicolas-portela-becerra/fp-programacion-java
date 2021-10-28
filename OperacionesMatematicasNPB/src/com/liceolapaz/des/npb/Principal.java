package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		while(true) {
			mostrarMenu();
			int opcion = leerNumeros();
			switch (opcion) {
				case 1: 
					System.out.print("Introduce la base: ");
					int base = leerNumeros();
					System.out.print("Introduce el exponente: ");
					int exponente = leerNumeros();
					int resultado = calcularPotencia(base, exponente);
					mostrarResultado(resultado);
				break;
				
				case 2: 
					System.out.print("Introduce el numero: ");
					int num_raiz = leerNumeros();
					resultado = calcularRaiz(num_raiz);
					mostrarResultado(resultado);
				break;
				
				case 3: 
					System.exit(0);
				break;
				
				default: 
					System.out.println("No es una opción válida.");
				break;
			}
		}
	}

	private static int calcularRaiz(int num_raiz) {
		int raiz = (int) Math.sqrt(num_raiz);
		return raiz;
	}

	private static void mostrarResultado(int resultado) {
		System.out.println("El resultado de la operación es " + resultado);
		
	}

	private static int calcularPotencia(int base, int exponente) {
		int potencia = (int) Math.pow(base, exponente);
		return potencia;
	}

	private static int leerNumeros() {
		Scanner escaner = new Scanner (System.in);
		return escaner.nextInt();
	}

	private static void mostrarMenu() {
		System.out.println("POTENCIAS Y RAICES CUADRADAS \n \n"
				+ "1. Potencia \n \n"
				+ "2. Raiz cuadrada \n \n"
				+ "3. Salir \n");
		System.out.print("Elige una opción: ");
		
	}

}
