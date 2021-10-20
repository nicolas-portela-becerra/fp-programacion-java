package com.liceolapaz.des.npb;

import java.util.Random;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		//Pedir al usuario el numero a buscar y 
		pedirNumeroBuscar();
		
		//Leemos ese numero y lo almacenamos
		int numeroBuscar = leerNumero();
		
		//Pedimos el numero maximo de intentos y 
		numeroMaximoIntentos();
		
		//Leemos el ese numero y lo almacenamos
		int maximoIntentos = leerNumero();
		
		//Almacenar numero de intentos
		int numeroIntentos = 0;
		
		while (numeroIntentos < maximoIntentos) {
			//Generar numero aleatorio
			int numeroAleatorio = generarNumeroAleatorio(1, 10);
			//Imprimir numero generado
			System.out.println("El numero generado fue " + numeroAleatorio);
			//Sumar 1 a los intentos
			numeroIntentos++;
			//Comprobar si el numero generado es igual al numero introducido
			comprobarNumero(numeroBuscar, numeroAleatorio, numeroIntentos, maximoIntentos);
			//Si encontramos el numero salir del bucle
			if (numeroAleatorio == numeroBuscar) {
				break;
			}
		}
	}


	private static void comprobarNumero(int numeroBuscar, int numeroAleatorio, int numeroIntentos, int maximoIntentos) {
		//Si es igual imprimir mensaje
		if (numeroBuscar == numeroAleatorio) {
			System.out.println("Numero encontrado en "+numeroIntentos+" intento(s).");
		}
		//Si no lo es y hay mas intentos, repetir
		else if (numeroIntentos < maximoIntentos){
			return;
		}
		
		//Si no hay mas intentos, escribir mensaje
		else {
			System.out.println("No se ha podido encontrar el numero en "+numeroIntentos+" intento(s).");
		}
		
	}


	private static int generarNumeroAleatorio(int min, int max) {
	    Random aleatorio = new Random();
	    return aleatorio.nextInt(max - min) + min;
	}

	private static void numeroMaximoIntentos() {
		System.out.print("Escribe el numero maximo de intentos: ");
		
	}

	private static int leerNumero() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

	private static void pedirNumeroBuscar() {
		System.out.print("Escribe número a buscar entre 1 y 10: ");
		
	}

}
