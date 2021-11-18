package com.liceolapaz.des.npb;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		//Pedir al usuario 10 numeros enteros
		//Asegurarse de que son solo positivos
		//Leer y guardar los 10 numeros
		//Mostrar los numeros en orden inverso
		int numero [] = new int [10];
		for(int i = 0; i < 10; i++) {
			numero[i] = pedirNumeros();
			if(numero[i] < 0) {
				System.out.println("Introduce un numero entero y positivo");
				numero[i] = pedirNumeros();
				continue;
			}		
		} 
		mostrarNumeros(numero);
		System.out.println("\nHasta la próxima");
	}

	private static void mostrarNumeros(int[] numero) {
		for(int i = numero.length-1; i >= 0; i--){
			System.out.print(numero[i] + " ");
		}
		
	}

	private static int pedirNumeros() {
		Scanner escaner =  new Scanner (System.in);
		System.out.print("Introduce un número: ");
		return escaner.nextInt();	
	}

}
