package Chat;

import java.util.*;
import javax.swing.*;

public class GuessWord extends Game {
    public String chosenWord;
    private JTextArea text;
    private MainWindow frame;


    public GuessWord(JTextArea text, MainWindow frame) {
//		frame.gameIsActive = true;
        this.frame = frame;
        this.text = text;
        text.append("Угадайте слово!" + "\n");
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        chosenWord = genWord(words);
    }

    public void getTurn(String turn) {
        frame.gameIsActive = this.analizeTurn(turn, chosenWord);
        if (frame.gameIsActive) {
            guessWrong(turn, chosenWord);
        } else {
            text.append("Поздравляем! Вы отгадали слово " + chosenWord + "\n");
//			continueAnalize();
        }
    }

    public String genWord(String[] mas) {
        Random rand = new Random();
        int x = rand.nextInt(mas.length);
        return mas[x];
    }

    public boolean analizeTurn(String firstStr, String secondStr) {
        return (!firstStr.equals(secondStr));
    }

    public void guessWrong(String firstStr, String secondStr) {
        text.append("Вы не отгадали, загаданное слово " + "\n");
        text.append("Угаданные буквы: ");
        String sumStr = "###############";
        String replaceStr = "";
        int len = secondStr.length() < firstStr.length() ? secondStr.length() : firstStr.length();
        for (int i = 0; i < len; i++) {
            char charPlus = (firstStr.charAt(i) == secondStr.charAt(i) ? firstStr.charAt(i) : sumStr.charAt(14));
            String strPlus = Character.toString(charPlus);
            replaceStr = replaceStr.concat(strPlus);
        }
        sumStr = replaceStr;
        for (int i = replaceStr.length(); i < 15; i++) {
            sumStr = sumStr.concat("#");
        }
        text.append(sumStr + "\n");
    }

//	public boolean continueAnalize() {
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Хотите сыграть еще? 1 - да, 0 - нет");
//		int a = sc.nextInt();
//		return (a == 1 ? true : false);
//	}
}
