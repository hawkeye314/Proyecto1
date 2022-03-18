package Archivos;
import java.io.*;
import java.util.Scanner;

public class Archivos {
        public static void caracteres()throws IOException{
        Scanner sc = new Scanner(System.in);
      
        String nombre,linea;
        System.out.println("------- Proyecto 1 EDA -------");
        System.out.println("Dame el nombre del archivo de caracteres");
        nombre=sc.nextLine();
        File doc = new File(nombre+".txt");
       
        BufferedReader freader=new BufferedReader(new FileReader(doc));
        linea=freader.readLine();
        String[] separar=linea.split(",");
        for(char j = 0;j<separar.length;j++)
            System.out.println(separar[j]);
        
        freader.close();
}
}