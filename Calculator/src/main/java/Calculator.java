//import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Double.parseDouble;

/**
 * Created by pku141 on 7/24/2017.
 */
public class Calculator extends JFrame {

    private JMenuBar menuBar;
    private JMenu file;
    private JMenu edit;
    private JMenu help;
    private JMenuItem close;
    private JMenuItem copy;
    private JMenuItem view;
    private JMenuItem about;
    private JTextArea display;

    private JButton clear;
    private JButton equals;
    private JButton zero;
    private JButton decimal;
    private JButton posneg;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton addition;
    private JButton subtraction;
    private JButton multiplication;
    private JButton division;

    private double TempFirst = 0.0;
    private double tempSecond = 0.0;
    private boolean[] operation = new boolean[4];
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(" Could Not Load System Look ");
        }
        JFrame.setDefaultLookAndFeelDecorated(true);
        new Calculator();
    }

    public  Calculator(){
        super("Arya Calculator");
        sendMenuBar();
        sendDisplay();
        sendButtons();
        sendUI(this);

    }



    private void sendDisplay() {
        display =new JTextArea();
        display.setBounds(10,10,280,40);
        display.setEditable(false);
      //  display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        display.setFont(new Font("Arial",Font.PLAIN,32));
        add(display);
    }
    private void sendButtons() {
        division = new JButton("/");
        division.setBounds(226,70,65,55);
        division.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTempFirst(Double.parseDouble(display.getText()));
                display.setText("0");
                operation[0] = true;
            }
        });
        add(division);

        multiplication = new JButton("*");
        multiplication.setBounds(226,132,65,55);
        multiplication.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTempFirst(Double.parseDouble(display.getText()));
                display.setText("0");
                operation[1] = true;
            }
        });
        add(multiplication);

        addition = new JButton("+");
        addition.setBounds(226,194,65,55);
        addition.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTempFirst(Double.parseDouble(display.getText()));
                display.setText("0");
                operation[2] = true;
            }
        });
        add(addition);

        subtraction = new JButton("-");
        subtraction.setBounds(226,256,65,55);
        subtraction.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setTempFirst(Double.parseDouble(display.getText()));
                display.setText("0");
                operation[3] = true;
            }
        });
        add(subtraction);

        clear =new JButton("clear");
        clear.setBounds(154,318,137,55);
        clear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                display.setText("0");
                setTempFirst(0.0);
                for(int i =0 ;i <4 ;i++)
                    operation[i] = false;
            }
        });
        add(clear);

        equals = new JButton("=");
        equals.setBounds(10,318,137,55);
        equals.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(operation[0]){
                    setTempSecond(Double.parseDouble(display.getText()));
                    display.setText(Double.toString(getTempFirst()/getTempSecond()));
                }
                else if(operation[1]){
                   setTempSecond(Double.parseDouble(display.getText()));
                    display.setText(Double.toString(getTempFirst()*getTempSecond()));
                }
                else if(operation[2]){
                    setTempSecond(Double.parseDouble(display.getText()));
                    display.setText(Double.toString(getTempFirst()+getTempSecond()));
                }
                else if(operation[3]){
                    setTempSecond(Double.parseDouble(display.getText()));
                    display.setText(Double.toString(getTempFirst()-getTempSecond()));
                }
                if(display.getText().endsWith(".0")){
                    display.setText(display.getText().replace(".0",""));
                }
                setTempFirst(0.0);
                for(int i =0 ;i <4 ;i++)
                    operation[i] = false;


            }
        });
        add(equals);

        zero= new JButton("0");
        zero.setBounds(10,256,65,55);
        zero.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().equalsIgnoreCase("0") || display.getText().length() > 13){
                    return;
                }
                display.append("0");
            }
        });
        add(zero);



        decimal= new JButton(".");
        decimal.setBounds(82,256,65,55);
        decimal.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if(display.getText().contains("."))
                    return;
                display.append(".");
            }
        });
        add(decimal);

        posneg= new JButton("+/-");
        posneg.setBounds(152,256,65,55);
        posneg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().equalsIgnoreCase("0")){
                    return;
                }
                display.setText(Double.toString(parseDouble(display.getText())*(-1)));
                if(display.getText().endsWith(".0"))
                    display.setText(display.getText().replace(".0", ""));
            }
        });
        add(posneg);

        three= new JButton("3");
        three.setBounds(10,194,65,55);
        three.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("3");
                    return;
                }
                display.append("3");
            }
        });
        add(three);

        two= new JButton("2");
        two.setBounds(82,194,65,55);
        two.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("2");
                    return;
                }
                display.append("2");
            }
        });
        add(two);

        one= new JButton("1");
        one.setBounds(152,194,65,55);
        one.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("1");
                    return;
                }
                display.append("1");
            }
        });
        add(one);

        four= new JButton("4");
        four.setBounds(10,132,65,55);
        four.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("4");
                    return;
                }
                display.append("4");
            }
        });
        add(four);

        five= new JButton("5");
        five.setBounds(82,132,65,55);
        five.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("5");
                    return;
                }
                display.append("5");
            }
        });
        add(five);

        six= new JButton("6");
        six.setBounds(152,132,65,55);
        six.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("6");
                    return;
                }
                display.append("6");
            }
        });
        add(six);




        seven= new JButton("7");
        seven.setBounds(10,70,65,55);
        seven.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("7");
                    return;
                }
                display.append("7");
            }
        });
        add(seven);
        eight= new JButton("8");
        eight.setBounds(82,70,65,55);
        eight.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("8");
                    return;
                }
                display.append("8");
            }
        });
        add(eight);
        nine= new JButton("9");
        nine.setBounds(152,70,65,55);
        nine.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(display.getText().length() > 10)
                    return;
                if(display.getText().equalsIgnoreCase("0")){
                    display.setText("9");
                    return;
                }
                display.append("9");
            }
        });

        add(nine);


        zero= new JButton("0");
        one = new JButton("1");
        two= new JButton("2");
        three= new JButton("3");
        four= new JButton("4");
        five= new JButton("5");
        six= new JButton("6");


    }

    private void sendMenuBar() {
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        file = new JMenu(" File ");
        edit = new JMenu(" Edit ");
        help = new JMenu("Help");
        close = new JMenuItem("close");
        copy = new JMenuItem("copy");
        view = new JMenuItem("view help");
        about = new JMenuItem("about calculator");
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);
        file.add(close);
        edit.add(copy);
        help.add(view);
        help.add(about);
        close.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        copy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tempDisplay  =display.getText();
                StringSelection string = new StringSelection(tempDisplay);
                Clipboard system = Toolkit.getDefaultToolkit().getSystemClipboard();
                system.setContents(string ,string);

            }
        });
        view.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"There are no topics for help now.","Calculator Help",JOptionPane.OK_OPTION);
            }
        });
        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "can help you do easy maths \n @copyrights :Prashant,2k17","About Calculator",JOptionPane.OK_OPTION);

            }
        });

    }

    private void sendUI(Calculator app) {
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(308,430);
        app.setResizable(false);
        app.setLayout(null);
        app.setLocationRelativeTo(null);
        app.setVisible(true);
    }

    public double getTempFirst() {
        return TempFirst;
    }

    public void setTempFirst(double tempFirst) {
        TempFirst = tempFirst;
    }

    public double getTempSecond() {
        return tempSecond;
    }

    public void setTempSecond(double tempSecond) {
        this.tempSecond = tempSecond;
    }
}
