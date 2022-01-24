package com.liceolapaz.des.npb;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		while(true) {
			//Mostrar menú
			mostrarMenu();
			//Elegir opción
			int opcion = leer();
			//Opciones
			switch(opcion) {
				//Salir del programa
				case 0:
					System.out.println("Hasta otra.");
					System.exit(0);
					
				//Modo fácil
				case 1: 
					//Obtener número de la banca
					int banca = 0;
					int contador_banca = 0;
					while(banca < 15) {
						int aleatorio = generarNumeroAleatorio();
						banca = banca + aleatorio;
						contador_banca++;
					}
					System.out.println("La puntuació de la banca es: " + banca);
					
					//Obtener número del jugador
					System.out.println("Turno del jugador.");
					int jugador = 0;
					int contador_jugador = 0;
					while(jugador < 21){
						//Generar el número aleatorio
						int aleatorio = generarNumeroAleatorio();
						jugador = jugador + aleatorio;
						//Controlar que el jugador no se pasa de 21
						System.out.println("Puntuación: " + jugador);
						if(jugador > 21) {
							System.out.println("El jugador pierde.");
							break;
						}
						//Menú para seguir jugando
						eleccion();
						int eleccion = leer();
						switch(eleccion) {
							case 1: 
								contador_jugador++;
							continue;
							
							case 2:
								//Control de los resultados
								if(jugador < banca) {
									System.out.println("El jugador pierde.");
									break;
								}
								else if (jugador == banca) {
									if(contador_banca < contador_jugador) {
										System.out.println("El jugador pierde.");
										break;
									}
									else {
										System.out.println("La banca pierde.");
										break;
									}
								}
								else if (jugador == banca && contador_jugador == contador_banca) {
									System.out.println("La banca pierde.");
									break;
								}
								else {
									System.out.println("La banca pierde.");
									break;
								}
							
							default:
								System.out.println("Opción no válida, se continua jugando.");
							continue;
						}
					}
					
					break;
				//Modo normal
				case 2:
					banca = 0;
					contador_banca = 0;
					while(banca < 15) {
						int aleatorio = generarNumeroAleatorio();
						banca = banca + aleatorio;
						contador_banca++;
					}
					System.out.println("La banca tiene su puntuación.");
					
					System.out.println("Turno del jugador.");
					jugador = 0;
					contador_jugador = 0;
					do {
						int aleatorio = generarNumeroAleatorio();
						jugador = jugador + aleatorio;
						System.out.println("Puntuación: " + jugador);
						//Controlar que el jugador no se pasa de 21
						if(jugador > 21) {
							System.out.println("El jugador pierde.");
							break;
						}
						eleccion();
						int eleccion = leer();
						switch(eleccion) {
							case 1: 
								contador_jugador++;
							continue;
							
							case 2: 
								if(jugador < banca) {
									System.out.println("El jugador pierde.");
									break;
								}
								else if (jugador == banca) {
									if(contador_banca < contador_jugador) {
										System.out.println("El jugador pierde.");
										break;
									}
									else {
										System.out.println("La banca pierde.");
										break;
									}
								}
								else if (jugador == banca && contador_jugador == contador_banca) {
									System.out.println("La banca pierde.");
									break;
								}
								else {
									System.out.println("La banca pierde.");
									break;
								}
							
							default:
								System.out.println("Opción no válida, se continua jugando.");
							continue;
						}
					}
					while(jugador < 21);
				break;
					
				default: 
					System.out.println("No es una opción válida");
				break;
			}
		}
	}
	
	private static void eleccion() {
		System.out.println("¿Seguir jugando? \n"
				+ "1. Sí \n"
				+ "2. No");
		
	}

	private static int generarNumeroAleatorio() {
	    Random aleatorio = new Random();
	    return aleatorio.nextInt(11 - 1) + 1;
	}

	private static int leer() {
		System.out.print("Escoja una opción: ");
		Scanner s = new Scanner (System.in);
		return s.nextInt();
	}

	private static void mostrarMenu() {
		System.out.println("BLACKJACK \n"
				+ "1. Modo fácil \n"
				+ "2. Modo normal \n"
				+ "0. Salir");
	}

}
