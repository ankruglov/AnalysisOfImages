import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TestActionListeners {
    static Lab1 lab=new Lab1();
    static Window wind=new Window();
    static Start_Frame startFrame=new Start_Frame();



    public static class TestActionListener6 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            startFrame.coding1();
        }
    }

    static class TestActionListener7 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                startFrame.str1=startFrame.field1.getText();
                String str=lab.coding(startFrame.str1);
                JOptionPane.showMessageDialog(startFrame.contents, str);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    static class TestActionListener8 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                startFrame.str2=startFrame.field2.getText();
                String str=lab.unCoding(startFrame.str2);
                JOptionPane.showMessageDialog(startFrame.contents, str);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    static class TestActionListener9 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                Window.window1();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Window frame = new Window();
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
        }
    }
    static class TestActionListener10 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                wind.window1();
                startFrame.matrica();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    static class TestActionListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            startFrame.str1= startFrame.field1.getText();
            startFrame.str2=startFrame.field2.getText();
            startFrame.matrica_1();
        }
    }
    static class TestActionListener2 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Double[][] av=new Double[startFrame.width][startFrame.height];
            int k=0;
            String s;
            for (int  i = 0; i < startFrame.width; i++) {
                for (int j = 0; j < startFrame.height; j++) {
                    s=startFrame.field[k].getText();
                    av[i][j]=Double.parseDouble(s);
                    k++;
                }
            }
            try {
                lab.filter(av, startFrame.width, startFrame.height, wind.img);
                Desktop dt = Desktop.getDesktop();
                dt.open(wind.file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    public static class TestActionListener4 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            startFrame.fifth();
        }
    }
    public static class TestActionListener5 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                wind.window1();
                lab.ocu(wind.img);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    public static class TestActionListener11 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {

                wind.window1();
                wind.niblack_panel();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static class TestActionListener12 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            startFrame.morphology();
        }
    }

    public static class TestActionListener13 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BufferedImage image;
            try {
                Desktop dt = Desktop.getDesktop();
                dt.open(wind.file);
                image = ImageIO.read(wind.file);
                Double[][] av = new Double[startFrame.width][startFrame.height];
                int k = 0;
                String s;
                for (int i = 0; i < startFrame.width; i++) {
                    for (int j = 0; j < startFrame.height; j++) {
                        s = startFrame.field[k].getText();
                        av[i][j] = Double.parseDouble(s);
                        k++;
                    }
                }

                BufferedImage bool=lab.dilatation(image, av);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static class TestActionListener14 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BufferedImage image;
            try {
                Desktop dt = Desktop.getDesktop();
                dt.open(wind.file);
                image = ImageIO.read(wind.file);
                Double[][] av = new Double[startFrame.width][startFrame.height];
                int k = 0;
                String s;
                for (int i = 0; i < startFrame.width; i++) {
                    for (int j = 0; j < startFrame.height; j++) {
                        s = startFrame.field[k].getText();
                        av[i][j] = Double.parseDouble(s);
                        k++;
                    }
                }

                BufferedImage bool=lab.erosian(image, av);

            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }


    public static class TestActionListener15 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BufferedImage image;
            try {
                Desktop dt = Desktop.getDesktop();
                dt.open(wind.file);
                image = ImageIO.read(wind.file);
                Double[][] av = new Double[startFrame.width][startFrame.height];
                int k = 0;
                String s;
                for (int i = 0; i < startFrame.width; i++) {
                    for (int j = 0; j < startFrame.height; j++) {
                        s = startFrame.field[k].getText();
                        av[i][j] = Double.parseDouble(s);
                        k++;
                    }
                }
                BufferedImage bool = lab.erosian(image, av);
                lab.dilatation(bool, av);
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    public static class TestActionListener16 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            BufferedImage image;
            try {
                Desktop dt = Desktop.getDesktop();
                dt.open(wind.file);
                image = ImageIO.read(wind.file);
                Double[][] av = new Double[startFrame.width][startFrame.height];
                int k = 0;
                String s;
                for (int i = 0; i < startFrame.width; i++) {
                    for (int j = 0; j < startFrame.height; j++) {
                        s = startFrame.field[k].getText();
                        av[i][j] = Double.parseDouble(s);
                        k++;
                    }
                }
                BufferedImage bool = lab.dilatation(image, av);
                lab.erosian(bool, av);

            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
    }
}
