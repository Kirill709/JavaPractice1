import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class LoginDialog extends JDialog
{
    private JTextField tfUsername;
    private JPasswordField pfPassword;
    private JLabel lbUsername;
    private JLabel lbPassword;
    private JButton btnLogin;
    private JButton btnCancel;
    private boolean succeeded;

    static FrameTest my;

    public LoginDialog(Frame parent)
    {
        super(parent, "Login", true);

        lbUsername = new JLabel("Username: ");
        tfUsername = new JTextField(20);
        lbPassword = new JLabel("Password: ");
        pfPassword = new JPasswordField(20);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,2,5,5));
        panel.setBackground(Color.pink);

        panel.add(lbUsername);
        panel.add(tfUsername);
        panel.add(lbPassword);
        panel.add(pfPassword);
        panel.setBorder(new LineBorder(Color.GRAY));

        btnLogin = new JButton("Login");

        btnLogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (Login.authenticate(getUsername(), getPassword()))
                {
                    JOptionPane.showMessageDialog(LoginDialog.this,
                            "Hi " + getUsername() + "! You have successfully logged in.",
                            "Login",
                            JOptionPane.INFORMATION_MESSAGE);
                    succeeded = true;
                    dispose();
                    my=new FrameTest();
                } else {
                    JOptionPane.showMessageDialog(LoginDialog.this,
                            "Invalid username or password",
                            "Login",
                            JOptionPane.ERROR_MESSAGE);

                    tfUsername.setText("");
                    pfPassword.setText("");
                    succeeded = false;
                }
            }
        });
        btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        JPanel bp = new JPanel();
        bp.add(btnLogin);
        bp.add(btnCancel);

        getContentPane().add(panel, BorderLayout.CENTER);
        getContentPane().add(bp, BorderLayout.PAGE_END);

        pack();
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    public String getUsername() {
        return tfUsername.getText().trim();
    }

    public String getPassword() {
        return new String(pfPassword.getPassword());
    }

    public boolean isSucceeded() {
        return succeeded;
    }
}