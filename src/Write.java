import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.awt.FlowLayout;

public class Write extends JFrame
{

    JTextField smallField;

    public Write()
    {
        super("2");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        smallField = new JTextField(15);
        smallField.setToolTipText("1");
        smallField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] list = {smallField.getText()};
                try {
                    File file = new File("D:\\For study\\progs\\interface\\10.txt");
                    FileWriter fileWriter = new FileWriter(file);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    for(String s : list)
                    {
                        bufferedWriter.write(s + "\n");
                    }
                    bufferedWriter.close();
                } catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        });

        JPanel A1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        A1.add(smallField);
        setContentPane(A1);
        setBounds(600, 100, 600, 400);
        setVisible(true);
    }
    public static void main(String[] args)
    {
        new Write();
    }
}
