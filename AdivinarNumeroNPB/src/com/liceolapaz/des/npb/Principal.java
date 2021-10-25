package com.liceolapaz.des.npb;

import java.util.Random;
import java.util.Scanner;

public class Principal {

public static void main(String[] args) {
	int i = 1;
	while (i != 0) {
	//Mostrar menú
	mostrarMenu();
	//Elegir opcion del menú
	int opcion = leer();
	switch (opcion) {
		default: {
			System.out.println("No es una opción válida");
			break;
		}
		case 0: {
			System.exit(0);
			break;
		}
		case 1: {
			int min = 1;
			int max = 10;
			int intentos = 3;
			int numero = 0;
			//Generar numero a buscar
			int numeroAleatorio = generarNumero(min, max);
			for (int j = 0; j < intentos; j++) {
				//Pedir numero al usuario
				obtenerNumero();
				//Leer numero
				numero = leer();
				//Comparar numero y decir si es mayor o menor
				if (numero < numeroAleatorio) {
					System.out.println("El numero que buscas es mayor");
				}
				else if (numero > numeroAleatorio) {
					System.out.println("El numero que buscas es menor");
				}
				else if(numero == numeroAleatorio) {
					System.out.println("Felicidades! Has acertado en " + (j+1) + " intento(s).\n");
					break;
				}
			}
			if (numero != numeroAleatorio) {
				System.out.println("No hay más intentos, el numero era " + numeroAleatorio + ".\n");
				break;
			}
			break;
		}
		
		case 2:{
			int min = 1;
			int max = 50;
			int intentos = 5;
			int numero = 0;
			//Generar numero a buscar
			int numeroAleatorio = generarNumero(min, max);
			for (int j = 0; j < intentos; j++) {
				//Pedir numero al usuario
				obtenerNumero();
				//Leer numero
				numero = leer();
				//Comparar numero y decir si es mayor o menor
				if (numero < numeroAleatorio) {
					System.out.println("El numero que buscas es mayor");
				}
				else if (numero > numeroAleatorio) {
					System.out.println("El numero que buscas es menor");
				}
				else if(numero == numeroAleatorio) {
					System.out.println("Felicidades! Has acertado en " + (j+1) + " intento(s).\n");
					break;
				}
			}
			if (numero != numeroAleatorio) {
				System.out.println("No hay más intentos, el numero era " + numeroAleatorio + ".\n");
				break;
			}
			break;
		}
	}
}
}

	private static int generarNumero(int min, int max) {
	    Random aleatorio = new Random();
	    return aleatorio.nextInt(max - min) + min;
	}

	private static void obtenerNumero() {
		System.out.print("Introduce un numero: ");
		
	}

	private static int leer() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void mostrarMenu() {
		System.out.println("ADIVINA EL NUMERO");
		System.out.println("1. Del 1 al 10 (3 intentos)\n"
						+ "2. Del 1 al 50 (5 intentos)\n"
						+ "0. Salir del programa");
		System.out.print("Elige una opción: ");
						
		
	}

}
