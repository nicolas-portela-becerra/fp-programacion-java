package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Cajero {

	public static void main(String[] args) {
		
		CuentaBancaria cuenta = null;
		
		while (true) {
			
			menuPrincipal();
			int opcion = elegirOpcion();
			switch(opcion) {
			
				case 0: 
					System.exit(0);
				break;
				
				case 1:
					menuSecundario();
					int opcion2 = elegirOpcion();
					switch(opcion2) {
						default: 
							System.out.println("No es una opción válida.");
						break;

						case 1:
							cuenta = new CuentaNormal();
							System.out.print("Introduce la cantidad inicial de la cuenta: ");
							double cantidad = leerDinero();
							cuenta.ingresarDinero(cantidad);
						break;
			
						case 2: 
							cuenta = new CuentaPremium();
							System.out.print("Introduce la cantidad inicial de la cuenta: ");
							cantidad = leerDinero();
							cuenta.ingresarDinero(cantidad);
						break;
						
						case 0:
						break;
					}
					
				break;

				case 2:
					if(cuenta == null) {
						System.out.println("No hay una cuenta creada.");
						break;
					}
					else {
						double cantidad = ingresarDinero();
						cuenta.ingresarDinero(cantidad);
					}
				break;

				case 3: 
					if(cuenta == null) {
						System.out.println("No hay una cuenta creada.");
						break;
					}
					else {
						double cantidad = retirarDinero();
						cuenta.retirarDinero(cantidad);
					}
				break;
				
				case 4:
					if(cuenta == null) {
						System.out.println("No hay una cuenta creada.");
						break;
					}
					else {
						System.out.println("El saldo de la cuenta es: " + cuenta.consultarSaldo());
					}
				break;
			
				default: 
					System.out.println("No es una opción válida.");
				break;
			}	
		}
	}
	
	private static double retirarDinero() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Intoduce la cantidad a retirar: ");
		return sc.nextDouble();
	}

	private static double ingresarDinero() {
		Scanner sc = new Scanner (System.in);
		System.out.print("Intoduce la cantidad a ingresar: ");
		return sc.nextDouble();
	}

	private static double leerDinero() {
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}

	private static void menuSecundario() {
		System.out.println("Tipo de cuenta \n"
				+ "1. Cuenta normal \n"
				+ "2. Cuenta Premiun \n"
				+ "0. Cancelar");
	}
	
	private static int elegirOpcion() {
		System.out.print("Elige una opción: ");
		Scanner escaner = new Scanner (System.in);
		return escaner.nextInt();
	}
	
	private static void menuPrincipal() {
		System.out.println("BANCO \n"
				+ "1. Crear cuenta \n"
				+ "2. Ingresar dinero \n"
				+ "3. Retirar dinero \n"
				+ "4. Consultar saldo \n"
				+ "0. Salir");	
	}
}
