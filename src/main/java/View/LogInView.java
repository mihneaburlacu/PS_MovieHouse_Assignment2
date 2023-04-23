package View;

import Model.Enums.Role;
import Model.User;
import ViewModel.VMLogin;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingType;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class LogInView extends JFrame{

    private JPanel contentPane;
    private JButton LogInButton;
    private JLabel welcomeLabel;
    private JLabel logInLabel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    @Bind(value = "text", target = "usernameTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JTextField usernameTextField;
    @Bind(value = "text", target = "passwordTextField.value", type = BindingType.BI_DIRECTIONAL)
    private JPasswordField passwordTextField;
    private JLabel imageLabel;
    private VMLogin viewModelLogin;

    public LogInView() {
        setTitle("MovieHouse");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 710, 430);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        LogInButton = new JButton("Log In");
        LogInButton.setFont(new Font("Times New Roman", Font.BOLD, 26));
        LogInButton.setBounds(250, 320, 157, 40);
        contentPane.add(LogInButton);

        welcomeLabel = new JLabel("Welcome to the Movie House Application!");
        welcomeLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
        welcomeLabel.setBounds(70, 10, 550, 65);
        contentPane.add(welcomeLabel);

        logInLabel = new JLabel("Please log in into your account!");
        logInLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        logInLabel.setBounds(155, 65, 360, 50);
        contentPane.add(logInLabel);

        usernameLabel = new JLabel("Username:");
        usernameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        usernameLabel.setBounds(25, 160, 100, 30);
        contentPane.add(usernameLabel);

        passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        passwordLabel.setBounds(25, 230, 100, 30);
        contentPane.add(passwordLabel);

        usernameTextField = new JTextField();
        usernameTextField.setBounds(135, 160, 240, 30);
        contentPane.add(usernameTextField);
        usernameTextField.setColumns(10);

        passwordTextField = new JPasswordField();
        passwordTextField.setColumns(10);
        passwordTextField.setBounds(135, 230, 240, 30);
        contentPane.add(passwordTextField);

        imageLabel = new JLabel("");
        ImageIcon img = new ImageIcon("src/Images/movie.png");
        imageLabel.setIcon(img);
        imageLabel.setBounds(454, 112, 166, 194);
        contentPane.add(imageLabel);

        viewModelLogin = new VMLogin();
        try{
            Binder.bind(this, viewModelLogin);
        } catch(Exception ex) {
            System.out.println("\nError with binding at LogIn\n");
            ex.printStackTrace();
        }

        addLogInListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModelLogin.loginCommand.execute();
            }
        });
    }

    public void addLogInListener(ActionListener actionListener) {
        this.LogInButton.addActionListener(actionListener);
    }
}
