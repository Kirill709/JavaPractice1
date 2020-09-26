import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.*;
import java.io.FileNotFoundException;


public class FrameTest {

    private JFrame frame1=new JFrame("WELCOME");

    static ImageIcon imageIcon;
    static String s="";
    static JTextField  testField;

    FrameTest()
    {

        final JLabel label1 =new JLabel();

        imageIcon = new ImageIcon(new ImageIcon("D:\\For study\\progs\\interface\\mama_byb.jpeg").getImage().getScaledInstance(300, 300, Image.SCALE_DEFAULT));
        label1.setIcon(imageIcon);

        GridLayout experimentLayout = new GridLayout(0,4);

        frame1.setLayout (experimentLayout);
        frame1.setLayout (new FlowLayout());


        frame1.add(label1);

        JButton button1 = new JButton("Click me!!!");
        frame1.add(button1);
        frame1.setVisible(true);

        JButton button2 = new JButton("Add photo");
        frame1.add(button2);
        frame1.setVisible(true);

        JButton button3 = new JButton("Reader");
        frame1.add(button3);
        frame1.setVisible(true);

        JButton button4 = new JButton("Writer");
        frame1.add(button4);
        frame1.setVisible(true);

        button1.setBounds(300, 50, 250, 30);
        button2.setBounds(300, 120, 250, 30);
        button3.setBounds(300, 190, 250, 30);
        button4.setBounds(300, 260, 250, 30);

        button1.addActionListener(new ActionListener() {
                                      public void actionPerformed(ActionEvent e) {
                                          Window app = new Window();
                                          app.setVisible(true);
                                      }
                                  }
        );

        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JFileChooser file = new JFileChooser();
                //file.setCurrentDirectory(new File(System.getProperty("user.home")));

                FileNameExtensionFilter filter = new FileNameExtensionFilter("*.Images", "jpg","gif","png");
                file.addChoosableFileFilter(filter);
                int result = file.showSaveDialog(null);

                if(result == JFileChooser.APPROVE_OPTION){
                    File selectedFile = file.getSelectedFile();
                    String path = selectedFile.getAbsolutePath();

                    ImageIcon MyImage = new ImageIcon(path);
                    Image img = MyImage.getImage();
                    Image newImg = img.getScaledInstance(label1.getWidth(), label1.getHeight(), Image.SCALE_DEFAULT);

                    ImageIcon image = new ImageIcon(newImg);

                    imageIcon=image;

                    label1.setIcon(image);
                }

                else if(result == JFileChooser.CANCEL_OPTION){
                    System.out.println("No File Select");
                }
            }
        });

        button3.addActionListener(new ActionListener() {

                                      public void actionPerformed(ActionEvent e)
                                      {
                                          try {
                                              new Read();
                                          } catch (FileNotFoundException ex) {
                                              ex.printStackTrace();
                                          }
                                      }
                                  }
        );

        button4.addActionListener(new ActionListener()
                                  {
                                      public void actionPerformed(ActionEvent e)
                                      {
                                          Write app = new Write();
                                          app.setVisible(true);
                                      }
                                  }
        );

        frame1.setSize(600,400);

        frame1.getContentPane().setBackground(Color.PINK);

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());

        JLabel label= new JLabel ("What can i say except " + "you Welcome");

        label.setVerticalAlignment(JLabel.TOP);

        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setForeground(Color.white);

        frame1.add(label);

        frame1.setVisible(true);
    }

    public static void main(String[] args)
    {
        new FrameTest();
    }
}