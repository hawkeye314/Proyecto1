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
		
		//aqui hacemos un arreglo en donde vamos a guardar los nombres y su valor en ascii
		String[][] arrayNombres = new String[listaNombres.size()][2];

		//l1.add(nombresCompletos.getFirst());
		//System.out.println("aqui esta el primer elemento de l1: "+ l1.getFirst());

		//Aqui se divide la lista nnombres completos de dos sublistas, que son l1 y l2
		for(int j = 0; i < nombresCompletos.size(); j++){
			//int cont = 1;
			if(j == 0 || (j % 2) == 0){
				l1.add(nombresCompletos.getFirst());
				nombresCompletos.removeFirst();
			}else if(j == 1 || (j % 2) != 0){
				l2.add(nombresCompletos.getFirst());
				nombresCompletos.removeFirst();
				//cont++;
			}
		}
		//aqui se imprime l1
		System.out.println("aqui imprime los nombres de l1");
		for (String nombresl1 : l1) {
			System.out.println(nombresl1);
		}
		
		//sumbite va a sumar cada bite del arreglo para al final darnos la suma en valor ascii del nombre
		int sumbite = 0;
		//el string bite imprime el valor ascii de los caracteres de los string que se encuentran en las listas
		byte[] bite = l1.getFirst().getBytes();
		for (byte b : bite) {
			System.out.println("blah blah blah" + b);
			sumbite += b;
		}

		//aqui se imprime la suma de los valores ascii del primer elemento de l1
		System.out.println("el tamaño del primer elemento de l1 es: " + sumbite);
		
		//aqui se imprime l2
		System.out.println("Aqui imprime los nombres de l2");
		for (String nombresl2 : l2) {
			System.out.println(nombresl2);
		}

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