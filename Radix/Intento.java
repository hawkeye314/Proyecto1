import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;



public class Intento {
    static List<Integer> al = new ArrayList<>();
    public static void main(String[] args)throws IOException {
    
    RadixSort ordenamiento = new RadixSort();
      /*
      char [] arch;
      arch = caracteres();
      menu();
      System.out.print("------------ iubsekdjvbivkb ---------------");
      for(char j : arch){
              System.out.print(j);
      }
*/  //caracteres();
    
    claves();

  }



  
public static void menu(){
    Scanner scMenu = new Scanner(System.in);
    int opc;
    do{
        System.out.println("""
                           Bienvenido al Menu escoge una opcion para ordenar tu archivo: 
                           1.- Polifase 
                           2.- Mezcla equilibrada 
                           3.- Distribucion por Radix 
                           4.- Salir """);
        opc = scMenu.nextInt();

        switch(opc){
            case 1 -> System.out.println("Ordenamiento por Polifase");
            case 2 -> System.out.println("Ordenamiento por Mezcla Equilibrada");
            case 3 -> System.out.println("Ordenamiento por Distribucion Radix");
            case 4 -> System.out.println("Hasta luego :)");
            default -> System.out.println("Introduzca una opcion valida");
        }
    }while(opc != 4);
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
    //RadixSort ordenamiento = new RadixSort();
    String nombre; 
    int num = 0;
    System.out.println("\nDame el nombre del archivo de claves");
    nombre=sc.nextLine();
    try(Scanner input = new Scanner(new File(nombre+".txt"))){
        input.useDelimiter("[,\\s]");
        while(input.hasNextLine()){
            num = input.nextInt();
            System.out.println(num);
        }
        System.out.println("Ordenando con RadixSort");
        ordenacionRadix(num);
        imprimirVector(num);
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
  
public static List<Integer> ordenacionRadix(int vec1){
    int rep=1; //cantidad de repeticiones
    int numBytes=4; //número de bytes a desplazar
    int numColas=(int) Math.pow(2, numBytes);
    //Creación de las colas
    //int vec[];
    List<Integer> vec=new ArrayList<>();
    vec.add(vec1);
    Queue[] cola=new LinkedList[numColas];

    for(int i=0;i<numColas;i++){
            cola[i]=new LinkedList();
    }
    int div=0;
    for (int i = 0; i < rep; i++) {
        //En esta parte recorre el vector para guardar cada valor en la cola
        for(int numero:vec){
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

public static void imprimirVector(int vec1){
    List<Integer> vec=new ArrayList<>();    
    System.out.println(); 
    vec.add(vec1);    
        for(int i=0;i<vec.size();i++){   
            System.out.print(vec.get(i)+" ");
        }
        System.out.println();
}
  
}
