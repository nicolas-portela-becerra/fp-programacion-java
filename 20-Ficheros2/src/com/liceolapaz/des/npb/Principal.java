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
import java.util.ArrayList;
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
				
				ArrayList texto = leerFicheroTexto(rutaTexto);
					
				mostrarContenido(texto);
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

	private static void mostrarContenido(ArrayList<String> texto) {
		System.out.println("-----------");
		for(String linea : texto) {
			System.out.println(linea);
		}
		System.out.println("-----------");
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
		ArrayList<String> contenido = leerFicheroTexto(rutaOrigen);
		
		if(contenido != null) {
			escribirFicherotexto(contenido, rutaDestino);
		}
		
	}

	private static void escribirFicherotexto(ArrayList<String> contenido, String rutaDestino) {
		File fichero = new File(rutaDestino);
		
		try {
			FileWriter fw = new FileWriter(fichero);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			int posicion = 0;
			for(String linea : contenido) {
				if(posicion < contenido.size() - 1) {
					pw.println(linea);
				}
				else {
					pw.print(linea);
				}
				posicion++;
			}
			
			pw.close();
			bw.close();
			fw.close();
		} 
		catch (IOException e) {
			System.out.println("Ruta del archivo inválida, " + e);
		}
		
	}

	private static void copiarFicheroBinario(String rutaOrigenStream, String rutaDestinoStream) {
		ArrayList<Byte> contenido = leerFicheroStream(rutaOrigenStream);
		
		if(contenido != null) {
			escribirFicheroStream(contenido, rutaDestinoStream);
		}
		
	}

	private static void escribirFicheroStream(ArrayList<Byte> contenido, String rutaDestinoStream) {
		File archivoStream = new File(rutaDestinoStream);
		try {
			FileOutputStream fos = new FileOutputStream(archivoStream);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			for(Byte b : contenido) {
				bos.write(b);
			}
			
			bos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			System.out.println("Ruta de archivo inválida, " + e);
		} catch (IOException e) {}
		
	}

	private static ArrayList<Byte> leerFicheroStream(String rutaOrigenStream) {
		File archivoStream = new File(rutaOrigenStream);
		ArrayList<Byte> contenido = new ArrayList<>();
		
		try {
			FileInputStream fis = new FileInputStream(archivoStream);
			BufferedInputStream bis = new BufferedInputStream(fis);
			byte [] buffer = new byte [1024];
			
			int bytesLeidos = 0;
			
			bytesLeidos = bis.read(buffer);
			
			while(bytesLeidos != -1) {
					for(int i = 0; i < bytesLeidos; i++) {
						contenido.add(buffer[i]);
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

	private static ArrayList<String> leerFicheroTexto(String ruta) {
		File fichero = new File(ruta);
		ArrayList<String> texto = new ArrayList<>();
		
		if(fichero.isFile()) {
			try {
				FileReader fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				String linea = br.readLine();
				while(linea != null) {
					texto.add(linea);
					linea = br.readLine();	
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
