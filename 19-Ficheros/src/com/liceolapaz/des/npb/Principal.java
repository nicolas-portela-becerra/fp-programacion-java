package com.liceolapaz.des.npb;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		while(true) {
			escribirMenu();
			int opcion = leerInt();
			
			switch(opcion) {
			default:
				System.out.println("Opción no válida");
			break;
			
			case 1:
				String rutaTexto = pedirRuta();
				
				String texto = leerFicheroTexto(rutaTexto);
					
				System.out.println(texto);
			break;
			
			case 2:
				escribirSubMenu();
				opcion = leerInt();
				
				switch(opcion){
					default:
						System.out.println("Opción no válida.");
					break;
					
					case 1:
						String rutaOrigenTexto = pedirRuta();
						String rutaDestinoTexto = pedirRutaDestino();
						
						copiarFicheroTexto(rutaOrigenTexto, rutaDestinoTexto);
					break;
					
					case 2:
						String rutaOrigenStream = pedirRuta();
						String rutaDestinoStream = pedirRutaDestino();
						
						copiarFicheroBinario(rutaOrigenStream, rutaDestinoStream);
					break;
					
					case 0:
					break;
				}
			break;
			
			case 3:
				String directorio = pedirDirectorio();
				listarDirectorio(directorio);
			break;
			
			case 0:
				System.exit(0);
			break;
			}
		}
	}

	private static void listarDirectorio(String directorio) {
		File listaDirectorio = new File(directorio);
		
		if(listaDirectorio.list() != null) {
			String [] lista = listaDirectorio.list();
			System.out.println("Archivos del directorio:");
			for(int i = 0; i < lista.length; i++) {
				System.out.println(lista[i]);
			}
			System.out.println("\n");
		}
		
		
	}

	private static String pedirDirectorio() {
		System.out.print("Introduce la ruta del directorio que quieres listar: ");
		Scanner sc = new Scanner(System.in);
		return sc.next();
	}

	private static void copiarFicheroTexto(String rutaOrigen, String rutaDestino) {
		String contenido = leerFicheroTexto(rutaOrigen);
		
		if(contenido != null) {
			escribirFicherotexto(contenido, rutaDestino);
		}
		
	}

	private static void escribirFicherotexto(String contenido, String rutaDestino) {
		File fichero = new File(rutaDestino);
		
		try {
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.print(contenido);
			
			pw.close();
			bw.close();
			fw.close();
		} 
		catch (IOException e) {
			System.out.println("Ruta del archivo inválida, " + e);
		}
		
	}

	private static void copiarFicheroBinario(String rutaOrigenStream, String rutaDestinoStream) {
		byte [] contenido = leerFicheroStream(rutaOrigenStream);
		
		if(contenido != null) {
			escribirFicheroStream(contenido, rutaDestinoStream);
		}
		
	}

	private static void escribirFicheroStream(byte [] contenido, String rutaDestinoStream) {
		File archivoStream = new File(rutaDestinoStream);
		try {
			FileOutputStream fos = new FileOutputStream(archivoStream);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			bos.write(contenido);
			
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ruta de archivo inválida, " + e);
		} catch (IOException e) {}
		
	}

	private static byte[] leerFicheroStream(String rutaOrigenStream) {
		File archivoStream = new File(rutaOrigenStream);
		byte [] contenido = null;
		String texto = "";
		try {
			FileInputStream fis = new FileInputStream(archivoStream);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte [] buffer = new byte [1024];
			
			int bytesLeidos = 0;
			int posicion = 0;
			
			bytesLeidos = bis.read(buffer);
			
			while(bytesLeidos != -1) {
					for(int i = 0; i < bytesLeidos; i++) {
						contenido[posicion] = buffer[i];
						posicion++;
					}
					bytesLeidos = bis.read(buffer);
			}
			bis.close();
			fis.close();
		} 
		catch (FileNotFoundException e) {
			System.out.println("No se encontró el archivo, " + e);
			return null;
		} 
		catch (IOException e) {return null;}
	
		return contenido;
	}

	private static String pedirRutaDestino() {
		System.out.print("Introduce la ruta destino del archivo: ");
		Scanner sc = new Scanner (System.in);
		return sc.next();
	}

	private static void escribirSubMenu() {
		System.out.print("Tipo de fichero a copiar\n"
				+ "1. Fichero de texto\n"
				+ "2. Fichero binario\n"
				+ "0. Cancelar\n"
				+ "Escoja una opción: ");
		
	}

	private static String leerFicheroTexto(String ruta) {
		File fichero = new File(ruta);
		String texto = "";
		
		if(fichero.isFile()) {
			try {
				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				String s = br.readLine();
				while(s != null) {
					texto += s + "\n";
					s = br.readLine();	
				}
				br.close();
				fr.close();
				return texto;
			} 	
			catch (FileNotFoundException err) {
				System.out.println("Archivo no encontrado " + err);
				return  null;
			} 
			catch (IOException err) {return null;}
		}
		else {
			System.out.println("La ruta " + ruta + "no es vádlida");
			return null;
		}	
}

	private static String pedirRuta() {
		System.out.print("Introduce la ruta del archivo: ");
		Scanner sc = new Scanner (System.in);
		return sc.next();
	}

	private static int leerInt() {
		Scanner sc = new Scanner (System.in);
		return sc.nextInt();
	}

	private static void escribirMenu() {
		System.out.print("FICHEROS\n"
				+ "1. Leer fichero de texto\n"
				+ "2. Copiar fichero\n"
				+ "3. Listar archivos de directorio\n"
				+ "0. Salir\n"
				+ "Escoja una opción: ");
	}
}
