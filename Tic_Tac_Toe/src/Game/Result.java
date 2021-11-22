package Game;

import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {

    private static final long serialVersionUID = 1L;
    int height = 480;
    int width = height * 12/9;

    Result(String Massage){

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.setLayout(new BorderLayout());

        JLabel label1 = new JLabel();
        label1.setText(Massage);

        label1.setFont(new Font("MV Boli", Font.PLAIN, 50));
        label1.setForeground(Color.black);

        this.setTitle("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        this.add(panel);
        this.pack();
        panel.add(label1, BorderLayout.CENTER);

    }
}