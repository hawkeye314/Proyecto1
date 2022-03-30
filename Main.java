import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;
//import java.util.List;


class Main {
      public static void main(String[] args)throws IOException {
				char [] arch;
        arch = caracteres();
				menu(arch);

				System.out.print("------------ iubsekdjvbivkb ---------------");
				for(char j : arch){
					System.out.print(j);
				}
  }



  
public static void menu(char[] arch){
		Scanner scMenu = new Scanner(System.in);
					int opc;
		do{
			System.out.println("\nBienvenido al Menu escoge una opcion para ordenar tu archivo: \n1.- Polifase \n2.- Mezcla equilibrada \n3.- Distribucion por Radix \n4.- Salir");
			opc = scMenu.nextInt();
	
			switch(opc){
				case 1:
					System.out.println("Ordenamiento por Polifase");
					break;
				case 2:
					System.out.println("Ordenamiento por Mezcla Equilibrada");
					mezclaEquilibrada(arch);
					break;
				case 3:
					System.out.println("Ordenamiento por Distribucion Radix");
					break;
				case 4:
					System.out.println("Hasta luego :)");
					break;
				default:
					System.out.println("Introduzca una opcion valida");
					break;
			}
		}while(opc != 4);
	}
	//comentario para poder añaidrlo al control de versiones
public static void mezclaEquilibrada(char[] arch){
		
		LinkedList<String> listaNombres = new LinkedList<String>();
		LinkedList<String> l1 = new LinkedList<String>();
		LinkedList<String> l2 = new LinkedList<String>();

		String nombres = new String(arch); //aqui metemos todos los caracteres del arreglo arch en un string
		//String [] nombresCompletos = new String[999];
		LinkedList<String> nombresCompletos = new LinkedList<String>();
		String [] separador = nombres.split(","); //aqui separamos el string en un arreglo en el que cada elemento del arreglo es un nombre y un apellido
		
		System.out.println("el tamaño de separador es:");
		System.out.println(separador.length);
		
		//aqui se añaden a una lista los nombres junto con sus respectivos apellidos

		for(int x = 1; x < separador.length - 1; x++ ){
			if(x % 2 != 0){
				nombresCompletos.add(separador[x - 1] + separador[x]);
			}
		}
		
		System.out.println("Aqui se imprime la lista de nombres y apellidos como un solo elemento cada uno");
		int i = 0;
		for (String string : nombresCompletos) {
			//if(string != null){
				//i++;
				System.out.println(string);
				//System.out.println(i);
			//}
		}
		l1.add(nombresCompletos.getFirst());

		System.out.println("aqui esta el primer elemento de l1: "+ l1.getFirst());

		//En estos for el programa separa tanto los nombres y apellidos en diferentes elementos del arreglo
		/*
		for (String string : separador) {
			listaNombres.add(string);
		}
		System.out.println("aqui imprime la lista ligada de nombres");
		for (String prueba : listaNombres) {
			System.out.print(prueba);
			System.out.print("\n");
		}
		*/

	}

	public static char[] caracteres()throws IOException{
	  Scanner sc = new Scanner(System.in);
	  String nombre;
	  System.out.println("------- Proyecto 1 EDA -------");
	  System.out.println("Dame el nombre del archivo de caracteres");
	  nombre=sc.nextLine();
	  File doc = new File(nombre+".txt");
	  doc.createNewFile();
	  FileReader freader = new FileReader(doc);
	  char [] i = new char[999];
	  freader.read(i);
	  
    for(char j : i){
	    System.out.print(j);
	  }
    
	  freader.close();
		return  i;
	}
}