import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * CS180 Project03
 * <p>
 * Foil Login Program.
 *
 * @author Kyle Brown, brow1144, G01
 * @version 10/24/16
 */

public class FoilMakerView extends JFrame implements ActionListener {

    protected JFrame topFrame;

    protected JPanel topPanel;
    protected JPanel topHalf;
    protected JPanel bottomMessagePanel;

    protected JTextField usernameTextField;
    protected JPasswordField passwordTextField;
    protected JLabel usernameLabel;
    protected JLabel passwordLabel;

    protected JButton loginButton;
    protected JButton registerButton;
    protected JButton startNewGameButton;
    protected JButton joinAGameButton;


    protected String currentUser;
    protected String password;


    public FoilMakerView() {

/*
        topFrame = new JFrame();
        topFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        topFrame.setSize(400, 600);

        topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.setBorder(BorderFactory.createTitledBorder("Top Panel"));

        topHalf = new JPanel();
        topHalf.setLayout(new FlowLayout());
        topHalf.setBorder(BorderFactory.createTitledBorder("Top Half"));

        bottomMessagePanel = new JPanel();
        bottomMessagePanel.setLayout(new FlowLayout());
        bottomMessagePanel.setBorder(BorderFactory.createTitledBorder("Bottom Message Panel"));

        topFrame.add(topPanel, BorderLayout.NORTH);
        topFrame.add(topHalf, BorderLayout.CENTER);
        topFrame.add(bottomMessagePanel, BorderLayout.SOUTH);
        */

        goToLoginPanel();

    }


    public void goToLoginPanel() {

        topFrame = new JFrame();
        topFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        topFrame.setSize(400, 600);
        topFrame.setTitle("FoilMaker");

        topFrame.setLocationRelativeTo(null);
        topFrame.setLayout(new BorderLayout());

//Top Panel (aka usernamePanel)
        topPanel = new JPanel();
        //topPanel.setBorder(BorderFactory.createTitledBorder("Top Panel"));
        JLabel username = new JLabel("FoilMaker!");
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
        usernameLabel = new JLabel("Userame");
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
        JLabel bottomMessage = new JLabel("New User Created");

        bottomMessagePanel.add(bottomMessage);


        topFrame.add(topPanel, BorderLayout.NORTH);
        topFrame.add(bottomMessagePanel, BorderLayout.SOUTH);

        topFrame.setVisible(true);

    }

    protected JButton addButtonToPane(String text, Container pane) {
        JButton button = new JButton(text);
        pane.add(button);
        button.addActionListener(this);
        return button;
    }

    public void goToNewGamePanel() {
        //remove pane from login panel
        //add the new things

        goToLoginPanel();
        topHalf.removeAll();

        startNewGameButton = addButtonToPane("Start a New Game", topHalf);
        joinAGameButton = addButtonToPane("Join a Game", topHalf);

        topFrame.setVisible(true);



    }


    public void handleButtonAction (ActionEvent e){

            JButton button = (JButton) e.getSource();

            currentUser = usernameTextField.getText();


            //Make better later
            if (currentUser == null) {
                currentUser = "NOT VALID USERNAME";
            }

            password = passwordTextField.getText();

            if (password == null) {
                password = "NOT VALID PASSWORD";
            }


            if (button == loginButton) {
                //showMessage(username + " is Logging In" + "\n" +
                //username + " Password is: " + password + "\n");
                System.out.println(currentUser + " is logging in" + "\n");
                goToNewGamePanel();

            } else if (button == registerButton) {
                //showMessage(username + " is Registering" + "\n" +
                //username + " Password is: " + password + "\n");
                System.out.println("New User: " + currentUser + " is Registering" + "\n");
                goToNewGamePanel();
            }
        }

        public void actionPerformed (ActionEvent e){
            Object source = e.getSource();
            if (source instanceof JButton) {
                handleButtonAction(e);
            }
        }


    public static void main(String[] args) {

        FoilMakerView frame = new FoilMakerView();
        frame.pack();
        frame.setVisible(true);

    }

}
