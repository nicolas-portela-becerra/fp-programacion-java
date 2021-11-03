package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Integer cuenta = null;
		String tipo_cuenta = null;
		while (true) {
			//Mostrar menú principal
			menuPrincipal();
			int opcion = elegirOpcion();
			switch(opcion) {
				case 0: {
					System.exit(0);
				}
				//Opcion 1
				//Mostrar submenú
				case 1:
					menuSecundario();
					int opcion2 = elegirOpcion();
					switch(opcion2) {
						default: 
							System.out.println("No es una opción válida.");
						break;
						//Pedir saldo inicial de la cuenta
						//Cuenta normal permite tener saldo negativo, la premiun si
						case 1: 	
							cuenta = leerSaldo();
							tipo_cuenta = "normal";
						break;
			
						case 2: 
							cuenta = leerSaldo();
							tipo_cuenta = "premium";
						break;
						
						case 0:
							
						break;
					}
				break;

				//Opcion 2
				//Pedir cantidad para ingresar y comprobar que no es una cantidad negativa
				case 2:
					//Si no hay una cuenta activa hay que mandar a hacer una y no dejar ingresar dinero
					if (cuenta == null) {
						System.out.println("No hay una cuenta activa.");
						break;
					}
					else {
						int ingreso = 0;
						while (ingreso < 0) {
							if (ingreso < 0) {
								System.out.println("La cantidad no puede ser negativa.");
								ingreso = leerCantidad();
								continue;
							}
							else {
								ingreso = leerCantidad();
							}
						}
						cuenta = cuenta + ingreso;
						System.out.println("El saldo de la cuenta es: " + cuenta);
					}
				break;
			
				//Opcion 3
				//Pedir cantidad para retirar y comprobar que no es una cantidad negativa
				case 3: 
					if (cuenta == null) {
						System.out.println("No hay una cuenta activa.");
						break;
					}
					else {
						if (tipo_cuenta == "premium") {
							int retirada = leerCantidad();
							if (retirada < 0) {
								System.out.println("La cantidad no puede ser negativa.");
								retirada = leerCantidad();
							}
							else {
								cuenta = cuenta - retirada;
								System.out.println("El saldo de la cuenta es: " + cuenta);
							}
						}
						else if (tipo_cuenta == "normal") {
							int cuenta_inicial = cuenta;
							do {
								int retirada = leerCantidad();
								if (retirada < 0) {
									System.out.println("La cantidad no puede ser negativa.");
									retirada = 0;
									cuenta = cuenta_inicial;
									continue;
								}
								else {
									cuenta = cuenta - retirada;
									if (cuenta < 0) {
										System.out.println("El saldo no puede ser negativo");
										retirada = 0;
										cuenta = cuenta_inicial;
										continue;
									}
									//Al terminar de ingrsar o retirar dinero se mostrará el saldo
									else {
										System.out.println("El saldo de la cuenta es: " + cuenta);
										break;
									}
								}
							}
							while(true);
						}
					}
				break;
				
				case 4:
					//Opcion 4
					//Si no hay una cuenta activa mandará a crear una
					if (cuenta == null) {
						System.out.println("No hay una cuenta activa, crea una");
						break;
					}
				//Mostrará el saldo de la cuenta
				else {
					System.out.println("EL saldo de la cuenta es: " + cuenta);
				}
			
				default: 
					System.out.println("No es una opción válida.");
				break;
			}	
		}
	}

	private static int leerCantidad() {
		System.out.print("Escribe la cantidad: ");
		Scanner escaner =  new Scanner(System.in);
		return escaner.nextInt();
	}

	private static int leerSaldo() {
		System.out.print("Introduce el saldo inicial: ");
		Scanner escaner =  new Scanner(System.in);
		return escaner.nextInt();
	}

	private static int elegirOpcion() {
		System.out.print("Elige una opción: ");
		Scanner escaner = new Scanner (System.in);
		return escaner.nextInt();
		
	}

	private static void menuSecundario() {
		System.out.println("Tipo de cuenta \n"
				+ "1. Cuenta normal \n"
				+ "2. Cuenta Premiun \n"
				+ "0. Cancelar");
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
