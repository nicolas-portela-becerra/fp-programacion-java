package com.liceolapaz.des.npb;

import java.util.*;

public class Principal {

	public static void main(String[] args) {
		//Pedir dia
		//Pedir mes
		//Pedir año
		//Leer y almecenar valores
		System.out.print("Intoduce un dia: ");
		int dia = leer();
		System.out.print("Introduce un mes: ");
		int mes = leer();
		System.out.print("Introduce un año: ");
		int anho = leer();
		
		//Comprobar que el año != 0
		while(anho == 0) {
			System.out.println("El año no puede ser 0");
			System.out.print("Introduce un año válido: ");
			anho = leer();
		}
		//Comprobar si el año es bisiesto
		if ((anho % 4 == 0) && ((anho % 100 != 0) || (anho % 400 == 0))) {
			//Comprobar que febrero tiene 29 si el año es bisiesto
			while(mes == 2) {
				if(dia < 1 || dia > 29) {
					System.out.println("El día tiene que estar entre 1 y 29");
					System.out.print("Introduce otrto dia: ");
					dia = leer();
				}
				break;
			}
		}
		//Comprbar que el mes está entre 1 y 12
		while(mes < 1 || mes > 12) {
			System.out.println("El mes tiene que estar entre 1 y 12");
			System.out.print("Introduce otro  mes: ");
			mes = leer();
		}
		//Comprobar que meses tienen 30 o 31 dias
		while(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 12) {
			while(dia < 1 || dia > 31) {
				System.out.println("El día tiene que estar entre 1 y 31");
				System.out.print("Introduce otrto dia: ");
				dia = leer();
			}
			break;
		}
		while(mes == 4 || mes == 6 || mes == 9 || mes == 10 || mes == 11) {
			while(dia < 1 || dia > 30) {
				System.out.println("El día tiene que estar entre 1 y 30");
				System.out.print("Introduce otrto dia: ");
				dia = leer();
			}
			break;
		}
		//Comprobar que febrero tiene  28 o 29 si el año es bisiesto
		while(mes == 2) {
			if(dia < 1 || dia > 28) {
				System.out.println("El día tiene que estar entre 1 y 28");
				System.out.print("Introduce otrto dia: ");
				dia = leer();
			}
			break;
		}
		System.out.println("La fecha " + dia + "/" + mes + "/" + anho +" es correcta.");

	}

	private static int leer() {
		Scanner escaner = new Scanner (System.in);
		return escaner.nextInt();
	}

}
