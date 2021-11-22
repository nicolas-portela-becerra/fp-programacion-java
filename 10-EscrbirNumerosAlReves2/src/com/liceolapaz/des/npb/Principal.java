package com.liceolapaz.des.npb;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		//Hacer el programa con solo una variable
		//Pedir al usuario 10 numeros enteros
		//Asegurarse de que son solo positivos
		//Leer y guardar los 10 numeros
		//Mostrar los numeros en orden inverso
		int numero [] = new int [11];
		numero[10] = 0;
		for(numero[10] = 0; numero[10] <= (numero.length - 2); numero[10]++) {
			numero[numero[10]] = pedirNumeros();
			while(numero[numero[10]] < 0) {
				System.out.println("Introduce un numero entero y positivo");
				numero[numero[10]] = pedirNumeros();
			}		
		} 
		mostrarNumeros(numero);
		System.out.print("\nHasta la próxima");
	}

	private static void mostrarNumeros(int[] numero) {
		for(numero[10] = (numero.length-2) ; numero[10] >= 0; numero[10]--){
			System.out.print(numero[numero[10]] + " ");
		}
	}

	private static int pedirNumeros() {
		System.out.print("Introduce un número: ");
		return new Scanner (System.in).nextInt();	
	}
}
