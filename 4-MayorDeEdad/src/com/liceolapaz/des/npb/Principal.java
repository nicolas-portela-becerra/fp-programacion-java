package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {
	private static final int ANHO_ACTUAL = 2021;
	
	public static void main(String[] args) {
		//Pedir a�o de nacimiento
		pedirAnho();
		//Leer a�o y almacenarlo
		int anho =leerAnho();
		//Escribir mensaje
		escribirMensaje(anho);
	}

	
	private static void escribirMensaje(int anho) {
		//Crear una variable para almacenar el mensaje
		String mensaje = "";
		//Cromprobar a�o y almacenar mensaje en la variable
		if (anho>ANHO_ACTUAL) {
			mensaje = "El a�o no puede ser mayor que 2021";
		}
		else if (ANHO_ACTUAL-anho >= 150) {
			mensaje = "No puedes tener tantos a�os";
		}
		else if (ANHO_ACTUAL-anho >= 18) {
			mensaje = "Puedes pasar";
		} else {
			mensaje = "No puedes pasar";
		}
		//Escribir mensaje por pantalla
		System.out.println(mensaje);
		
	}


	private static int leerAnho() {
		Scanner escaner = new Scanner(System.in);		
		return escaner.nextInt();
	}


	private static void pedirAnho() {
		System.out.print("Introduce tu fecha de nacimiento: ");	
	}

}
