import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Window extends JFrame{
    static BufferedImage img;
    Lab1 lab=new Lab1();
    private JTextField textField;
    static JFileChooser chooser;
    static File file;
    JTextField field1,field2,field3,field4;



    public static void window1() throws IOException {
        chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        file=chooser.getSelectedFile();
        img = ImageIO.read(file);
    }



    public Window() {
        super("Test frame");
        newWindow();
    }

    public void newWindow(){
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button1 = new JButton("Average");
        button1.setActionCommand("Button 1 was pressed!");
        panel.add(button1);

        JButton button2 = new JButton("Human Eye");
        button2.setActionCommand("Button 2 was pressed!");
        panel.add(button2);

        JButton button3 = new JButton("Desaturation");
        button3.setActionCommand("Button 3 was pressed!");
        panel.add(button3);

        JButton button4 = new JButton("Gradation");
        button4.setActionCommand("Button 3 was pressed!");
        panel.add(button4);

        JButton button5 = new JButton("Components");
        button5.setActionCommand("Button 3 was pressed!");
        panel.add(button5);

        JButton button6 = new JButton("Histogramm");
        button6.setActionCommand("Button 6 was pressed!");
        panel.add(button6);

        JButton button7 = new JButton("Эквализация");
        button6.setActionCommand("Button 7 was pressed!");
        panel.add(button7);

        ActionListener actionListener = new TestActionListener();
        ActionListener actionListener1 = new TestActionListener1();
        ActionListener actionListener2 = new TestActionListener2();
        ActionListener actionListener3 = new TestActionListener3();
        ActionListener actionListener4 = new TestActionListener4();
        ActionListener actionListener5 = new TestActionListener5();
        ActionListener actionListener6 = new TestActionListener6();


        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener1);
        button3.addActionListener(actionListener2);
        button4.addActionListener(actionListener3);
        button5.addActionListener(actionListener4);
        button6.addActionListener(actionListener5);
        button7.addActionListener(actionListener6);

        getContentPane().add(panel);
        setPreferredSize(new Dimension(520, 400));
    }

    public void niblack_panel(){
        JPanel panel=new JPanel();
        Frame nFrame = new Frame();
        nFrame.setSize(750, 900);
        nFrame.add(panel);

        field3 = new JTextField("К: ", 5);
        field4=new JTextField("W:", 5);
        JButton button1 = new JButton("Применить");
        panel.add(field3);
        panel.add(field4);
        panel.add(button1);
        ActionListener actionListener = new TestActionListener11();
        button1.addActionListener(actionListener);
        panel.setVisible(true);
        nFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                nFrame.setVisible(false);
            }
        });
        nFrame.pack();
        nFrame.setLocationRelativeTo(null);
        nFrame.setVisible(true);
        return;
    }


    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                double[][] s;
                s=lab.average(img);
                File f=new File(Lab1.im1);
                Desktop dt = Desktop.getDesktop();
                dt.open(f);
                dt.open(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    public class TestActionListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                lab.humanEye(img);
                File f=new File(Lab1.im2);
                Desktop dt = Desktop.getDesktop();
                dt.open(f);
                dt.open(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    public class TestActionListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                lab.desaturation(img);
                File f=new File(Lab1.im3);
                Desktop dt = Desktop.getDesktop();
                dt.open(f);
                dt.open(file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    public class TestActionListener3 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                lab.max_gradation(img);
                lab.min_gradation(img);
                File f1=new File(Lab1.im4);
                File f2=new File(Lab1.im5);
                Desktop dt = Desktop.getDesktop();
                dt.open(file);
                dt.open(f1);
                dt.open(f2);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    public class TestActionListener4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                lab.components(img);
                File f1 = new File(Lab1.im6);
                File f2 = new File(Lab1.im7);
                File f3 = new File(Lab1.im8);
                Desktop dt = Desktop.getDesktop();
                dt.open(file);
                dt.open(f1);
                dt.open(f2);
                dt.open(f3);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class TestActionListener5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double[] s ;
            try {
                s=Lab1.buildHistogram(img);
                Histogram.getImage1(lab.result,s);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public class TestActionListener6 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double[] s = new double[0];
            try {
                s = Lab1.buildHistogram(img);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            try {
                Lab1.Equalization(s, img);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }
    public class TestActionListener11 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            double k=Double.parseDouble(field3.getText());
            int w=Integer.parseInt(field4.getText());
            try {
                lab.niblack(k,w,img);
                File f=new File(Lab1.im10);
                Desktop dt = Desktop.getDesktop();
                dt.open(f);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }




    public static void main(String[] args) throws IOException {
        Window frame = new Window();
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

