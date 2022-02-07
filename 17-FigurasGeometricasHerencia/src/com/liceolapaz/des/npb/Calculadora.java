package com.liceolapaz.des.npb;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {
		while(true) {
			mostrarMenu();
			int opcion = pedirOpcion();

			switch(opcion) {
				default:
					System.out.println("No es una opcion válida");
				break;
				
				case 0:
					System.exit(0);
				break;
				
				case 1:
					double lado1 = pedirLado1();
					double lado2 = pedirLado2();
					double lado_base = pedirBase();
					double altura = pedirAltura();
					Triangulo triangulo = new Triangulo(lado1, lado2, lado_base, altura);
					System.out.println("El area es: " + triangulo.CalcularArea() + "cm"); 
					System.out.println("EL perimetro es: " + triangulo.CalcularPerimetro() + "cm");
				break;
				
				case 2:
					lado1 = pedirLado1();
					lado_base = pedirBase();
					Rectangulo rectangulo = new Rectangulo(lado1, lado_base);
					System.out.println("El area es: " + rectangulo.CalcularArea() + "cm"); 
					System.out.println("EL perimetro es: " + rectangulo.CalcularPerimetro() + "cm");
				break;
				case 3:
					lado1 = pedirLado1();
					Cuadrado cuadrado = new Cuadrado(lado1, lado1 , 0);
					System.out.println("El area es: " + cuadrado.CalcularArea() + "cm"); 
					System.out.println("EL perimetro es: " + cuadrado.CalcularPerimetro() + "cm");
				break;
				
				case 4:
					lado1 = pedirLado1();
					double apotema = pedirApotema();
					Pentagono pentagono = new Pentagono(lado1, apotema);
					System.out.println("El area es: " + pentagono.CalcularArea() + "cm"); 
					System.out.println("EL perimetro es: " + pentagono.CalcularPerimetro() + "cm");
				break;
			}
		}
	}
	
	private static double pedirApotema() {
		System.out.print("Introduce el apotema: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}

	private static double pedirAltura() {
		System.out.print("Introduce la altura: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}

	private static double pedirBase() {
		System.out.print("Introduce la base: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}

	private static double pedirLado2() {
		System.out.print("Introduce el lado 2: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}

	private static double pedirLado1() {
		System.out.print("Introduce el lado 1: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextDouble();
	}

	private static int pedirOpcion() {
		System.out.print("Elige una opción: ");
		Scanner sc = new Scanner (System.in);
		return sc.nextInt();
	}

	private static void mostrarMenu() {
		
		System.out.println("FIGURAS GEOMÉTRICAS \n"
				+ "1. Triángulo \n"
				+ "2. Rectángulo \n"
				+ "3. Cuadrado \n"
				+ "4. Pentágono \n"
				+ "0. Salir");
	}

}
