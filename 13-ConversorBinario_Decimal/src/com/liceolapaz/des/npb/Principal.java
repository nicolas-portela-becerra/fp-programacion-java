package com.liceolapaz.des.npb;
import java.util.*;
import java.util.regex.Pattern;

public class Principal {

	public static void main(String[] args) {
		//Conversor de Binario a decimal y decimal a binario
		//Mostrar menú para elegir Binario -> Decimal o Decmial -> Binario
		//Pedir numero y almancenarlo
		//Hacer la conversión que haya elegido el usuario
		while(true) {
			System.out.println("Conversor de números\n"
					+ "1. Convertir de binario a decimal\n"
					+ "2. Convertir de decimal a binario\n"
					+ "0. Salir del programa");
			System.out.print("Elige una opción: ");
			int opcion = leer();
			switch(opcion) {
				case 0:
					System.out.println("Adiós.");
					System.exit(0);
					
				case 1: 
					System.out.print("Introduce un número en binario: ");
					int numeroBinario = leer();
					
					while(numeroBinario < 0) {
						System.out.println("El número no puede ser menor que 0.");
						System.out.print("Introduce otro número: ");
						numeroBinario = leer();
					}
					String numeroTexto = "" + numeroBinario;
					// Comprobar que el número solo contiene 1 y 0
					while (!numeroTexto.trim().matches("[01]+")) {
						System.out.println("El número introducido no es binario");
					}
					int resultadoDecimal = binarioADecimal(numeroTexto);
					System.out.println("El resultado de la conversión es " + resultadoDecimal);
					
					break;
					
				case 2:
					System.out.print("Introduce un número en decimal: ");
					 int numeroDecimal = leer();
					 
					while(numeroDecimal < 0) {
						System.out.println("El número no puede ser menor que 0");
						System.out.print("Introduce otro número: ");
						numeroDecimal = leer();
					}
					String resultadoBinario = decimalABinario(numeroDecimal);
					System.out.println("El resultado de la conversión es " + resultadoBinario);
					
					break;
					
				default:
					System.out.println("No es una opción válida");	
			}
		}
	}
	
	private static String decimalABinario(int numeroDecimal) {
		String resultado = "";
		int dividendo = numeroDecimal;
		int resto = 0;
		
		while (dividendo > 0) {
			resto = dividendo % 2;
			dividendo /= 2;
			resultado = resto + resultado;
		}
		return resultado;
	}
	
	private static int binarioADecimal(String numeroTexto) {
		int resultado = 0;
		int posicion = numeroTexto.length() - 1;
		int exponente = 0;
		
		while(posicion >= 0) {
			resultado += Math.pow(2, exponente) * Character.getNumericValue(numeroTexto.charAt(posicion));
			exponente++;
			posicion--;
		}
		return resultado;
	}

	private static int leer() {
		Scanner escaner = new Scanner(System.in);
		return escaner.nextInt();
	}

}
