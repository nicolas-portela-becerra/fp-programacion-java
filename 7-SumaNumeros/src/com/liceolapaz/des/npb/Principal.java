package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//Pedir numeros al usuario
		pedirNumero();
		//Crear variable para almacenar los numeros
		int [] numeros = new int [10];
		//Leer numeros
		int contador = 0;
		do {
			numeros[contador] = leerNumero();
			contador++;
		}while(contador < 10);
		//Calcular suma y almacenarla
		int sumaTotal = calcularSuma(numeros);
		//Escribir el resultado
		escribirResultado(sumaTotal);
	}

	private static void escribirResultado(int sumaTotal) {
		System.out.println("La suma de los numeros es " + sumaTotal);
		
	}

	private static int calcularSuma(int[] numeros) {
		int total = 0;
		for (int i = 0; i < numeros.length; i++) {
			total += numeros[i]; //total = total + numeros[i];
		}
		return total;
	}

	private static int leerNumero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirNumero() {
		System.out.println("Introduce 10 numeros enteros:");		
	}

}
