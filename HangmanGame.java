import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
    private static final String[] wordList = {"java", "programming", "hangman", "computer", "algorithm"};
    private static String chosenWord;
    private static List<String> blankList = new ArrayList<>();
    private static int lives = 6;

    public static void main(String[] args) {
        Random random = new Random();
        chosenWord = wordList[random.nextInt(wordList.length)];
        char j;
        for (int i = 0; i < chosenWord.length(); i++) {
            blankList.add("_");
        }
        //System.out.println(word);
        System.out.println(
            " _                                              \n" +
            "| |                                             \n" +
            "| |__   __ _ _ __   __ _ _ __ ___   __ _ _ __  \n" +
            "| '_ \\ / _` | '_ \\ / _` | '_ ` _ \\ / _` | '_ \\ \n" +
            "| | | | (_| | | | | (_| | | | | | | (_| | | | |\n" +
            "|_| |_|\\__,_|_| |_|\\__, |_| |_| |_|\\__,_|_| |_|\n" +
            "                    __/ |                      \n" +
            "                   |___/  "
        );
        System.out.println(blankList);

        while (!blankList.equals(word) && lives > 0) {
            guess();
            if (String.join("", blankList).equals(chosenWord)) {
                System.out.println("You won!!");
                break;
            }
         if(lives==0) {
            System.out.println("No lives left!!");
            break;
        }
        }

       
    }

    private static void livesLeft() {
        switch (lives) {
            case 5:
                System.out.println(
                        "  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        "_|___\n");
                break;
            case 4:
                System.out.println(
                        "  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |      \\ \n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        "_|___\n");
                break;
            case 3:
                System.out.println(
                        "  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |      \\ /\n" +
                        " |\n" +
                        " |\n" +
                        " |\n" +
                        "_|___\n");
                break;
            case 2:
                System.out.println(
                        "  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |      \\|/\n" +
                        " |       | \n" +
                        " |\n" +
                        " |\n" +
                        "_|___\n");
                break;
            case 1:
                System.out.println(
                        "  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |      \\|/\n" +
                        " |       | \n" +
                        " |      / \n" +
                        " |\n" +
                        "_|___\n");
                break;
            case 0:
                System.out.println(
                        "  _______\n" +
                        " |/      |\n" +
                        " |      (_)\n" +
                        " |      \\|/\n" +
                        " |       | \n" +
                        " |      / \\\n" +
                        " |\n" +
                        "_|___\n");
                break;
        }
    }

    private static void guess() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess The word: ");
        String guessWord = scanner.nextLine().toLowerCase();
        int flag = 0;

        for (int i = 0; i < chosenWord.length(); i++) {
            if (guessWord.equals(String.valueOf(chosenWord.charAt(i)))) {
                flag++;
                blankList.set(i, guessWord);
            }
           
        }
        System.out.println(blankList);

        if (flag == 0) {
            lives--;
            livesLeft();
        }
    }
}
