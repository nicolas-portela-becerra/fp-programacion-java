package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Conversor {

	public static void main(String[] args) {
		do {
			mostarMenu();
			pedirOpcion();
			int opcion = leerEntero();
			
			double Euros;
			switch(opcion) {
				case 1: 
					pedirEuros();
					Euros = leerDinero();
					//Instaciamiento de un objeto de la clase Dolar para poder utilizar tanto la variable cantidad como el método cantidadEnEuros que hereda
					Dolar dolar = new Dolar(Euros);
					double valorEuros = dolar.cantidadEnEuros();
					mostrarConversion(valorEuros);
				break;
				
				case 2: 
					pedirEuros();
					Euros = leerDinero();
					//Instaciamiento de un objeto de la clase Libra para poder utilizar tanto la variable cantidad como el método cantidadEnEuros que hereda
					Libra libra = new Libra(Euros);
					valorEuros = libra.cantidadEnEuros();
					mostrarConversion(valorEuros);
				break;
				
				case 3: 
					pedirEuros();
					Euros = leerDinero();
					//Instaciamiento de un objeto de la clase Yen para poder utilizar tanto la variable cantidad como el método cantidadEnEuros que hereda
					Yen yen = new Yen(Euros);
					valorEuros = yen.cantidadEnEuros();
					mostrarConversion(valorEuros);
				break;
				
				case 0:
					System.exit(0);
				break;
				
				default:
					System.out.println("No es una opción válida");
				break;
			}

		}while(true);

	}


	private static void mostrarConversion(double valorEuros) {
		System.out.println("La cantidad en euros es: " + valorEuros + "€");
		
	}


	private static double leerDinero() {
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}

	private static void pedirEuros() {
		System.out.print("Introduce la cantidad de euros a convertir: ");
	}

	private static int leerEntero() {
		Scanner sc = new Scanner (System.in);
		return sc.nextInt();
	}

	private static void pedirOpcion() {
		System.out.print("Introduce una opción: ");
	}

	private static void mostarMenu() {
		System.out.println("CONVERSOR DE EUROS"
				+ "\n1.Convertir de dólares"
				+ "\n2.Convertir de Libras"
				+ "\n3.Convertir de Yenes"
				+ "\n0.Salir");
		
	}

}