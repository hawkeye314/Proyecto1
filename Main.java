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
        char [] i = new char[100];
        freader.read(i);
        for(char j : i){
                System.out.print(j);
        }
        freader.close();
  }
}
