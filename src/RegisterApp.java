
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterApp extends JFrame {

    JTextField txtUsername;
    JPasswordField txtPassword;

    public RegisterApp() {
        setTitle("Register App");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        txtPassword = new JPasswordField();

        JButton btnDaftar = new JButton("Daftar");
        JButton btnKembali = new JButton("Kembali");

        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnDaftar);
        panel.add(btnKembali);

        add(panel, BorderLayout.CENTER);

        btnDaftar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText().trim();
                String password = new String(txtPassword.getPassword());

                if (username.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(
                        RegisterApp.this,
                        "Username dan password wajib diisi!"
                    );
                    return;
                }

                LoginApp.usernameTerdaftar = username;
                LoginApp.passwordTerdaftar = password;

                JOptionPane.showMessageDialog(
                    RegisterApp.this,
                    "Registrasi berhasil!"
                );

                new LoginApp();
                dispose();
            }
        });

        btnKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new LoginApp();
                dispose();
            }
        });

        setVisible(true);
    }
}
