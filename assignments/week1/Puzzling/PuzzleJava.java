import java.util.Random;
import java.util.ArrayList;


public class PuzzleJava {
    Random getRandom = new Random();
    String alphabet = "ABCCDEFGHIJKLMNOPQRSTUVWXYZ";
    char[] alphabetArr = alphabet.toCharArray();


    public ArrayList getTenRolls(ArrayList <Integer> random) {
        for (int i=10; i<=20; i++) {
            int randomInt = getRandom.nextInt(i);
            random.add(randomInt);
           
        }
        System.out.println(random);
        return random;
    }

    public char getRandomLetter() {
        int randomInt = getRandom.nextInt(26);
        char randomLetter = alphabetArr[randomInt];
        System.out.println(randomLetter);
        return randomLetter;
    }
    String finalPassword = "";
    public String generatePassword() {
        for (int i=0; i<9; i++) {
            char passwordLetter = getRandomLetter();
            String fullPassword = Character.toString(passwordLetter);
            finalPassword = finalPassword + fullPassword;
        } 
        return finalPassword;
    }

    ArrayList<String> passwordSet = new ArrayList<String>();

    public ArrayList getNewPasswordSet(int length) {
        for (int i=0; i<length; i++) {
            int randomInt = getRandom.nextInt(length);
            char passwordLetter= alphabetArr[randomInt];
            String fullPassword = Character.toString(passwordLetter);
            passwordSet.add(fullPassword);
        }
        System.out.println(passwordSet);
        return passwordSet;
    }
}
