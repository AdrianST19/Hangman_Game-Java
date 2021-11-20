import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spanzuratoarea {
  public static void main(String[] args) throws FileNotFoundException {  
    
    Scanner input = new Scanner(System.in);
    String cuvant;
    System.out.println("Jucatorul 1 este rugat sa introduca un cuvant:");
    cuvant = input.nextLine();
    System.out.println("\nJucatorul 2 poate incepe sa ghiceasca.Mult noroc!");
    
    List<Character> nrGhiciri = new ArrayList<>();
    
    Integer ghiciriFalse = 0;
    
    while(true) {
      printRezultat(ghiciriFalse);
      
      if (ghiciriFalse >= 6) {
        System.out.println("Ai pierdut!");
        System.out.println("Cuvantul corect era: " + cuvant);
        break;
      }
      
      printLitereGhicite(cuvant, nrGhiciri);
      if (!getPlayerGuess(input, cuvant, nrGhiciri)) {
        ghiciriFalse++;
      }
      
      if(printLitereGhicite(cuvant, nrGhiciri)) {
        System.out.println("Ai castigat!");
        break;
      }
      
      System.out.println("Incearca sa ghicesti cuvantul:");
      if(input.nextLine().equals(cuvant)) {
        System.out.println("Ai castigat!");
        break;
      }
      else {
        System.out.println("Raspuns gresit! Incearca din nou.");
      }
    }
  }

  private static void printRezultat(Integer ghiciriFalse) {
    System.out.println(" -------");
    System.out.println(" |     |");
    if (ghiciriFalse >= 1) {
      System.out.println(" O");
    }
    
    if (ghiciriFalse >= 2) {
      System.out.print("\\ ");
      if (ghiciriFalse >= 3) {
        System.out.println("/");
      }
      else {
        System.out.println("");
      }
    }
    
    if (ghiciriFalse >= 4) {
      System.out.println(" |");
    }
    
    if (ghiciriFalse >= 5) {
      System.out.print("/ ");
      if (ghiciriFalse >= 6) {
        System.out.println("\\");
      }
      else {
        System.out.println("");
      }
    }
    System.out.println("");
    System.out.println("");
  }

  private static boolean getPlayerGuess(Scanner input, String cuvant, List<Character> ghicirileJucatorului) {
    System.out.println("Introdu o litera:");
    String litereGhicite = input.nextLine();
    ghicirileJucatorului.add(litereGhicite.charAt(0));
    
    return cuvant.contains(litereGhicite);
  }

  private static boolean printLitereGhicite(String cuvant, List<Character> ghicirileJucatorului) {
    int ghiciriCorecte = 0;
    for (int i = 0; i < cuvant.length(); i++) {
      if (ghicirileJucatorului.contains(cuvant.charAt(i))) {
        System.out.print(cuvant.charAt(i));
        ghiciriCorecte++;
      }
      else {
        System.out.print("-");
      }
    }
    System.out.println();
    
    return (cuvant.length() == ghiciriCorecte);
  }
}

