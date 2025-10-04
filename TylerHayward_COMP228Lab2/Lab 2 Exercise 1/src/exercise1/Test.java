package exercise1;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {

    String[] questions = {
            "1. Which one of the following symbols indicates a single line comment in Java application source code?",
            "2. If a local variable or parameter in a method has the same name as a field of the class, the field is hidden until the block terminates execution. This phenomenon is termed as ____________________________.",
            "3. Which of the following statements is false about Java method statements?",
            "4. Converting an argument’s value, if possible, to the type that the method expects to receive in its corresponding parameter is called ____________________.",
            "5. Which of the following components does a Java application need to have at least one of?"
    };

    String[][] choices = {
            {"#!", "##", "\\\\", "//"},
            {"buffering", "shadowcasting", "shadowing", "clouding"},
            {
                    "Statements in a method body are not hidden from other methods.",
                    "Statements in a method body is written only once",
                    "Statements in a method body determine the behavior of an object.",
                    "Statements in a method body use existing classes and methods as building blocks to create new programs."
            },
            {"argument conversion", "argument truncation", "argument promotion", "type casting"},
            {"Instance variable", "Class", "Local variable", "Non-static Method"}
    };

    int[] answers = {3, 2, 0, 2, 1};

    int right = 0;
    int wrong = 0;
    Random r = new Random();

    public void ask() {
        for (int i = 0; i < questions.length; i++) {
            showQ(i);
        }
        showResult();
    }

    public void showQ(int i) {
        StringBuilder q = new StringBuilder(questions[i] + "\n");
        for (int j = 0; j < choices[i].length; j++) {
            q.append((j + 1)).append(". ").append(choices[i][j]).append("\n");
        }

        String input = JOptionPane.showInputDialog(null, q.toString(), "Java Quiz", JOptionPane.QUESTION_MESSAGE);

        if (input == null) {
            JOptionPane.showMessageDialog(null, "Test canceled");
            System.exit(0);
        }

        try {
            int ans = Integer.parseInt(input) - 1;
            check(i, ans);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Enter number 1-4 pls");
            showQ(i);
        }
    }

    public void check(int qIndex, int ans) {
        if (ans == answers[qIndex]) {
            right++;
            JOptionPane.showMessageDialog(null, posMsg());
        } else {
            wrong++;
            JOptionPane.showMessageDialog(null, negMsg() + "\nCorrect: " + choices[qIndex][answers[qIndex]]);
        }
    }

    public String posMsg() {
        int n = r.nextInt(4);
        if (n == 0) return "Excellent!";
        if (n == 1) return "Correct!";
        if (n == 2) return "On a roll!";
        return "Nice Job!";
    }

    public String negMsg() {
        int n = r.nextInt(4);
        if (n == 0) return "Incorrect.";
        if (n == 1) return "Wrong.";
        if (n == 2) return "Not Quite!";
        return "Sorry u Tried Your Best.";
    }

    public void showResult() {
        int total = right + wrong;
        double percent = ((double) right / total) * 100;
        JOptionPane.showMessageDialog(null, "Done!\nRight: " + right + "\nWrong: " + wrong + "\nPercent: " + String.format("%.2f", percent) + "%");
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.ask();
    }
}
