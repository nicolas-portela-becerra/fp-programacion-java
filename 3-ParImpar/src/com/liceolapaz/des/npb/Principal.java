package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//Pedir numero al usuario
		pedirNnumero();
		//Leer y guardar el numero
		int numero = leerNumero();
		//Escribir si es par o impar
		escribirRespuesta(numero);
	}

	private static void escribirRespuesta(int numero) {
		//Almacenar mensajes en variables
		String mensaje = (numero == 0) ? 
				"El numero no es par ni impar" : 
				(numero % 2 == 0) ? 
					"El número introducido es par" : 
						"El número introducido es impar";
		//Escribir por patantalla el mensaje
		System.out.println(mensaje);
	}
		

	private static int leerNumero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirNnumero() {
		System.out.print("Escribe un número entero: ");
	}

}
