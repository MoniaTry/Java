package Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    int height = 480;
    int width = height * 12/9;

    JButton button1 = new JButton();

    MyFrame(){

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.setLayout(new BorderLayout());

        JPanel panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(width, (int) (0.6 * height)));

        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(width, (int) (0.4 * height)));

        JLabel label1 = new JLabel();
        label1.setText("Tic Tac Toe");
        label1.setFont(new Font("MV Boli", Font.PLAIN, 50));
        label1.setForeground(Color.black);

        button1.setPreferredSize(new Dimension(200, 100));
        button1.addActionListener(this);
        button1.setText("New Game");
        button1.setFont(new Font("MV Boli", Font.PLAIN, 30));

        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        this.add(panel);
        this.pack();
        panel.add(panel1, BorderLayout.CENTER);
        panel.add(panel2, BorderLayout.NORTH);
        panel1.add(button1, BorderLayout.CENTER);
        panel2.add(label1, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1)
        {
            this.dispose();
            GameFrame frame2 = new GameFrame();
        }
    }
}