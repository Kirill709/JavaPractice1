
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Window extends JFrame {

    private JButton button = new JButton("Press");
    private JTextField input = new JTextField("", 5);
    private JLabel label = new JLabel("Input: ");
    private JRadioButton radio1 = new JRadioButton("Radio 1 ");
    private JRadioButton radio2 = new JRadioButton("Radio 2 ");
    private JCheckBox check = new JCheckBox("Check", false);

    public Window ()
    {
        super("Simple Example");
        this.setBounds(100, 100, 250, 100);
        //	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(check);
        button.addActionListener(new ButtonEventListener());
        container.add(button);
    }
    class ButtonEventListener implements ActionListener{
        public void actionPerformed (ActionEvent e) {
            String message = "";
            message += "Hello\n";
            message += "You introduced " + input.getText() + "\n";
            message += (radio1.isSelected() ? "Radio 1 " : "Radio 2 ") + "Selected\n";
            message += "Check=" + ((check.isSelected()) ? "With check" : "without check");
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    }
}

