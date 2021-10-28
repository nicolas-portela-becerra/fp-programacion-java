package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		while(true) {
			mostrarMenu();
			int opcion = Leer();
			switch (opcion) {
				case 0: 
					System.exit(0);
				break;
				
				case 1:
					System.out.print("Introduce el valor de la base: ");
					int base =  Leer();
					System.out.print("Introduce el valor de la hipotenusa: ");
					int hipotenusa = Leer();
					System.out.print("Introduce el valor del lado: ");
					int lado = Leer();
					int a = areaTriangulo(base, hipotenusa);
					int p = perimetroTriangulo(lado);
					System.out.print("El área es " + a + " y el perimetro es " + p);
				break;
				
				case 2:
					System.out.print("Introduce el valor de la altura: ");
					int altura = Leer();
					System.out.print("Introduce el valor del base: ");
					base = Leer();
					a = areaRectangulo(base, altura);
					p = perimetroRectangulo(base ,altura);
					System.out.print("El área es " + a + " y el perimetro es " + p);
				break;
				
				case 3:
					System.out.print("Introduce el valor del lado: ");
					lado = Leer();
					a = areaCuadrado(lado);
					p = perimetroCuadrado(lado);
					System.out.print("El área es " + a + " y el perimetro es " + p);
				break;
				
				case 4:
					System.out.print("Introduce el valor del apotema: ");
					int apotema = Leer();
					System.out.print("Introduce el valor del lado: ");
					lado = Leer();
					p = perimetroPentagono(lado);
					a = areaPentagono(apotema, p);
					System.out.println("El área es " + a + " y el perimetro es " + p);
				break;
				
				default: 
					System.out.println("No es una opción válida.");
				break;
			}
		}	
	}

	private static int Leer() {
		Scanner escaner = new Scanner (System.in);
		return escaner.nextInt();
	}

	private static void mostrarMenu() {
		System.out.println("\nFIGURAS GEOMÉTRICAS \n"
				+ "1. Triángulo \n"
				+ "2. Rectángulo \n"
				+ "3. Cuadrado \n"
				+ "4. Pentágono \n"
				+ "0. Salir");
		System.out.print("Elige una opcion: ");
	}

	private static int perimetroPentagono(int lado) {
		int p = lado * 5;
		return p;
	}

	private static int areaPentagono(int apotema, int p) {
		int a = (p * apotema)/2;
		return a;
	}

	private static int perimetroTriangulo(int lado) {
		int p = lado + lado + lado;
		return p;	
	}

	private static int areaTriangulo(int base, int hipotenusa) {
		int a = (base * hipotenusa)/2;
		return a;
	}

	private static int areaRectangulo(int base, int altura) {
		int a = base * altura;
		return a;
	}

	private static int perimetroRectangulo(int base, int altura) {
		int p = base * 2 + altura * 2;
		return p;
	}

	private static int areaCuadrado(int lado) {
		int p = lado * lado;
		return p;
	}

	private static int perimetroCuadrado(int lado) {
		int a = lado * 4;
		return a;
	}

}
