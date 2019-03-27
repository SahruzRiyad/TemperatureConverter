import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TempConvert extends JFrame {
    String a;
    double result,ans;
    JTextField jtx1 = new JTextField();
    JTextField jtx2 = new JTextField();
    Container cnt = new Container();
    Font fnt = new Font("Arial", Font.BOLD, 18);
    Font fnt1 = new Font("Arial",Font.BOLD,16);
    JRadioButton cel = new JRadioButton("Celsious(C)");
    JRadioButton cel1 = new JRadioButton("Celsious(C)");
    JRadioButton kel = new JRadioButton("Kelvin(K)");
    JRadioButton kel1 = new JRadioButton("Kelvin(K)");
    JRadioButton foren = new JRadioButton("Fahrenheit(F)");
    JRadioButton foren1 = new JRadioButton("Fahrenheit(F)");
    JRadioButton rankine = new JRadioButton("Rankine(Rn)");
    JRadioButton rankine1 = new JRadioButton("Rankine(Rn)");
    ButtonGroup grp1 = new ButtonGroup();
    ButtonGroup grp2 = new ButtonGroup();
    JLabel lbl1 = new JLabel("Enter Number:");
    JLabel lbl2 = new JLabel("Result:");
    JLabel lbl3 = new JLabel("From");
    JLabel lbl4 = new JLabel("To");

    TempConvert() {
        make_frame();
        set_component();
        set_action();
    }

    void make_frame() {
        this.setVisible(true);
        this.setResizable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(500, 200, 600, 600);
        this.setTitle("Temp_Converter");
        this.setLayout(null);
    }

    void set_component() {
        cnt = this.getContentPane();
        jtx1.setBounds(200, 30, 300, 50);
        jtx1.setFont(fnt1);jtx2.setFont(fnt1);
        jtx2.setBounds(200, 100, 300, 50);
        cnt.add(jtx1);
        cnt.add(jtx2);
        lbl1.setFont(fnt);
        lbl2.setFont(fnt);
        lbl3.setFont(fnt);
        lbl4.setFont(fnt);
        lbl1.setBounds(50, 30, 200, 50);
        lbl2.setBounds(50, 100, 100, 50);
        lbl3.setBounds(80, 200, 100, 50);
        lbl4.setBounds(330, 200, 100, 50);
        jtx2.setEditable(false);
        cnt.add(lbl1);
        cnt.add(lbl2);
        cnt.add(lbl3);
        cnt.add(lbl4);
        cel.setBounds(85, 250, 200, 50);
        kel.setBounds(85, 290, 200, 50);
        foren.setBounds(85, 330, 200, 50);
        rankine.setBounds(85, 370, 200, 50);
        grp1.add(cel);
        grp1.add(foren);
        grp1.add(kel);
        grp1.add(rankine);
        cnt.add(cel);
        cnt.add(kel);
        cnt.add(rankine);
        cnt.add(foren);

        cel1.setBounds(340, 250, 200, 50);
        kel1.setBounds(340, 290, 200, 50);
        foren1.setBounds(340, 330, 200, 50);
        rankine1.setBounds(340, 370, 200, 50);
        grp2.add(cel1);
        grp2.add(foren1);
        grp2.add(kel1);
        grp2.add(rankine1);
        cnt.add(cel1);
        cnt.add(kel1);
        cnt.add(rankine1);
        cnt.add(foren1);

    }

    void set_action() {
        jtx1.requestFocus();
        jtx1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char ch = e.getKeyChar();
                if (!(ch >= '0' && ch <= '9')) {
                    Toolkit tk = Toolkit.getDefaultToolkit();
                    tk.beep();
                    e.consume();
                }
            }
        });
        try {
            cel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    a = jtx1.getText();
                    result = Double.parseDouble(a);
                }
            });
            kel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    a = jtx1.getText();
                    result = Double.parseDouble(a);
                    result = result - 273;
                }
            });
            foren.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    a = jtx1.getText();
                    result = Double.parseDouble(a);
                    result = (result - 32) * (5.00 / 9.00);
                }
            });
            rankine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    a = jtx1.getText();
                    result = Double.parseDouble(a);
                    result = (result - 459.67) * (5.00 / 9.00);
                }
            });
            cel1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    a = Double.toString(result);
                    jtx2.setText(a + "°C");

                }
            });
            kel1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ans = result + 273;
                    a = Double.toString(ans);
                    jtx2.setText(a + "°K");
                }
            });
            foren1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ans = result * (9.00 / 5.00) + 32;
                    a = Double.toString(ans);
                    jtx2.setText(a + "°F");
                    result = 0;
                }
            });
            rankine1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ans = result * (9.00 / 5.00) + 459.67;
                    a = Double.toString(ans);
                    jtx2.setText(a + "°Rn");
                    result = 0;
                }
            });
        }catch (Exception e1){

        }
    }


    public static void main(String[] args) {

        TempConvert tmp = new TempConvert();
    }
}
