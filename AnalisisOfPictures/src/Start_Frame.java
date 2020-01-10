import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.tabbedui.VerticalLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Start_Frame extends JFrame {
    JTextField field1, field2;
    JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));
    String str1="";
    String str2="";
    int width;
    int height;
    JTextField[] field = new JTextField[0];


    public Start_Frame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pan1=new JPanel();
        JButton button1 = new JButton("Задание 1");
        JButton button2 = new JButton("Задание 2");
        JButton button3 = new JButton("Задание 3");
        JButton button4 = new JButton("Задание 4");
        JButton button5 = new JButton("Задание 5");
        pan1.add(button1);
        pan1.add(button2);
        pan1.add(button3);
        pan1.add(button4);
        pan1.add(button5);
        ActionListener actionListener1 = new TestActionListeners.TestActionListener9();
        ActionListener actionListener2 = new TestActionListeners.TestActionListener6();
        ActionListener actionListener3 = new TestActionListeners.TestActionListener10();
        ActionListener actionListener4= new TestActionListeners.TestActionListener4();
        ActionListener actionListener5= new TestActionListeners.TestActionListener10();
        button1.addActionListener(actionListener1);
        button2.addActionListener(actionListener3);
        button3.addActionListener(actionListener2);
        button4.addActionListener(actionListener5);
        button5.addActionListener(actionListener4);
        getContentPane().add(pan1);
        setPreferredSize(new Dimension(520, 400));
    }

    public void coding1(){
        field1 = new JTextField("Кодируемое слово", 25);
        field1.setToolTipText("Слово");
        JButton button1 = new JButton("Закодировать");
        field2 = new JTextField("Раскодировать", 25);
        field2.setToolTipText("Раскодировать");
        JButton button2 = new JButton("Раскодировать");
        contents.add(field1);
        contents.add(button1);
        contents.add(field2);
        contents.add(button2);
        setContentPane(contents);
        setSize(450, 130);
        setVisible(true);
        ActionListener actionListener = new TestActionListeners.TestActionListener7();
        ActionListener actionListener1 = new TestActionListeners.TestActionListener8();
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener1);

    }

    public void matrica(){
        JPanel panel1=new JPanel();
        Frame nFrame = new Frame();
        nFrame.setSize(750, 900);
        field1 = new JTextField("Ширина", 5);
        field2=new JTextField("Высота", 5);
        JButton button1 = new JButton("Применить");
        panel1.add(field1);
        panel1.add(field2);
        panel1.add(button1);
        nFrame.add(panel1);
        ActionListener actionListener = new TestActionListeners.TestActionListener1();
        button1.addActionListener(actionListener);
        nFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                nFrame.setVisible(false);
            }
        });
        nFrame.pack();
        nFrame.setLocationRelativeTo(null);
        nFrame.setVisible(true);
    }

    public void fifth(){
        JFrame frame=new JFrame();
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button3 = new JButton("Оцу");
        panel.add(button3);

        JButton button2 = new JButton("Ниблэк");
        panel.add(button2);

        ActionListener actionListener5 = new TestActionListeners.TestActionListener5();
        ActionListener actionListener6 = new TestActionListeners.TestActionListener11();


        button3.addActionListener(actionListener5);
        button2.addActionListener(actionListener6);


        panel.setPreferredSize(new Dimension(520, 400));
        frame.setBounds(500,300,400,200);
        frame.setContentPane(panel);
        panel.setVisible(true);
        frame.setVisible(true);


    }

    public void matrica_1() {
        JFrame contents1 = new JFrame();
        JPanel panel = new JPanel();
        width = Integer.parseInt(str1);
        height = Integer.parseInt(str2);
        if (((width == 1) || (width == 0)) && ((height == 1) || (height == 0))) {
            String str = "Введена неверная ширина или высота";
            JOptionPane.showMessageDialog(contents1, str);
        } else {
            VerticalLayout layout = new VerticalLayout();
            contents1.setLayout(layout);
            panel.setSize(500, 200);
            GridLayout layout1 = new GridLayout(height, width, 5, 5);
            panel.setLayout(layout1);
            JButton button1 = new JButton("Filter");
            JButton button2 = new JButton("Morphology");
            field = new JTextField[width * height];
            int k = 0;
            int i = 0;
            int j = 0;
            for (i = 0; i < width; i++) {
                for (j = 0; j < height; j++) {
                    field[k] = new JTextField("0", 5);
                    panel.add(field[k]);
                    k++;
                }
            }
            contents1.add(panel);
            contents1.add(button1);
            contents1.add(button2);
            ActionListener actionListener = new TestActionListeners.TestActionListener2();
            ActionListener actionListener2 = new TestActionListeners.TestActionListener12();
            button1.addActionListener(actionListener);
            button2.addActionListener(actionListener2);
            contents1.setSize(500, 400);
            javax.swing.SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    contents1.pack();
                    contents1.setLocationRelativeTo(null);
                    contents1.setVisible(true);
                }
            });
        }
    }

    public void morphology(){
        JFrame contents1 = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton button3 = new JButton("Дилатация");
        panel.add(button3);

        JButton button2 = new JButton("Эрозия");
        panel.add(button2);

        JButton button4 = new JButton("Размыкание");
        panel.add(button4);

        JButton button5 = new JButton("Замыкание");
        panel.add(button5);

        ActionListener actionListener5 = new TestActionListeners.TestActionListener13();
        ActionListener actionListener6 = new TestActionListeners.TestActionListener14();
        ActionListener actionListener7 = new TestActionListeners.TestActionListener15();
        ActionListener actionListener8 = new TestActionListeners.TestActionListener16();


        button3.addActionListener(actionListener5);
        button2.addActionListener(actionListener6);
        button4.addActionListener(actionListener7);
        button5.addActionListener(actionListener8);


        panel.setPreferredSize(new Dimension(520, 400));
        contents1.setBounds(500,300,400,200);
        contents1.setContentPane(panel);
        panel.setVisible(true);
        contents1.setVisible(true);
    }



    public static void main(String[] args) throws IOException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Start_Frame frame = new Start_Frame();
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }


}
