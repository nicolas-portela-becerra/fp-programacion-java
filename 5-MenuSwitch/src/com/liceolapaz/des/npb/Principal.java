package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//Escribir menu
		escribirMenu();
		//Pedir opción
		pedirOpcion();
		//Leer opcipon y almacenarla
		int opcion = leerOpcion();
		//Escribir mensaje por pantalla
		escrbirMensaje(opcion);
		

	}

	private static void escrbirMensaje(int opcion) {
		//Crear varaible para almacenar el mensaje
		String mensaje = "";
		//Darle valor a la variable mensaje en función de la opción elegida
		switch (opcion) {
		case 0: {
			System.exit(0);
			break;
		}
		case 1: {
			mensaje = ("Opción 1 elegida");
			break;
		}
		case 2: {
			mensaje = ("Opción 2 elegida");
			break;
		}
		case 3: {
			mensaje = ("Opción 3 elegida");
			break;
		}
		default:
			mensaje = ("Opción no válida");
			break;
		}
		//Escribir menasje por pantalla
		System.out.println(mensaje);
	}

	private static int leerOpcion() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Escoja una opción: ");
		
	}

	private static void escribirMenu() {
		System.out.println("MEÚ PRICNIPAL\n"
				+ "1. Opción 1\n"
				+ "2. Opción 2\n"
				+ "3. Opción 3\n"
				+ "0. Salir");
		
	}

}
