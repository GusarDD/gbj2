package Chat;

import javax.swing.*;
import java.io.*;

public abstract class FileMenuManager {
    public static void clearTextArea(JTextArea text) {
        text.setText("");
    }

    public static void sentText(JTextField from, JTextArea to, String name) {
        to.append(name + ": " + from.getText() + "\n");
        from.setText("");
        from.requestFocus();
    }

    public static void exitFromChat(JTextArea text, MainWindow frame) {
        int result = JOptionPane.showConfirmDialog(frame, "Хотите сохранить переписку?", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            saveMessages(text, frame);
            System.exit(0);
        }
        if(result == JOptionPane.CANCEL_OPTION) {
            return;
        }
        System.exit(0);
    }

    public static void saveMessages(JTextArea text, MainWindow frame) {
        try {


            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileSave.getSelectedFile()));
                writer.write(text.getText());
                writer.close();
            } catch (IOException ex) {
                System.out.println("couldn't write the file");
                ex.printStackTrace();
            }
            JOptionPane.showMessageDialog(frame, "Успешно сохранено");
        } catch (Exception e) {
        }
    }

    public static void openMessages(JTextArea text, File file) {
        try {

            try {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    text.append(line + "\n");
                }
                reader.close();
            } catch (Exception ex) {
                System.out.println("couldn't read the file");
                ex.printStackTrace();
            }
        } catch (Exception e) {
        }
    }
}