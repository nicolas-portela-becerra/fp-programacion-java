package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		final double dolar = 0.86;
		final double libra = 1.19;
		final double yen = 0.0075;
		int i = 1;
		while (i != 0) {
			mostrarMenu();
			int opcion = leerOpcion();
			int cantidad = 0;
			switch (opcion) {
				default: {
					System.out.println("No es una opción válida.");
					break;
				}
				case 1: {
					cantidad = leerCantidad();
					double cambio = dolar * cantidad;
					System.out.println("La cantidad en euros es " + cambio);
					break;
				}
				case 2: {
					cantidad = leerCantidad();
					double cambio = libra * cantidad;
					System.out.println("La cantidad en euros es " + cambio);
					break;
				}
				case 3: {
					cantidad = leerCantidad();
					double cambio = yen * cantidad;
					System.out.println("La cantidad en euros es " + cambio);
					break;
				}
				case 0: {
					System.exit(0);
				}
			}
		}
	}

	private static int leerCantidad() {
		System.out.print("Introduce la cantidad a convertir: ");
		Scanner escaner = new Scanner (System.in);
		return escaner.nextInt();
	}

	private static int leerOpcion() {
		System.out.print("Elige una opción: ");
		Scanner escaner = new Scanner (System.in);
		return escaner.nextInt();
	}

	private static void mostrarMenu() {
		System.out.println("CONVERSOR DE MONEDAS \n"
				+ "1. Dólares \n"
				+ "2. Libras \n"
				+ "3. Yens \n"
				+ "0. Salir");		
	}

}
