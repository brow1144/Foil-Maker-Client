

import javax.swing.*;
import java.awt.*;

/**
 * CS180 Project03
 *
 * Foil Login Program.
 *
 * @author Kyle Brown, brow1144, G01
 *
 * @version 10/24/16
 *
 */

public class FoilMakerView extends JFrame  {

    protected FoilMakerController controller;

    protected  JFrame topFrame;

    protected  JPanel topPanel;
    protected  JPanel topHalf;

    protected  JPanel bottomMessagePanel;

    protected  JTextField usernameTextField;
    protected  JPasswordField passwordTextField;
    protected  JLabel usernameLabel;
    protected  JLabel passwordLabel;
    protected  JLabel createdCodeLabel;
    protected  JLabel bottomMessage;
    protected  JLabel username;

    protected  JButton loginButton;
    protected  JButton registerButton;
    protected  JButton startANewGameButton;
    protected  JButton startNewGameButton;
    protected  JButton joinAGameButton;
    protected  JButton joinGameButton;
    protected  JButton submitSuggestionButton;

    protected  JTextArea createdCode;
    protected  JTextArea output;

    protected  JTextField userSuggestion;
    protected JTextField codeTextField;

    protected  JScrollPane participantsScrollPane;


    protected  String currentUser;
    protected  String password;

    protected String gameCode;


    public FoilMakerView(FoilMakerController controller) {

        this.controller = controller;
        goToLoginPanel();

    }


    public void goToLoginPanel() {

        topFrame = new JFrame();
        topFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        topFrame.setSize(450, 600);
        topFrame.setTitle("FoilMaker");

        topFrame.setLocationRelativeTo(null);
        topFrame.setLayout(new BorderLayout());

//Top Panel (aka usernamePanel)
        topPanel = new JPanel();
        //topPanel.setBorder(BorderFactory.createTitledBorder("Top Panel"));
        username = new JLabel("FoilMaker!");
        topPanel.add(username);


//Login Stuff
        topHalf = new JPanel();
        topHalf.setLayout(new FlowLayout());
        topHalf.setBorder(BorderFactory.createRaisedBevelBorder());

        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new GridLayout(0, 1));
        //loginPanel.setBorder(BorderFactory.createTitledBorder("Login"));

        JPanel usernamePanel = new JPanel();
        usernamePanel.setLayout(new FlowLayout());
        //usernamePanel.setBorder(BorderFactory.createTitledBorder("Username Panel"));

        JPanel passwordPanel = new JPanel();
        passwordPanel.setLayout(new FlowLayout());
        //passwordPanel.setBorder(BorderFactory.createTitledBorder("Password Panel"));

        loginPanel.add(usernamePanel);
        loginPanel.add(passwordPanel);


        usernameTextField = new JTextField(20);
        passwordTextField = new JPasswordField(20);
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameTextField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordTextField);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout());
        //buttonPanel.setBorder(BorderFactory.createTitledBorder("Button Panel"));

        loginButton = addButtonToPane("Login", buttonPanel);

        registerButton = addButtonToPane("Register", buttonPanel);


        topHalf.add(loginPanel);
        topFrame.add(topHalf);
        topHalf.add(buttonPanel);


//Bottom Message Stuff

        bottomMessagePanel = new JPanel();
        //bottomMessagePanel.setBorder(BorderFactory.createTitledBorder("Bottom Message"));
        bottomMessage = new JLabel("Welcome!");

        bottomMessagePanel.add(bottomMessage);


        topFrame.add(topPanel, BorderLayout.NORTH);
        topFrame.add(bottomMessagePanel, BorderLayout.SOUTH);

        topFrame.setVisible(true);

    }

    protected JButton addButtonToPane(String text, Container pane) {
        JButton button = new JButton(text);
        pane.add(button);
        button.addActionListener(controller);
        return button;
    }

    public void goToNewGamePanel() {

        topPanel.setVisible(false);

        topPanel.removeAll();

        currentUser = usernameTextField.getText();

        username = new JLabel(currentUser);
        topPanel.add(username);
        topPanel.setVisible(true);


        topHalf.setVisible(false);
        topHalf.removeAll();




        startANewGameButton = addButtonToPane("Start a New Game", topHalf);
        joinAGameButton = addButtonToPane("Join a Game", topHalf);

        topHalf.setVisible(true);


    }

    public void goToStartNewGamePanel() {
        //adfasdfasdf
        topHalf.setVisible(false);
        topPanel.setVisible(false);

        topHalf.removeAll();
        topHalf.setLayout(new GridLayout(4, 0));
        bottomMessagePanel.removeAll();
        bottomMessage = new JLabel("Game Started: You are the Leader");
        bottomMessagePanel.add(bottomMessage);

        topPanel.removeAll();
        username = new JLabel(currentUser);
        topPanel.add(username);




        JPanel createdCodeLabelPanel = new JPanel();
        createdCodeLabelPanel.setLayout(new GridLayout(3, 0));

        JPanel createdCodeTextAreaPanel = new JPanel();
        createdCodeTextAreaPanel.setLayout(new FlowLayout());

        JPanel participantsPanel = new JPanel();
        participantsPanel.setLayout(new GridLayout(0, 1));
        participantsPanel.setBorder(BorderFactory.createTitledBorder("Participants"));
        output = new JTextArea(5, 20);
        output.setBackground(Color.GREEN);
        participantsScrollPane = new JScrollPane(output);
        participantsScrollPane.setBackground(Color.black);
        participantsPanel.add(participantsScrollPane);

        /*
        showMessage("Alice");
        showMessage("Bob");
        showMessage("Kyle");
        showMessage("Angela");
        */


        JPanel startGameButtonPanel = new JPanel();
        startGameButtonPanel.setLayout(new FlowLayout());


        createdCodeLabel = new JLabel("Others Should Use This Code to Join Your Game");
        JLabel empty = new JLabel("   ");
        createdCodeLabelPanel.add(empty);
        createdCodeLabelPanel.add(empty);
        createdCodeLabelPanel.add(createdCodeLabel);


        createdCode = new JTextArea("xx");
        createdCodeTextAreaPanel.add(createdCode);




        startNewGameButton = addButtonToPane("Start Game", startGameButtonPanel);


        topHalf.add(createdCodeLabelPanel);
        topHalf.add(createdCodeTextAreaPanel);
        topHalf.add(participantsPanel);
        topHalf.add(startGameButtonPanel);

        //asfasdfasdfsadf
        topHalf.setVisible(true);
        topPanel.setVisible(true);

    }

    public void goToJoinAGame() {
        //agsadgasdga
        topPanel.setVisible(false);

        topHalf.removeAll();
        bottomMessagePanel.removeAll();
        bottomMessage = new JLabel("Welcome!");
        bottomMessagePanel.add(bottomMessage);

        username = new JLabel(currentUser);
        topPanel.removeAll();
        topPanel.add(username);

        topHalf.setLayout(new GridLayout(0, 1));



        JPanel labelForCodePanel = new JPanel();
        labelForCodePanel.setLayout(new BoxLayout(labelForCodePanel, BoxLayout.Y_AXIS));
        //labelForCodePanel.setBorder(BorderFactory.createTitledBorder("Label for Code"));

        JPanel codeTextAreaPanel = new JPanel();
        codeTextAreaPanel.setLayout(new FlowLayout());
        //codeTextAreaPanel.setBorder(BorderFactory.createTitledBorder("Code Text Area"));

        labelForCodePanel.add(codeTextAreaPanel);

        codeTextField = new JTextField();
        codeTextField.setColumns(3);

        JPanel CodeTextAreaPanelBottom = new JPanel();
        //CodeTextAreaPanelBottom.setLayout(new FlowLayout());
        //CodeTextAreaPanelBottom.setBorder(BorderFactory.createTitledBorder("New Panel"));

        CodeTextAreaPanelBottom.add(codeTextField);


        JPanel joinGameButtonPanel = new JPanel();
        joinGameButtonPanel.setLayout(new FlowLayout());
        //joinGameButtonPanel.setBorder(BorderFactory.createTitledBorder("Join Game Button Panel"));

        JLabel labelForCode = new JLabel("Enter the Game Key to Join");
        //JTextField codeTextField = new JTextField();


        labelForCodePanel.add(CodeTextAreaPanelBottom);
        codeTextAreaPanel.add(labelForCode);
        joinGameButton = addButtonToPane("Join Game", joinGameButtonPanel);

        topHalf.add(labelForCodePanel);
        topHalf.add(joinGameButtonPanel);

        topPanel.setVisible(true);

    }

    public void goToWaitingForLeader() {

        topPanel.setVisible(false);

        topHalf.removeAll();
        bottomMessagePanel.removeAll();
        bottomMessage = new JLabel("Welcome!");
        bottomMessagePanel.add(bottomMessage);

        topPanel.removeAll();
        username = new JLabel(currentUser);
        topPanel.add(username);




        JLabel waitingForLeaderLabel = new JLabel("Waiting for Leader", SwingConstants.CENTER);


        topHalf.add(waitingForLeaderLabel);


        bottomMessagePanel.removeAll();
        bottomMessage = new JLabel("Joined Game: Waiting For Leader");
        bottomMessagePanel.add(bottomMessage);

        topPanel.setVisible(true);
    }

    public void goToLaunchGame() {

        topHalf.removeAll();

        topPanel.removeAll();
        username = new JLabel(currentUser);
        topPanel.add(username);


        bottomMessage = new JLabel("Enter Your Suggestion");
        bottomMessagePanel.removeAll();

        bottomMessagePanel.add(bottomMessage);

        JPanel everythingButButton = new JPanel();
        everythingButButton.setLayout(new BoxLayout(everythingButButton, BoxLayout.Y_AXIS));
        //everythingButButton.setBorder(BorderFactory.createTitledBorder("Everything But Button"));

        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BoxLayout(displayPanel, BoxLayout.Y_AXIS));
        //displayPanel.setBorder(BorderFactory.createTitledBorder("Display"));
        JLabel whatIsTheWordFor = new JLabel("What is the Word For ↓");
        displayPanel.add(whatIsTheWordFor);


        JPanel suggestedPhraseTextArea = new JPanel();
        suggestedPhraseTextArea.setLayout(new FlowLayout());
        //suggestedPhraseTextArea.setBorder(BorderFactory.createTitledBorder("Suggested Phrase Text Area"));


        output = new JTextArea(12, 32);
        output.setBackground(Color.GREEN);
        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setBackground(Color.black);
        suggestedPhraseTextArea.add(scrollPane);

        showMessage("A Group of Zebras");

        displayPanel.add(suggestedPhraseTextArea);



        JPanel yourSuggestion = new JPanel();
        yourSuggestion.setLayout(new GridLayout(1, 0));
        yourSuggestion.setBorder(BorderFactory.createTitledBorder("Your Suggestion"));

        userSuggestion = new JTextField();

        yourSuggestion.add(userSuggestion);

        everythingButButton.add(displayPanel);
        everythingButButton.add(yourSuggestion);

        topHalf.add(everythingButButton);

        submitSuggestionButton = addButtonToPane("Submit Suggestion", topHalf);


    }


    public void showMessage(String msg) {

        output.append(msg + "\n");
    }

    public static void main(String[] args) {

        FoilMakerView x = new FoilMakerView(new FoilMakerController());
    }

}
