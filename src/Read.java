import java.awt.Container;
import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.*;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

import java.nio.channels.*;
import java.util.ArrayList;
import java.nio.*;
import java.util.List;
import java.util.Scanner;


public class Read {
    Read() throws FileNotFoundException {
        JFrame Window = new JFrame("Writer");
        Window.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        Container myPane = Window.getContentPane();
        myPane.setLayout(new BoxLayout(myPane, BoxLayout.Y_AXIS));
        // Window.add(getButtonPanel());
        Window.pack();
        Window.setVisible(true);
        Window.setBounds(100, 100, 600, 400);

        String Line = "Bacik walume";

        try
        {
            File Data = new File("D:\\For study\\progs\\interface\\10.txt");
            List<String> list = new ArrayList<>();
            Scanner in = new Scanner(Data);
            while (in.hasNextLine())
                list.add(in.nextLine());
            String[] SInfo = list.toArray(new String[0]);
            for (int i = 0; i < 1; i++)
            {
                Line = SInfo[i];
            }
                JTextArea A1 = new JTextArea(Line);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        JLabel A2 = new JLabel(Line);
        Window.add(A2);
    }
}
