package com.liceolapaz.des.npb;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		//Hacer el programa con solo una variable
		//Pedir al usuario 10 numeros enteros
		//Asegurarse de que son solo positivos
		//Leer y guardar los 10 numeros
		//Mostrar los numeros en orden inverso
		int numero [] = new int [10];
		for(int i = 0; i < 10; i++) {
			numero[i] = pedirNumeros();
			while(numero[i] < 0) {
				System.out.println("Introduce un numero entero y positivo");
				numero[i] = pedirNumeros();
			}		
		} 
		mostrarNumeros(numero);
		System.out.print("\nHasta la próxima");
	}

	private static void mostrarNumeros(int[] numero) {
		Arrays.sort(numero);
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
