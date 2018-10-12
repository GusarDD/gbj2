package Chat;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainWindow extends JFrame {

    private JTextArea messageHistory;
    private JTextField writeMessage;
    private String name;
    public boolean gameIsActive;
    public Game game;

    public MainWindow() {
        gameIsActive = false;
        name = "User";
        JPanel writePanel = new JPanel();
        messageHistory = new JTextArea();
        messageHistory.setLineWrap(true);
        messageHistory.setWrapStyleWord(true);
        JScrollPane mhScroller = new JScrollPane(messageHistory);
        mhScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        mhScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        add(mhScroller, BorderLayout.CENTER);

        JButton sentButton = new JButton("Отправить");

        writeMessage = new JTextField(45);

        writePanel.add(writeMessage);
        writePanel.add(sentButton);
        sentButton.addActionListener(new SentMessageListener());
        writeMessage.addActionListener(new SentMessageListener());

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu settingsMenu = new JMenu("Настройки");
        JMenu gamesMenu = new JMenu("Начать игру..");
        JMenuItem clearMenuItem = new JMenuItem("Очистить");
        JMenuItem openMenuItem = new JMenuItem("Открыть историю");
        JMenuItem saveMenuItem = new JMenuItem("Сохранить историю");
        JMenuItem exitMenuItem = new JMenuItem("Выход");
        JMenuItem nameMenuItem = new JMenuItem("Сменить имя");
        JMenuItem guessWordMenuItem = new JMenuItem("Угадай слово");
        clearMenuItem.addActionListener(new ClearMenuListener());
        openMenuItem.addActionListener(new OpenMenuListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
        exitMenuItem.addActionListener(new ExitMenuListener());
        nameMenuItem.addActionListener(new NameMenuListener());
        guessWordMenuItem.addActionListener(new GuessWordMenuListener());
        fileMenu.add(clearMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(exitMenuItem);
        settingsMenu.add(nameMenuItem);
        gamesMenu.add(guessWordMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(settingsMenu);
        menuBar.add(gamesMenu);
        setJMenuBar(menuBar);

        getContentPane().add(BorderLayout.SOUTH, writePanel);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                FileMenuManager.exitFromChat(messageHistory, MainWindow.this);
            }
        });

        writeMessage.requestFocus();

        setTitle("Say Hello!");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 500);
        setVisible(true);
    }

    public class SentMessageListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            if (gameIsActive) {
                GamesMenuManager.gameInput(writeMessage, messageHistory, name, game);
            } else {
                FileMenuManager.sentText(writeMessage, messageHistory, name);
            }
        }
    }

    public class ClearMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            FileMenuManager.clearTextArea(messageHistory);
            writeMessage.requestFocus();
        }
    }

    public class OpenMenuListener implements ActionListener {

        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(MainWindow.this);
            FileMenuManager.openMessages(messageHistory, fileOpen.getSelectedFile());
        }
    }

    public class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {

            FileMenuManager.saveMessages(messageHistory, MainWindow.this);
        }
    }

    public class ExitMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            FileMenuManager.exitFromChat(messageHistory, MainWindow.this);
        }
    }

    public class NameMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            MainWindow.this.name = JOptionPane.showInputDialog("Введите имя");

        }
    }


    public class GuessWordMenuListener implements ActionListener {

        public void actionPerformed(ActionEvent ev) {
            gameIsActive = true;
            game = GamesMenuManager.startGuessWord(messageHistory, MainWindow.this);
        }
    }

}
