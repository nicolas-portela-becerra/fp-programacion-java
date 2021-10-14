package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//Pedir nombre al usuario
		pedirNombre();
		//Leer el nombre y almacenarlo
		String nombreUsr = leerNombre();
		//Escribir mensaje por pantalla
		escribirSaludo(nombreUsr);
	}

	private static void escribirSaludo(String nombre) {
		System.out.println("Hola " + nombre + "!");
		
	}

	private static String leerNombre() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextLine();
	}

	private static void pedirNombre() {
		System.out.print("Introduce tu nombre: ");
		//System.out.println(); no deja escribir en la misma linea
		//System.out.print(); deja escirbir en la misma linea
	}

}
