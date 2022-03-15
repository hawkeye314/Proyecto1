import 	java.io.*;

class Main {
  public static void main(String[] args)throws IOException {
    System.out.println("------- Proyecto 1 EDA -------");
		File doc = new File("Demo.txt");
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