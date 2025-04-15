import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" Ingrese la cantidad de candidatos a presidente ");
        int CantidadC = sc.nextInt();

        for(int i = 0; i< CantidadC; i++){
            Scanner dd = new Scanner(System.in);
            System.out.println("Ingrese datos del candidato " + (i+1));
            System.out.println("Ingrese el nombre del candidato");
            String nombre = dd.nextLine();
            System.out.println("Ingrese el nombre del partido de "+ nombre);
            String partido = dd.nextLine();

            Candidato c = new Candidato((i+1), nombre,partido);
        }
    }
}
