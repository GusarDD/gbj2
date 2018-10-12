package Chat;

import javax.swing.*;

public abstract class GamesMenuManager {

    public static GuessWord startGuessWord(JTextArea text, MainWindow frame) {
        return new GuessWord(text, frame); //загадали слово и сказали, что игра началась
    }

    public static void gameInput(JTextField from, JTextArea to, String name, Game game) {
        String s = from.getText();
        to.append(name + ": " + from.getText() + "\n");
        from.setText("");
        from.requestFocus();
        game.getTurn(s);
    }
}