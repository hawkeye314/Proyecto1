import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;


class Main {
      public static void main(String[] args)throws IOException {
				char [] arch;
        arch = caracteres();
				menu(arch);

				System.out.print("------------ iubsekdjvbivkb ---------------");
				for(char j : arch){
					System.out.print(j);
				}
        claves();
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

public static void claves() throws IOException{
    Scanner sc = new Scanner(System.in);
    RadixSort ordenamiento = new RadixSort();
    String nombre;
    List<Integer> num1=new ArrayList<>();
    int num = 0;
    System.out.println("\nDame el nombre del archivo de claves");
    nombre=sc.nextLine();
    try(Scanner input = new Scanner(new File(nombre+".txt"))){
        input.useDelimiter("[,\\s]");
        System.out.println("Claves en el archivo "+nombre+".txt");
        while(input.hasNextLine()){
            num = input.nextInt();
            num1.add(num);
            System.out.println(num1);
        }
        System.out.println("Numero de datos "+num1.size());
        
        System.out.println("Ordenando con RadixSort");
        ordenamiento.ordenacionRadix(num1);
        ordenamiento.imprimirVector(num1);
    }catch (Exception e){
        e.printStackTrace();
    }
            //input.close();
    
           
            //ESTO YA FUNCIONA SOLO QUE SE QUEDA COMO STRING Y NO INT
            /*
            try(Scanner input = new Scanner(new File(nombre+".txt"))){
            
            while(input.hasNextLine()){
            String num = input.nextLine();
            System.out.println(num);
            int a=Integer.parseInt(num);
            System.out.println(a);
            }
            input.close();
            // AQUI ACABA ESA PARTE
            
            //ESTA EXCEPCION TAMBIEN INCLUIRLA
            /*
            //return num;   
        
}
*/
}
  
public static List<Integer> ordenacionRadix(List vec){
    int rep=1; //cantidad de repeticiones
    int numBytes=4; //número de bytes a desplazar
    int numColas=(int) Math.pow(2, numBytes);
    //Creación de las colas
    //int vec[];
    //List<Integer> vec=new ArrayList<>();
    //vec.add(vec1);
    Queue[] cola=new LinkedList[numColas];

    for(int i=0;i<numColas;i++){
            cola[i]=new LinkedList();
    }
    int div=0;
    for (int i = 0; i < rep; i++) {
        //En esta parte recorre el vector para guardar cada valor en la cola
        //for(int numero:vec){
        for(int numero=0;numero<vec.size();numero++){
                //busca el mayor número del vector
                if(i==0) if(numero>rep) rep=numero;
                //Calcula en que cola debe de ir cada numero
                int numCola=(numero>>div)&0xf;
                cola[numCola].add(numero);
        }
        System.out.println("Cola: "+ Arrays.toString(cola));
        div=div+numBytes;
        //recorre cada cola para colocar cada elemento en el vector
        int j=0;
        for(Queue<Integer> c:cola){
                while(!c.isEmpty())
                        vec.set(j++, c.remove());
        }
        //la primera vez se actualiza el número de veces que debe ejecutar el proceso
        if(i==0){
                rep=(int) (Math.log(rep)/Math.log(numColas))+1;
        }               
    }
    System.out.println("Numero de colas "+rep);
    return vec;
}


public static void imprimirVector(List vec){    
    System.out.println(); 
        for(int i=0;i<vec.size();i++){   
            System.out.print(vec.get(i)+" ");
        }
        System.out.println();
}
  
}