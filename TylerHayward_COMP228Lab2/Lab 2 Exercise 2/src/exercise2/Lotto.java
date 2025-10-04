package exercise2;

import javax.swing.JOptionPane;
import java.util.Random;

public class Lotto {

    int[] numbers = new int[3];

    public Lotto() {
        Random r = new Random();
        for(int i = 0; i < numbers.length; i++) {
            numbers[i] = r.nextInt(9) + 1; // random 1-9
        }
    }

    public int[] giveNums() {
        return numbers;
    }

    public static void main(String[] args) {

        String userGuess = JOptionPane.showInputDialog(null, "Enter a number from 3 to 27 you think will match the lotto sum:");
        if(userGuess == null) {
            JOptionPane.showMessageDialog(null, "Game closed.");
            System.exit(0);
        }

        int guess = 0;
        try {
            guess = Integer.parseInt(userGuess);
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "That's not a number!");
            System.exit(0);
        }

        int tries = 0;
        boolean userWin = false;

        while(tries < 5 && !userWin) {
            Lotto game = new Lotto();
            int[] arr = game.giveNums();
            int total = arr[0] + arr[1] + arr[2];
            tries++;

            JOptionPane.showMessageDialog(null, "Try #" + tries + ": " + arr[0] + " + " + arr[1] + " + " + arr[2] + " = " + total);

            if(total == guess) {
                JOptionPane.showMessageDialog(null, "Congrats! You guessed it right!");
                userWin = true;
            } else {
                JOptionPane.showMessageDialog(null, "No match. Keep going!");
            }
        }

        if(!userWin) {
            JOptionPane.showMessageDialog(null, "Game over! The computer wins.");
        }
    }
}
