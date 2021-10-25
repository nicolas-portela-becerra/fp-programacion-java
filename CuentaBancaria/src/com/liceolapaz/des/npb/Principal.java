package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String cuenta = null;
		String tipoCuenta = null;
		//Mostrar menú principal
		menuPrincipal();
		int opcion = elegirOpcion();
		switch(opcion) {
			default: {
				System.out.println("No es una opción válida.");
			}
			case 1: {
				menuSecundario();
				opcion = elegirOpcion();
				switch(opcion) {
					default: {
						System.out.println("No es una opción válida.");
					}
					case 1: {
						System.out.print("Introduce el nombre de la cuenta: ");
						cuenta = leerNombre();
						tipoCuenta = "normal";
					}
					case 2: {
						System.out.print("Introduce el nombre de la cuenta: ");
						cuenta = leerNombre();
						tipoCuenta = "premium";
					}
					case 0: {
						System.exit(0);
					}
					
				}
				
			}
		}
		//Opcion 1
			//Mostrar submenú
			//Pedir saldo inicial de la cuenta
			//Cuenta normal permite tener saldo negativo, la premiun si
		//Opcion 2 y 3
			//Pedir cantidad para ingresar o retirar y comprobar que no es una cantidad negativa
		//Si no hay una cuenta activa hay que mandar a hacer una y no dejar ingresar o retirar dinero
		//Al terminar de ingrsar o retirar dinero se mostrará el saldo
		//Opcion 4
			//Mostrará el saldo de la cuenta
			//Si no hay una cuenta activa mandará a crear una
	}

	private static String leerNombre() {
		Scanner escaner =  new Scanner(System.in);
		return escaner.nextLine();
	}

	private static int elegirOpcion() {
		System.out.print("Elige una opción: ");
		Scanner escaner = new Scanner (System.in);
		return escaner.nextInt();
		
	}

	private static void menuSecundario() {
		System.out.println("Tipo de cuenta"
				+ "1. Cuenta normal"
				+ "2. Cuenta Premiun"
				+ "0. Cancelar");
	}

	private static void menuPrincipal() {
		System.out.println("BANCO"
				+ "1. Crear cuenta"
				+ "2. Ingresar dinero"
				+ "3. Retirar dinero"
				+ "4. Consultar saldo"
				+ "0. Salir");
		
	}

}
