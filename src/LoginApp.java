
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginApp extends JFrame {

    static String usernameTerdaftar = "";
    static String passwordTerdaftar = "";

    JTextField txtUsername;
    JPasswordField txtPassword;

    public LoginApp() {
        setTitle("Login App");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        JButton btnRegister = new JButton("Register");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnRegister);

        add(panel, BorderLayout.CENTER);

        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String password = new String(txtPassword.getPassword());

                if (username.equals(usernameTerdaftar)
                        && password.equals(passwordTerdaftar)
                        && !usernameTerdaftar.isEmpty()) {

                    JOptionPane.showMessageDialog(
                        LoginApp.this,
                        "Login berhasil! Selamat datang, " + username
                    );

                } else {
                    JOptionPane.showMessageDialog(
                        LoginApp.this,
                        "Username atau password salah!"
                    );
                }
            }
        });

        btnRegister.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RegisterApp();
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginApp());
    }
}
