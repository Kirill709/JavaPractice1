
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends FrameTest
{
    public static void main(String[] args)
    {
        final JFrame frame = new JFrame("JDialog Demo");

        final JButton btnLogin = new JButton("Click to login");

        btnLogin.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent e) {
                        LoginDialog loginDlg = new LoginDialog(frame);
                        frame.dispose();
                        loginDlg.setVisible(true);

                        if(loginDlg.isSucceeded()){
                            btnLogin.setText("Hi " + loginDlg.getUsername() + "!");
                        }
                    }
                });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);


        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.pink);

        btnLogin.setSize(200, 50);
        btnLogin.setLocation(120,120);
        panel.add(btnLogin);

        frame.setContentPane(panel);

        frame.setVisible(true);
    }
}
