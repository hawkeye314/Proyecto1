import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 *
 * @author rodol
 */
public class RadixSort{
    
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

