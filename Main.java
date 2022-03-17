import java.io.*;
import java.util.Scanner;

class Main {
      public static void main(String[] args)throws IOException {
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

				menu();
  }

	public static void menu(){
		Scanner scMenu = new Scanner(System.in);
					int opc;
		do{
			System.out.println("Bienvenido al Menu escoge una opcion para ordenar tu archivo: \n1.- Polifase \n2.- Mezcla equilibrada \n3.- Distribucion por Radix \n4.- Salir");
			opc = scMenu.nextInt();
	
			switch(opc){
				case 1:
					System.out.println("Ordenamiento por Polifase");
					break;
				case 2:
					System.out.println("Ordenamiento por Mezcla Equilibrada");
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
}
