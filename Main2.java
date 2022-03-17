import java.io.*;
import java.util.Scanner;

public class Main2 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    String nombre;

    System.out.println("------- Proyecto 1 EDA -------");
    System.out.println("Dame el nombre del archivo de caracteres");
    nombre = sc.nextLine();
    File doc = new File(nombre + ".txt");
    doc.createNewFile();
    FileReader freader = new FileReader(doc);

    BufferedReader b = new BufferedReader(freader);
    while ((nombre = b.readLine()) != null)
      System.out.println(nombre);
    b.close();


  }

}