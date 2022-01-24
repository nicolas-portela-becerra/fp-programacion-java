package com.liceolapaz.des.npb;
import java.util.*;
import java.util.regex.Pattern;

public class Principal {

	public static void main(String[] args) {
		//Conversor de Binario a decimal y decimal a binario
		//Mostrar men� para elegir Binario -> Decimal o Decmial -> Binario
		//Pedir numero y almancenarlo
		//Hacer la conversi�n que haya elegido el usuario
		while(true) {
			System.out.println("Conversor de n�meros\n"
					+ "1. Convertir de binario a decimal\n"
					+ "2. Convertir de decimal a binario\n"
					+ "0. Salir del programa");
			System.out.print("Elige una opci�n: ");
			int opcion = leer();
			switch(opcion) {
				case 0:
					System.out.println("Adi�s.");
					System.exit(0);
					
				case 1: 
					System.out.print("Introduce un n�mero en binario: ");
					int numeroBinario = leer();
					
					while(numeroBinario < 0) {
						System.out.println("El n�mero no puede ser menor que 0.");
						System.out.print("Introduce otro n�mero: ");
						numeroBinario = leer();
					}
					String numeroTexto = "" + numeroBinario;
					// Comprobar que el n�mero solo contiene 1 y 0
					while (!numeroTexto.trim().matches("[01]+")) {
						System.out.println("El n�mero introducido no es binario");
					}
					int resultadoDecimal = binarioADecimal(numeroTexto);
					System.out.println("El resultado de la conversi�n es " + resultadoDecimal);
					
					break;
					
				case 2:
					System.out.print("Introduce un n�mero en decimal: ");
					 int numeroDecimal = leer();
					 
					while(numeroDecimal < 0) {
						System.out.println("El n�mero no puede ser menor que 0");
						System.out.print("Introduce otro n�mero: ");
						numeroDecimal = leer();
					}
					String resultadoBinario = decimalABinario(numeroDecimal);
					System.out.println("El resultado de la conversi�n es " + resultadoBinario);
					
					break;
					
				default:
					System.out.println("No es una opci�n v�lida");	
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
