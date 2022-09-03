import java.util.ArrayList;
import java.util.Random;


public class PuzzleTest {
    public static void main(String[] args) {
        PuzzleJava appTest = new PuzzleJava();

        ArrayList<Integer> random = new ArrayList<Integer>();  
        System.out.println("----- GetTenRolls Test");      
        appTest.getTenRolls(random);

        System.out.println("----- Get Random Letter Test");      
        appTest.getRandomLetter();

        System.out.println("----- Generate Password Test");    
        System.out.println(appTest.generatePassword());

        System.out.println("----- Password Set Test");    
        appTest.getNewPasswordSet(8);
  

        

    }
}
